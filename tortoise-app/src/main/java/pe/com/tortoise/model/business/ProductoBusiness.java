
package pe.com.tortoise.model.business;

public class ProductoBusiness {
    private Integer identificador;
    private String nombre;
    private Integer stock;
    private CategoriaBusiness categoria;

    public ProductoBusiness() {
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

    public CategoriaBusiness getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBusiness categoria) {
        this.categoria = categoria;
    }
}
