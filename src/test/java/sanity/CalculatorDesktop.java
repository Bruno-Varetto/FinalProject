package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;


@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01 - Verify Addition Command")
    @Description("This Test verifies the Addition Command")
    public void test01_verifyAddition() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calculatorMain.field_result, "Display is 9");
    }

    @Test(description = "Test02 - Verify Subtraction Command")
    @Description("This Test verifies the Subtraction Command")
    public void test02_verifySubtraction() {
        DesktopFlows.calculateSubtraction();
        Verifications.verifyTextInElement(calculatorMain.field_result, "Display is 7");
    }

    @Test(description = "Test03 - Verify Multiplication Command")
    @Description("This Test verifies the Multiplication Command")
    public void test03_verifyMultiplication() {
        DesktopFlows.calculateMultiplication();
        Verifications.verifyTextInElement(calculatorMain.field_result, "Display is 64");
    }

    @Test(description = "Test04 - Verify Division Command")
    @Description("This Test verifies the Division Command")
    public void test04_verifyDivision() {
        DesktopFlows.calculateDivision();
        Verifications.verifyTextInElement(calculatorMain.field_result, "Display is 8");
    }

}
