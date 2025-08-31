package app.ideal.automation.tests.ui;

import app.ideal.automation.pages.LoginPage;
import app.ideal.automation.tests.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Sample test to check the automation flow
    @Test
    public void testValidLogin() {
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");

        LoginPage loginPage = new LoginPage(driver);
        boolean status =loginPage.login("Jafar Sherif", "Jafar@123");

        Assert.assertTrue(status,"user is not logged in");
    }
}
