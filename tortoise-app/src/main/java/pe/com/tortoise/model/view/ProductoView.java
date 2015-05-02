
package pe.com.tortoise.model.view;

public class ProductoView {
    public Integer identificador;
    public String nombre;
    public Integer stock;
    public Double precio;
    public String descripcionCategoria;
    
    public ProductoView(Integer identificador, String nombre, 
            Integer stock, Double precio, String descripcionCategoria) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.descripcionCategoria = descripcionCategoria;
    }
}
