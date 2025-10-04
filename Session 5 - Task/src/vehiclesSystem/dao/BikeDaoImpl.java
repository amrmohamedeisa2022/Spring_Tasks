package vehiclesSystem.dao;

import vehiclesSystem.config.DataBaseConfig;
import vehiclesSystem.models.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BikeDaoImpl implements VehicleDao<Bike> {

    @Autowired
    private DataBaseConfig dataBaseConfig;

    @Override
    public void save(Bike vehicle) {
        String sql = "INSERT INTO vehicles (type, name, model) VALUES (?, ?, ?)";
        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, "Bike");
            ps.setString(2, vehicle.getName());
            ps.setString(3, vehicle.getModel());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                vehicle.setId(rs.getInt(1));
                System.out.println("Bike saved with ID: " + vehicle.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ? AND type = 'Bike'";
        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Bike with ID " + id + " deleted.");
            } else {
                System.out.println("No Bike found with ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bike update(Bike vehicle) {
        String sql = "UPDATE vehicles SET name = ?, model = ? WHERE id = ? AND type = 'Bike'";
        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vehicle.getName());
            ps.setString(2, vehicle.getModel());
            ps.setInt(3, vehicle.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Bike with ID " + vehicle.getId() + " updated.");
                return vehicle;
            } else {
                System.out.println("No Bike found with ID " + vehicle.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Bike searchById(int id) {
        String sql = "SELECT * FROM vehicles WHERE id = ? AND type = 'Bike'";
        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Bike bike = new Bike();
                bike.setId(rs.getInt("id"));
                bike.setName(rs.getString("name"));
                bike.setModel(rs.getString("model"));
                return bike;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bike> getAll() {
        List<Bike> bikes = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE type = 'Bike'";
        try (Connection conn = dataBaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Bike bike = new Bike();
                bike.setId(rs.getInt("id"));
                bike.setName(rs.getString("name"));
                bike.setModel(rs.getString("model"));
                bikes.add(bike);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bikes;
    }
}