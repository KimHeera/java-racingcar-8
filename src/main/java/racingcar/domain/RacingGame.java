package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
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

    //우승자 가리기
}
