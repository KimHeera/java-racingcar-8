package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingController controller = new RacingController();
        OutputView outputView = new OutputView();

        try{
            controller.run();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());

            throw e;
        } catch (RuntimeException e){
            throw e;
        }
    }
}
