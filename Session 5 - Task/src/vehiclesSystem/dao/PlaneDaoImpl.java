package vehiclesSystem.dao;

import vehiclesSystem.config.DataBaseConfig;
import vehiclesSystem.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlaneDaoImpl implements VehicleDao<Plane> {

    @Autowired
    private DataBaseConfig dataBaseConfig;

    @Override
    public void save(Plane vehicle) {
        String sql = "INSERT INTO vehicles (type, name, model) VALUES (?, ?, ?)";
        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, "Plane");
            ps.setString(2, vehicle.getName());
            ps.setString(3, vehicle.getModel());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                vehicle.setId(rs.getInt(1));
                System.out.println("Plane saved with ID: " + vehicle.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ? AND type = 'Plane'";
        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Plane with ID " + id + " deleted.");
            } else {
                System.out.println("No Plane found with ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plane update(Plane vehicle) {
        String sql = "UPDATE vehicles SET name = ?, model = ? WHERE id = ? AND type = 'Plane'";
        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vehicle.getName());
            ps.setString(2, vehicle.getModel());
            ps.setInt(3, vehicle.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Plane with ID " + vehicle.getId() + " updated.");
                return vehicle;
            } else {
                System.out.println("No Plane found with ID " + vehicle.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Plane searchById(int id) {
        String sql = "SELECT * FROM vehicles WHERE id = ? AND type = 'Plane'";
        try (Connection conn = dataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Plane plane = new Plane();
                plane.setId(rs.getInt("id"));
                plane.setName(rs.getString("name"));
                plane.setModel(rs.getString("model"));
                return plane;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Plane> getAll() {
        List<Plane> planes = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE type = 'Plane'";
        try (Connection conn = dataBaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Plane plane = new Plane();
                plane.setId(rs.getInt("id"));
                plane.setName(rs.getString("name"));
                plane.setModel(rs.getString("model"));
                planes.add(plane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }
}