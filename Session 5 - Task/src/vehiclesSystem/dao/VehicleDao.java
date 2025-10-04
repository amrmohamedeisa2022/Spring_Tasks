package vehiclesSystem.dao;

import java.sql.SQLException;
import java.util.List;

public interface VehicleDao<T> {

    void save(T vehicle) throws SQLException;
    void delete(int id) throws SQLException;
    T update(T vehicle);
    T searchById(int id);
    List<T> getAll();
}