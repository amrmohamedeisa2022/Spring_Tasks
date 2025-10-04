package vehiclesSystem.service;

import vehiclesSystem.dao.PlaneDaoImpl;
import vehiclesSystem.dao.VehicleDao;
import vehiclesSystem.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PlaneService implements VehicleDao<Plane> {
    @Autowired
    PlaneDaoImpl planeDao;

    @Override
    public void save(Plane vehicle) {
        planeDao.save(vehicle);
    }

    @Override
    public void delete(int id) {
        this.planeDao.delete(id);
    }

    @Override
    public Plane update(Plane vehicle) {
        return this.planeDao.update(vehicle);
    }

    @Override
    public Plane searchById(int id) {
        return this.planeDao.searchById(id);
    }

    @Override
    public List<Plane> getAll() {
        return this.planeDao.getAll();
    }
}