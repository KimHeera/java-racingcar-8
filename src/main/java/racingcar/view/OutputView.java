package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String HYPHEN = "-";
    private static final String EXECUTE_RESULT = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DELIMITER = ", ";
    private static final String ERROR_PREFIX = "[ERROR] ";

    //carList 입력받아서 각 차의 결과값을 예시대로 출력하기
    public void executeResult(){
        System.out.println(EXECUTE_RESULT);
    }

    public void currentState(List<Car> cars){
        for(Car car : cars){
            System.out.printf("%s : ", car.getName());
            System.out.println(positionRepresent(car.getPosition()));
        }

        System.out.print("\n");
    }

    //position number to '-'
    private String positionRepresent(int position){
        return HYPHEN.repeat(position);
    }

    //결과값 출력하기
    public void finalWinner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }

    public void finalWinners(List<String> winners){
        String result = String.join(DELIMITER, winners);

        System.out.println(WINNER_MESSAGE + result);
    }

    public void printError(String errorMsg){
        System.err.println(ERROR_PREFIX + errorMsg);
    }
}
