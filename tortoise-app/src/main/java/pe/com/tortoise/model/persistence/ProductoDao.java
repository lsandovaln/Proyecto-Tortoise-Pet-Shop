
package pe.com.tortoise.model.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.com.tortoise.model.business.Producto;
import pe.com.tortoise.model.persistence.util.Conexion;

public class ProductoDao {
    public static synchronized boolean insertarProducto(Producto producto) {
        Connection cn = null;
        Statement stmnt = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "INSERT INTO producto(nombre, stock, precio, idcategoria) "
                    + "VALUES('" + producto.getNombre() + "',"
                    + producto.getStock().toString() + ","
                    + producto.getPrecio().toString() + ","
                    + producto.getCategoria().getIdentificador().toString() + ")";
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
    
    public static synchronized boolean actualizarProducto(Producto producto) {
        Connection cn = null;
        Statement stmnt = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "UPDATE producto SET "
                    + "nombre='" + producto.getNombre() + "',"
                    + "stock=" + producto.getStock().toString() + ","
                    + "precio=" + producto.getPrecio().toString() + ","
                    + "idcategoria=" + producto.getCategoria().getIdentificador().toString()
                    + " WHERE id=" + producto.getIdentificador();
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
    
    public static synchronized boolean eliminarProducto(Integer id) {
        Connection cn = null;
        Statement stmnt = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "DELETE FROM producto "
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
    
    public static synchronized Producto obtenerProducto(Integer id) {
        Connection cn = null;
        Statement stmnt = null;
        ResultSet rs = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "SELECT * FROM producto WHERE id=" + id.toString();
            rs = stmnt.executeQuery(sql);
            Producto producto = new Producto();
            while(rs.next()) {
                producto.setIdentificador(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                Integer idcategoria = rs.getInt("idcategoria");
                producto.setCategoria(CategoriaDao.obtenerCategoria(idcategoria));
            }
            return producto;
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
    
    public static synchronized List<Producto> obtenerProductos() {
        Connection cn = null;
        Statement stmnt = null;
        ResultSet rs = null;
        try {
            cn = Conexion.obtenerConexion();
            stmnt = cn.createStatement();
            String sql = "SELECT * FROM categoria";
            rs = stmnt.executeQuery(sql);
            List<Producto> productos = new ArrayList<>();
            while(rs.next()) {
                Producto producto = new Producto();
                producto.setIdentificador(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                Integer idcategoria = rs.getInt("idcategoria");
                producto.setCategoria(CategoriaDao.obtenerCategoria(idcategoria));
                productos.add(producto);
            }
            return productos;
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
