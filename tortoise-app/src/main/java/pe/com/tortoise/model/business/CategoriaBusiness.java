
package pe.com.tortoise.model.business;

public class CategoriaBusiness {
    private Integer identificador;
    private String descripcion;

    public CategoriaBusiness() {
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
