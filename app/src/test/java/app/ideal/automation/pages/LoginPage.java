package app.ideal.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class LoginPage {

    private WebDriver driver;

    private By loginBtn = By.xpath("//button[text()='Login']");
    WebDriverWait wait;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[text()='Login to QKart']");
    private By loginNotification = By.xpath("//div[@id='notistack-snackbar' and text()='Logged in successfully']");

    public LoginPage(WebDriver driver) {
        System.out.println("login page object initialized");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean login(String username, String password) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();

            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginNotification)).isDisplayed();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
