package racingcar.domain;

import java.util.List;

public class Validator {
    final int MAX_NAME_LENGTH =5;

    public void validateNames(String inputCarName){
        inputCarName = inputCarName.trim();

        String[] splitName = inputCarName.split(",");
        List<String> carNames = List.of(splitName);

        if(carNames.isEmpty() && inputCarName.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 자동차 이름 목록이 비어 있습니다.");
        }

        for(String name : carNames){
            validateSingleName(name.trim());
        }
    }

    public void validateSingleName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 값일 수 없습니다.");
        }

        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 5자 이하만 가능합니다.");
        }
    }
}
