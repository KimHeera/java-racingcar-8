package racingcar.controller;

import java.util.List;
import racingcar.domain.*;
import racingcar.view.*;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private RacingGame racingGame;
    private int tryCnt;

    public void run(){
        try{
            // 입력 및 model 실행
            readRacingSet();

            // 게임 실행 및 결과 출력
            startGame();
        } catch(IllegalArgumentException e){
            //OutputView를 통해 오류 메시지 출력
        }

    }

    private void readRacingSet(){
        String inputCarName = inputView.readCarName();

        List<String> carNames = Validator.validateNames(inputCarName);

        List<Car> carList = CarFactory.createCars(carNames);
        this.racingGame = new RacingGame(carList);

        this.tryCnt = inputView.readTryCount();
        Validator.validateCount(this.tryCnt);
    }

    private void startGame(){
        // 이동 횟수만큼 반복
        for(int i =0 ; i < tryCnt ; i++){
            racingGame.moveRound();

            List<Car> roundResult = racingGame.getRoundResult();
            outputView.currentState(roundResult);
        }

        // 이동 횟수가 0이면 position의 max값을 가진 이름 출력. if 공동우승자의 경우 쉼표로 구분하여 함께 출력
    }
}
