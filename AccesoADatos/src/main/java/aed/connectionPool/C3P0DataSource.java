package aed.connectionPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0DataSource {

    // Instancia única del ComboPooledDataSource
    private static ComboPooledDataSource dataSource;

    // Configuración inicial del pool de conexiones
    static {
        dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.mariadb.jdbc.Driver"); // Cambia el driver si usas otra base de datos
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/biblioteca"); // Cambia "empresa" por tu base de datos
        dataSource.setUser("root"); // Cambia "usuario" por tu nombre de usuario de la base de datos
        dataSource.setPassword(""); // Cambia "contraseña" por tu contraseña de la base de datos

        // Configuración del pool de conexiones
        dataSource.setMinPoolSize(5); // Número mínimo de conexiones en el pool
        dataSource.setAcquireIncrement(5); // Incremento de conexiones cuando el pool se queda sin conexiones
        dataSource.setMaxPoolSize(20); // Número máximo de conexiones en el pool
        dataSource.setMaxIdleTime(300); // Tiempo máximo que una conexión puede estar inactiva (en segundos)
    }

    // Método para obtener una conexión del pool
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Método para cerrar el DataSource
    public static void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
