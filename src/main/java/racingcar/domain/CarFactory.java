package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    //List<String> -> List<Car>
    public static List<Car> createCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();

        for(String name : carNames){
            cars.add(new Car(name));
        }

        return cars;
    }
}
