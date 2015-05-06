
package pe.com.tortoise.model.business;

import pe.com.tortoise.model.persistence.ProductoDao;
import pe.com.tortoise.model.view.CategoriaView;
import pe.com.tortoise.model.view.ProductoView;

public class Producto {
    private Integer identificador;
    private String nombre;
    private Integer stock;
    private Double precio;
    private Categoria categoria;

    public ProductoView obtenerVista() {
        return new ProductoView(identificador, nombre, stock, precio, 
                categoria.obtenerVista());
    }
    
    public boolean guardar() {
        boolean rpta = false;
        if(identificador < 0) {
            rpta = ProductoDao.insertarProducto(this);
        } else {
            rpta = ProductoDao.actualizarProducto(this);
        }
        return rpta;
    }
    
    public Producto() {
        identificador = -1;
    }

    public Producto(String nombre, Integer stock, Double precio, Categoria categoria) {
        this.identificador = -1;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(Integer identificador, String nombre, Integer stock, Double precio, Categoria categoria) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
