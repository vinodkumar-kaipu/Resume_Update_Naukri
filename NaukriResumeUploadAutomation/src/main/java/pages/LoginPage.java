package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.WaitUtils;

public class LoginPage {

    WebDriver driver;

    private By username = By.id("usernameField");
    private By password = By.id("passwordField");
    private By loginBtn = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        WaitUtils.waitForVisible(driver, username).sendKeys(ConfigReader.get("username"));
        driver.findElement(password).sendKeys(ConfigReader.get("password"));
        driver.findElement(loginBtn).click();
    }
}
