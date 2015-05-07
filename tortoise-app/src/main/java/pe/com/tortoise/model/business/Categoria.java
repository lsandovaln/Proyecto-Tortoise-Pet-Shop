
package pe.com.tortoise.model.business;

public class Categoria {
    private Integer identificador;
    private String descripcion;
    
    public Categoria() {
        identificador = -1;
    }

    public Categoria(String descripcion) {
        identificador = -1;
        this.descripcion = descripcion;
    }

    public Categoria(Integer identificador, String descripcion) {
        this.identificador = identificador;
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }
}
