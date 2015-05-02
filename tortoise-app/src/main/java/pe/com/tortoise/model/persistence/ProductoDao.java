
package pe.com.tortoise.model.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import pe.com.tortoise.model.business.Producto;
import pe.com.tortoise.model.persistence.util.Conexion;

public class ProductoDao {
    public static synchronized boolean insertarProducto(Producto producto) {
        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            String call = "{CALL spI_producto(?,?,?)}";
            cn = Conexion.obtenerConexion();
            cn.setAutoCommit(false);
            cl = cn.prepareCall(call);
            cl.registerOutParameter(1, Types.INTEGER);
            cl.setString(2, producto.getNombre());
            cl.setDouble(3, producto.getPrecio());
            rpta = cl.executeUpdate() == 1;
            if (rpta) {
                cn.commit();
            } else {
                Conexion.deshacerCambios(cn);
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        }
        return rpta;
    }
    
    public static synchronized boolean actualizarProducto(Producto producto) {
        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            String call = "{CALL spU_producto(?,?,?)}";
            cn = Conexion.obtenerConexion();
            cn.setAutoCommit(false);
            cl = cn.prepareCall(call);
            cl.setInt(1, producto.getIdentificador());
            cl.setString(2, producto.getNombre());
            cl.setDouble(3, producto.getPrecio());
            rpta = cl.executeUpdate() == 1 ? true : false;
            if (rpta) {
                cn.commit();
            } else {
                Conexion.deshacerCambios(cn);
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        }
        return rpta;
    }
}
