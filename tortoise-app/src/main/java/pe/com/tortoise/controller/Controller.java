package pe.com.tortoise.controller;

import java.util.HashMap;
import java.util.Map;
import pe.com.tortoise.model.business.Categoria;
import pe.com.tortoise.model.business.Producto;
import pe.com.tortoise.model.persistence.CategoriaDao;
import pe.com.tortoise.model.persistence.ProductoDao;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

public class Controller {
    
    public static void main(String[] args) {
        port(7777);
        
        get("/", (request, response) -> {
            response.redirect("/Catalogo");
            return null;
        });
        
        get("/Catalogo", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("productos", ProductoDao.obtenerProductos());
            attributes.put("templateName", "catalogo.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Productos", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("productos", ProductoDao.obtenerProductos());
            attributes.put("templateName", "mantenimientoProductos.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Categorias", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("categorias", CategoriaDao.obtenerCategorias());
            attributes.put("templateName", "mantenimientoCategorias.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Productos/Registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("categorias", CategoriaDao.obtenerCategorias());
            attributes.put("templateName", "formularioProducto.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Categorias/Registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("templateName", "formularioCategoria.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        post("/Mantenimiento/Productos/Registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String nombre = request.queryParams("txtNombre");
            Integer idCategoria = Integer.parseInt(request.queryParams("txtCategoria"));
            Categoria categoria = CategoriaDao.obtenerCategoria(idCategoria);
            Double precio = Double.parseDouble(request.queryParams("txtPrecio"));
            Integer stock = Integer.parseInt(request.queryParams("txtStock"));
            Producto producto = new Producto(nombre, stock, precio, categoria);
            ProductoDao.insertarProducto(producto);
            response.redirect("/Mantenimiento/Productos");
            return null;
        });
        
        post("/Mantenimiento/Categorias/Registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String descripcion = request.queryParams("txtDescripcion");
            Categoria categoria = new Categoria(descripcion);
            CategoriaDao.insertarCategoria(categoria);
            response.redirect("/Mantenimiento/Categorias");
            return null;
        });
        
        get("/Mantenimiento/Productos/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Integer id = Integer.parseInt(request.queryParams(":id"));
            Producto producto = ProductoDao.obtenerProducto(id);
            attributes.put("producto", producto.obtenerVista());
            attributes.put("templateName", "formularioProducto.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Categorias/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Integer id = Integer.parseInt(request.queryParams(":id"));
            Categoria categoria = CategoriaDao.obtenerCategoria(id);
            attributes.put("categoria", categoria.obtenerVista());
            attributes.put("templateName", "formularioCategoria.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        post("/Mantenimiento/Productos/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Integer id = Integer.parseInt(request.queryParams("txtId"));
            String nombre = request.queryParams("txtNombre").toString();
            Integer idCategoria = Integer.parseInt(request.queryParams("txtCategoria"));
            Categoria categoria = CategoriaDao.obtenerCategoria(idCategoria);
            Double precio = Double.parseDouble(request.queryParams("txtPrecio"));
            Integer stock = Integer.parseInt(request.queryParams("txtStock"));
            Producto producto = new Producto(id, nombre, stock, precio, categoria);
            ProductoDao.actualizarProducto(producto);
            response.redirect("/Mantenimiento/Productos");
            return null;
        });
        
        post("/Mantenimiento/Categorias/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Integer id = Integer.parseInt(request.queryParams("txtId"));
            String descripcion = request.queryParams("txtDescripcion");
            Categoria categoria = new Categoria(id, descripcion);
            CategoriaDao.actualizarCategoria(categoria);
            response.redirect("/Mantenimiento/Categorias");
            return null;
        });
        
        get("/Mantenimiento/Productos/Eliminar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Integer id = Integer.parseInt(request.queryParams("id"));
            ProductoDao.eliminarProducto(id);
            response.redirect("/Mantenimiento/Productos");
            return null;
        });
        
        get("/Mantenimiento/Categorias/Eliminar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Integer id = Integer.parseInt(request.queryParams("id"));
            CategoriaDao.eliminarCategoria(id);
            response.redirect("/Mantenimiento/Categorias");
            return null;
        });
    }
    
}
