package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList;

    public RacingGame(List<Car> carList){
        this.carList = carList;
    }

    //round
    public void moveRound(){
        for(Car car : carList){
            attemptMove(car);
        }
    }

    private void attemptMove(Car car){
        int randNumber = randNum();

        car.move(randNumber);
    }

    //무작위값
    private int randNum(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> getRoundResult(){
        return carList;
    }

    //우승자 가리기
    public List<String> getWinner(){
        int max = comparePosition();

        List<String> winners = new ArrayList<>();

        for(Car car : carList){
            if(max == car.getPosition()){
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int comparePosition(){
        int max = 0;

        for (Car car : carList) { // Depth 1
            max = Math.max(max, car.getPosition());
        }

        return max;
    }
}
