package main.dao;

import main.config.DataBaseConfig;
import main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDao {

    @Autowired
    private DataBaseConfig dataBaseConfig;

    public void save(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, date_of_birth, city) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setDate(4, user.getDateOfBirth());
            ps.setString(5, user.getCity());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        user.setId(rs.getInt(1));
                        System.out.println(" User saved with ID: " + user.getId());
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(" Error saving user: " + e.getMessage());
        }
    }
}
