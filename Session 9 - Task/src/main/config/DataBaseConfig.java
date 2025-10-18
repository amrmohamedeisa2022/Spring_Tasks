package main.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Scope("singleton")
public class DataBaseConfig {

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    @PostConstruct
    public void init() throws SQLException {
        getConnection();
        System.out.println(" Connection Established");
    }

    @PreDestroy
    public void destroy() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println(" Connection closed");
        }
    }
}
