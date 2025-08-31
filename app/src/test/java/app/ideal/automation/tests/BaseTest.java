package app.ideal.automation.tests;

import app.ideal.automation.driver.DriverManager;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import app.ideal.automation.pages.*;


public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage; // Example page object

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void setUp(String browser) {
        System.out.println("starting driver");
        // Initialize driver once per <test> in testng.xml
        DriverManager.initDriver(browser);
        driver = DriverManager.getDriver();

        // Clean session
        driver.manage().deleteAllCookies();

        // Initialize page objects
        loginPage = new LoginPage(driver); 
    }

    
    // @AfterTest(alwaysRun = true)
    // public void tearDown() {
    //     System.out.println("quiting driver");
    //     // Quit driver after the suite/test block
    //     DriverManager.quitDriver();
    // }
}
