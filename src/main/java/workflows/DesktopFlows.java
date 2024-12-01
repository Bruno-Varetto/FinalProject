package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Calculates Addition")
    public static void calculateAddition() {
        UIActions.click(calculatorMain.btn_clear);
        UIActions.click(calculatorMain.btn_one);
        UIActions.click(calculatorMain.btn_plus);
        UIActions.click(calculatorMain.btn_eight);
        UIActions.click(calculatorMain.btn_equals);
    }

    @Step("Business Flow: Calculates Subtraction")
    public static void calculateSubtraction() {
        UIActions.click(calculatorMain.btn_clear);
        UIActions.click(calculatorMain.btn_eight);
        UIActions.click(calculatorMain.btn_minus);
        UIActions.click(calculatorMain.btn_one);
        UIActions.click(calculatorMain.btn_equals);
    }
    @Step("Business Flow: Calculates Multiplication")
    public static void calculateMultiplication() {
        UIActions.click(calculatorMain.btn_clear);
        UIActions.click(calculatorMain.btn_eight);
        UIActions.click(calculatorMain.btn_multiply);
        UIActions.click(calculatorMain.btn_eight);
        UIActions.click(calculatorMain.btn_equals);
    }

    @Step("Business Flow: Calculates Division")
    public static void calculateDivision() {
        UIActions.click(calculatorMain.btn_clear);
        UIActions.click(calculatorMain.btn_eight);
        UIActions.click(calculatorMain.btn_division);
        UIActions.click(calculatorMain.btn_one);
        UIActions.click(calculatorMain.btn_equals);
    }

}
