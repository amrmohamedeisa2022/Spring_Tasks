package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.BikeDao;
import com.vehiclesSystem.dao.VehicleDao;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BikeService implements VehicleDao<Bike> {
    @Autowired
    private BikeDao bikeDao;
    @Override
    public void save(Bike vehicle) {
      bikeDao.save(vehicle);
    }

    @Override
    public void delete(int id) {
 this.bikeDao.delete(id);
    }

    @Override
    public Bike update(Bike vehicle) {
        return this.bikeDao.update(vehicle);
    }

    @Override
    public Bike searchById(int id) {
        return this.bikeDao.searchById(id);
    }

    @Override
    public List<Bike> getAll() {
        return this.bikeDao.getAll();
    }
}
