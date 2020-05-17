package no.egde.applications.demo.selenium.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    WebDriver driver;
    By username = By.id("email");
    By password = By.id("password");
    By loginBtn = By.className("btn-primary");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pwd) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(username))).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        //driver.findElement(loginBtn).click();
    }
}
