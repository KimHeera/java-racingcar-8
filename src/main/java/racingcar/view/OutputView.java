package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    final String HYPHEN = "-";
    //carList 입력받아서 각 차의 결과값을 예시대로 출력하기
    public void currentState(List<Car> cars){
        for(Car car : cars){
            System.out.printf("%s : ", car.getName());
            System.out.println(positionRepresent(car.getPosition()));
        }
    }

    //position number to '-'
    private String positionRepresent(int position){
        return HYPHEN.repeat(position);
    }

    //결과값 출력하기
}
