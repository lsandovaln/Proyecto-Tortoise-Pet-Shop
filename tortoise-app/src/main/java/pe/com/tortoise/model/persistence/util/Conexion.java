
package pe.com.tortoise.model.persistence.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    public static synchronized Connection obtenerConexion() {
        Connection cn = null;
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            cn = DriverManager.getConnection(Constantes.DB_URL, 
                    Constantes.USER, Constantes.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            cn = null;
        } finally {
            return cn;
        }
    }
}
