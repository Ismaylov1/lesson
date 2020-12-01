package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {




    @GetMapping("/")
    public String Car(@RequestParam(value = "count",required = false) Integer count, ModelMap mod) {

        Car bmw = new Car("BMW", "X7", "AMG");
        Car audi = new Car("Audi", "A7", "aud");
        Car bugatti = new Car("Buggati", "Veron", "Heron");
        Car mazda = new Car("Mazda", "figazda", "maz");
        Car nissan = new Car("Nissan", "Almera", "alm");

        List<Car> cars = new ArrayList<>();


        if (count == 1) {
            cars.add(bmw);


        }
        if (count == 2) {
            cars.add(bmw);
            cars.add(audi);


        }
        if (count == 3) {
            cars.add(bmw);
            cars.add(audi);
            cars.add(bugatti);

        }
        if (count == 4) {
            cars.add(bmw);
            cars.add(audi);
            cars.add(bugatti);
            cars.add(mazda);
        }
        if (count >= 5) {
            cars.add(bmw);
            cars.add(audi);
            cars.add(bugatti);
            cars.add(mazda);
            cars.add(nissan);
        }
        if (count==null){
            cars.add(bmw);
            cars.add(audi);
            cars.add(bugatti);
            cars.add(mazda);
            cars.add(nissan);
        }

        mod.addAttribute("cars", cars);
        return "cars";

    }

//
//    @RequestMapping(value = "?count=1", method = RequestMethod.GET)
//    public String Car1(@RequestParam(value = "count", required = false) byte count, ModelMap mod) {
//        CarController bmw = new CarController("BMW", "X7", "AMG");
//
//
//        List<CarController> cars1 = new ArrayList<CarController>();
//
//        cars1.add(bmw);
//
//        mod.addAttribute("cars1", cars1);
//
//        return "car1";
//    }


}
