package racingcar.domain;

import java.util.List;

public class Validator {
    final static int MAX_NAME_LENGTH =5;

    public static List<String> validateNames(String inputCarName){
        inputCarName = inputCarName.trim();

        String[] splitName = inputCarName.split(",");
        List<String> carNames = List.of(splitName);

        if(carNames.isEmpty() && inputCarName.isEmpty()){
            throw new IllegalArgumentException("자동차 이름 목록이 비어 있습니다.");
        }

        for(String name : carNames){
            validateSingleName(name.trim());
        }

        return carNames;
    }

    private static void validateSingleName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }

        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름의 길이는 5자 이하만 가능합니다.");
        }
    }

    public static void validateCount(int tryCnt){
        if(tryCnt <= 0){
            throw new IllegalArgumentException("이동 횟수는 양수로만 입력 가능합니다.");
        }
    }
}
