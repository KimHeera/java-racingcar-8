package racingcar.domain;

public class Validator {
    public void validateName(String inputCarName){
        String[] carNames;

        if(inputCarName.contains(",")){
            carNames = splitName(inputCarName);
        }
    }

    public String[] splitName(String inputCarName){
        return inputCarName.split(",");
    }
}
