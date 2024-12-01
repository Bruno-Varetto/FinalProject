package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step ("Business Flows: Fill Form")
    public static void calculateMortgage(String amount, String term, String rate){
        MobileActions.updateText(mortgageMain.text_amount, amount);
        MobileActions.updateText(mortgageMain.text_term, term);
        MobileActions.updateText(mortgageMain.text_rate, rate);
        MobileActions.tapOnElement(mortgageMain.btn_calculate);
    }
}
