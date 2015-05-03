
package pe.com.tortoise.model.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.com.tortoise.model.business.Categoria;
import pe.com.tortoise.model.persistence.util.Conexion;

public class CategoriaDao {
    public static synchronized boolean insertarCategoria(Categoria categoria) {
        Connection cn = null;
        Statement stmnt = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "INSERT INTO categoria(descripcion) VALUES(" +
                    categoria.getDescripcion() + ")";
            stmnt.executeUpdate(sql);
            return true;
        } catch(SQLException ex) {
            return false;
        } finally {
            if(null != stmnt) {
                try {
                    stmnt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(null != cn) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static synchronized boolean actualizarCategoria(Categoria categoria) {
        Connection cn = null;
        Statement stmnt = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "UDATE categoria " +
                    "SET descripcion=" + categoria.getDescripcion() +
                    "WHERE id=" + categoria.getIdentificador().toString();
            stmnt.executeUpdate(sql);
            return true;
        } catch(SQLException ex) {
            return false;
        } finally {
            if(null != stmnt) {
                try {
                    stmnt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(null != cn) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static synchronized boolean eliminarCategoria(Integer id) {
        Connection cn = null;
        Statement stmnt = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "DELETE categoria"
                    + "WHERE id=" + id.toString();
            stmnt.executeUpdate(sql);
            return true;
        } catch(SQLException ex) {
            return false;
        } finally {
            if(null != stmnt) {
                try {
                    stmnt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(null != cn) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static synchronized Categoria obtenerCategoria(Integer id) {
        Connection cn = null;
        Statement stmnt = null;
        ResultSet rs = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "SELECT * FROM categoria WHERE id=" + id.toString();
            rs = stmnt.executeQuery(sql);
            Categoria categoria = new Categoria();
            while(rs.next()) {
                categoria.setIdentificador(rs.getInt("id"));
                categoria.setDescripcion(rs.getString("descripcion"));
            }
            return categoria;
        } catch(SQLException ex) {
            return null;
        } finally {
            if(null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(null != stmnt) {
                try {
                    stmnt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(null != cn) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static synchronized List<Categoria> obtenerCategorias() {
        Connection cn = null;
        Statement stmnt = null;
        ResultSet rs = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "SELECT * FROM categoria";
            rs = stmnt.executeQuery(sql);
            List<Categoria> categorias = new ArrayList<>();
            while(rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdentificador(rs.getInt("id"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categorias.add(categoria);
            }
            return categorias;
        } catch(SQLException ex) {
            return null;
        } finally {
            if(null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(null != stmnt) {
                try {
                    stmnt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(null != cn) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
