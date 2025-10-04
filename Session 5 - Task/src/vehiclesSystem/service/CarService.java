package vehiclesSystem.service;

import vehiclesSystem.dao.CarDaoImpl;
import vehiclesSystem.dao.VehicleDao;
import vehiclesSystem.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
@Component
public class CarService implements VehicleDao<Car> {

    @Autowired
    private CarDaoImpl carDao;
    @Override
    public void save(Car vehicle) throws SQLException {
        carDao.save(vehicle);
    }

    @Override
    public void delete(int id) {
        this.carDao.delete(id);
    }

    @Override
    public Car update(Car vehicle) {
        return this.carDao.update(vehicle);
    }

    @Override
    public Car searchById(int id) {
        return this.carDao.searchById(id);
    }

    @Override
    public List<Car> getAll() {
        return this.carDao.getAll();
    }
}