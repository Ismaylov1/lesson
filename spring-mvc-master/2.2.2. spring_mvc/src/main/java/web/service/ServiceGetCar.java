package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class ServiceGetCar {

    public List<Car> GetCars(Integer count) {
        Car bmw = new Car("BMW", "X7", "AMG");
        Car audi = new Car("Audi", "A7", "aud");
        Car bugatti = new Car("Buggati", "Veron", "Heron");
        Car mazda = new Car("Mazda", "figazda", "maz");
        Car nissan = new Car("Nissan", "Almera", "alm");

        List<Car> cars = new ArrayList<>();
        cars.add(bmw);
        cars.add(audi);
        cars.add(bugatti);
        cars.add(mazda);
        cars.add(nissan);

        int index = count != null && count < cars.size() ? count : cars.size();

        return cars.subList(0, index);

    }

}
