package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.BikeDao;
import com.vehiclesSystem.dao.PlaneDao;
import com.vehiclesSystem.dao.VehicleDao;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PlaneService implements VehicleDao<Plane> {
@Autowired
PlaneDao planeDao;

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
