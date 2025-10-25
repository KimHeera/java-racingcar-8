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
        int max = 0;

        for(Car car : carList){
            max = comparePosition(max, car.getPosition());
        }

        return winnersList(max);
    }

    private int comparePosition(int max, int position){
        if(position > max){
            int tmp = max;
            max = position;
            position = tmp;
        }

        return max;
    }

    private List<String> winnersList(int max){
        List<String> winners = new ArrayList<>();

        for(Car car : carList){
            if(max == car.getPosition()){
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
