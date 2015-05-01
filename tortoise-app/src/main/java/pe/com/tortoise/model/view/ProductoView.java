
package pe.com.tortoise.model.view;

public class ProductoView {
    public Integer identificador;
    public String nombre;
    public Integer stock;
    public String descripcionCategoria;
    
    public ProductoView(Integer identificador, String nombre, Integer stock, String descripcionCategoria) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcionCategoria = descripcionCategoria;
    }
}
