package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.grafana.*;
import pageObjects.mortgage.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General

    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    //Web
    protected static WebDriver driver;

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    // REST API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jsonPath;

    // DATABASE
    protected static ResultSet rs;
    protected static Connection con;
    protected static Statement stmt;


    // Pages objects - WEB
    protected static LoginPage grafanaLogin;
    protected static pageObjects.grafana.MainPage grafanaMain;
    protected static LeftMenuPage grafanaLeftMenu;
    protected static AdministrationMenu grafanaAdministrationMenu;
    protected static UsersPage grafanaUsersPage;
    protected static AddNewUser grafanaAddNewUser;
    protected static EditUserPage grafanaEditUserPage;

    // Pages objects - MOBILE
    protected static pageObjects.mortgage.MainPage mortgageMain;

    // Page objects - ELECTRON
    protected static pageObjects.toDoList.MainPage todoMain;

    // Page objects - DESKTOP
    protected static pageObjects.Calculator.MainPage calculatorMain;

    // Page objects - DATABASE






}
