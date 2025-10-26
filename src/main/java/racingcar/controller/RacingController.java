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
            readRacingSet();

            startGame();
        } catch(IllegalArgumentException e){
            outputView.printError(e.getMessage());
        }

    }

    private void readRacingSet(){
        String inputCarName = inputView.readCarName();

        List<String> carNames = Validator.validateNames(inputCarName);

        List<Car> carList = CarFactory.createCars(carNames);
        this.racingGame = new RacingGame(carList);

        String tryCntStr = inputView.readTryCount();
        this.tryCnt = Validator.validateCount(tryCntStr);
    }

    private void startGame(){
        outputView.executeResult();

        for(int i =0 ; i < tryCnt ; i++){
            racingGame.moveRound();

            List<Car> roundResult = racingGame.getRoundResult();
            outputView.currentState(roundResult);
        }

        List<String> winners = racingGame.getWinner();
        outputView.finalWinners(winners);
    }
}
