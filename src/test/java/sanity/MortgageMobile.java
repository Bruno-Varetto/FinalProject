package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;
import workflows.WebFlows;

import java.util.concurrent.TimeUnit;


@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {


    @Test(description = "Test01 - Verify Mortgage")
    @Description("This Test calculate mortgage and repayments")
    public void test01_verifyMortgage() {
        MobileFlows.calculateMortgage("1000", "3", "4");
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        Verifications.verifyTextInElement(mortgageMain.text_repayment, "£30.03");
    }

}
