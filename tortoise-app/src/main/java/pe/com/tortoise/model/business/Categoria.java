
package pe.com.tortoise.model.business;

import pe.com.tortoise.model.view.CategoriaView;

public class Categoria {
    private Integer identificador;
    private String descripcion;

    public CategoriaView obtenerVista() {
        return new CategoriaView(identificador, descripcion);
    }
    
    public Categoria() {
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
