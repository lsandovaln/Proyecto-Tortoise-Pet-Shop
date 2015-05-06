
package pe.com.tortoise.model.business;

import pe.com.tortoise.model.persistence.CategoriaDao;
import pe.com.tortoise.model.view.CategoriaView;

public class Categoria {
    private Integer identificador;
    private String descripcion;

    public CategoriaView obtenerVista() {
        return new CategoriaView(identificador, descripcion);
    }
    
    public boolean guardar() {
        boolean rpta = false;
        if(identificador < 0) {
            rpta = CategoriaDao.insertarCategoria(this);
        } else {
            rpta = CategoriaDao.actualizarCategoria(this);
        }
        return rpta;
    }
    
    public Categoria() {
        identificador = -1;
    }

    public Categoria(String descripcion) {
        identificador = -1;
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
