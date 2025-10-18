package main.dao;

import main.config.DataBaseConfig;
import main.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class EmployeeDao {

    @Autowired
    private DataBaseConfig dataBaseConfig;

    public void save(Employee employee) {
        String sql = "INSERT INTO employee (username, email, password) VALUES (?, ?, ?)";

        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getPassword());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        employee.setId(rs.getInt(1));
                        System.out.println(" Employee saved with ID: " + employee.getId());
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(" Error saving employee: " + e.getMessage());
        }
    }
}
