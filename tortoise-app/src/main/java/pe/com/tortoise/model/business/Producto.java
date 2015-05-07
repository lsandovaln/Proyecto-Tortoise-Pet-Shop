
package pe.com.tortoise.model.business;

public class Producto {
    private Integer identificador;
    private String nombre;
    private Integer stock;
    private Double precio;
    private Categoria categoria;
    
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
