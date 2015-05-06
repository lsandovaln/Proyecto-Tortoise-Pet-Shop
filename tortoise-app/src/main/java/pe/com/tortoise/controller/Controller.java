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
            String nombre = request.attribute("txtNombre").toString();
            Integer idCategoria = Integer.parseInt(request.attribute("txtCategoria").toString());
            Categoria categoria = CategoriaDao.obtenerCategoria(idCategoria);
            Double precio = Double.parseDouble(request.attribute("txtPrecio").toString());
            Integer stock = Integer.parseInt(request.attribute("txtStock").toString());
            Producto producto = new Producto(nombre, stock, precio, categoria);
            ProductoDao.insertarProducto(producto);
            attributes.put("templateName", "mantenimientoProductos.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        post("/Mantenimiento/Categorias/Registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String descripcion = request.attribute("txtDescripcion").toString();
            Categoria categoria = new Categoria(descripcion);
            CategoriaDao.insertarCategoria(categoria);
            attributes.put("templateName", "mantenimientoCategorias.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Productos/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Integer id = Integer.parseInt(request.params(":id"));
            Producto producto = ProductoDao.obtenerProducto(id);
            attributes.put("producto", producto.obtenerVista());
            attributes.put("templateName", "formularioProducto.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Categorias/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Integer id = Integer.parseInt(request.params(":id"));
            Categoria categoria = CategoriaDao.obtenerCategoria(id);
            attributes.put("categoria", categoria.obtenerVista());
            attributes.put("templateName", "formularioCategoria.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        post("/Mantenimiento/Productos/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("templateName", "mantenimientoProductos.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        post("/Mantenimiento/Categorias/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("templateName", "mantenimientoCategorias.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Productos/Eliminar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("templateName", "mantenimientoProductos.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Categorias/Eliminar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("templateName", "mantenimientoCategorias.ftl");
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
    }
    
}
