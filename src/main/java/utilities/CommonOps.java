package utilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class CommonOps extends Base {

    public static String getData(String nodeName) {

        File fXmlFile;
        DocumentBuilder dBuilder;
        Document doc = null;
        DocumentBuilderFactory dbFactory;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Error in reading XML file: " + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    public static void initBrowser(String browserType) throws SQLException, ClassNotFoundException {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = initFirefoxDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            driver = initIEDriver();
        } else {
            throw new RuntimeException("Unsupported browser type");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));
        driver.get(getData("url"));
        ManagePages.initGrafana();
        action = new Actions(driver);

    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, getData("UUID"));
        dc.setCapability("noReset", true);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        mobileDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("TimeOut")));
        ManagePages.initMortgage();
    }

    public static void initAPI(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"), getData("Password"));
    }

    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriver"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronApp"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);
    }

    public static void initDesktop() throws MalformedURLException {
        dc.setCapability("app", getData("CalculatorApp"));
        driver = new WindowsDriver(new URL(getData("DesktopServer")), dc);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));
        ManagePages.initCalculator();
    }


    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) throws MalformedURLException, SQLException, ClassNotFoundException {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web") || platform.equalsIgnoreCase("db")) {
            initBrowser(getData("BrowserName"));
        } else if (platform.equalsIgnoreCase("mobile")) {
            initMobile();
        }
        else if (platform.equalsIgnoreCase("api")) {
            initAPI();
        }
        else if (platform.equalsIgnoreCase("electron")) {
            initElectron();
        }
        else if (platform.equalsIgnoreCase("desktop")) {
            initDesktop();
        }
        else {
            throw new RuntimeException("Unsupported platform: " + platform);
        }
        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"), getData("DBUserName"), getData("DBPasswrod"));
    }

    @AfterClass
    public void endSession() throws SQLException {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile")) {
                driver.quit();
            } else {
                mobileDriver.closeApp();
                mobileDriver.quit();
            }
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web")) {
            driver.get(getData("url"));
        } else if (platform.equalsIgnoreCase("electron")) {
            ElectronFlows.emptyList();
        }
    }





}
