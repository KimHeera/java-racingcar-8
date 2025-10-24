package racingcar.controller;

import java.util.List;
import racingcar.domain.*;
import racingcar.view.*;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(){
        try{
            // 입력 및 model 실행
            readRacingSet();

            // 게임 실행 및 결과 출력
        } catch(IllegalArgumentException e){
            //OutputView를 통해 오류 메시지 출력
        }

    }

    private void readRacingSet(){
        String inputCarName = inputView.readCarName();
        List<String> carNames = Validator.validateNames(inputCarName);

        // 쉼표 파싱해서 List에 저장 -> 여기서 한 번 더 validate 할거면 위에서 검증하고 바로 List를 반환하는게 더 낫지 않을까?
        //List를 바탕으로 Car 객체 생성(이름 별로)
        //try cnt 입력 받기
        //try cnt validate

    }
}
