package vehiclesSystem.dao;

import vehiclesSystem.config.DataBaseConfig;
import vehiclesSystem.models.Car;
import vehiclesSystem.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CarDaoImpl implements VehicleDao<Car> {

    @Autowired
    private DataBaseConfig dataBaseConfig;

    @Override
    public void save(Car car) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String sql = "INSERT INTO vehicles (type, name, model) VALUES (?, ?, ?)";
            Connection conn = dataBaseConfig.getConnection();

            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, car.getType().name());
            ps.setString(2, car.getName());
            ps.setString(3, car.getModel());
            ps.executeUpdate();


            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                car.setId(generatedId);
            }

        } catch (Exception ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM vehicles WHERE id = ?";
            Connection conn = dataBaseConfig.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Car update(Car car) {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE vehicles SET type = ?, name = ?, model = ? WHERE id = ?";
            Connection conn = dataBaseConfig.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, car.getType().name());
            ps.setString(2, car.getName());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                return car;
            }
        } catch (Exception ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Car searchById(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM vehicles WHERE id = ?";
            Connection conn = dataBaseConfig.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setType(Type.VehicleType.valueOf(rs.getString("type")));
                car.setName(rs.getString("name"));
                car.setModel(rs.getString("model"));
                return car;
            }
        } catch (Exception ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM vehicles";
            Connection conn = dataBaseConfig.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setType(Type.VehicleType.valueOf(rs.getString("type")));
                car.setName(rs.getString("name"));
                car.setModel(rs.getString("model"));
                cars.add(car);
            }

        } catch (Exception ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cars;
    }
}
