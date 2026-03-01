package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.List;

public interface CarService {
    Car createCar(Car car);
    List<Car> findAll();
    Car findById(String id);
    public void update(String carId, Car car);
    public void deleteCarbyId(String carId);
}
