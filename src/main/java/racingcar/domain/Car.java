package racingcar.domain;

public class Car {
    private final String name;
    private int position; //initial 0

    public Car(String carName){
        this.name = carName;
        this.position = 0;
    }

    public void move(int randNumber){
        if(isMovable(randNumber)){
            position++;
        }
    }

    private boolean isMovable(int randNumber){
        return randNumber >= 4;
    }
}
