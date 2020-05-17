package no.egde.applications.demo.selenium.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Blazedemo {
    WebDriver driver;

    By welcomeMsg = By.className("panel-body");
    By logo = By.className("navbar-brand");
    By fromPort = By.name("fromPort");
    By toPort = By.name("toPort");
    By findFlightBtn = By.className("btn-primary");
    By chooseFlightBtn = By.className("btn-small");

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zipCode = By.id("zipCode");
    By cardType = By.name("cardType");
    By creditCardNumber = By.id("creditCardNumber");
    By creditCardMonth = By.id("creditCardMonth");
    By creditCardYear = By.id("creditCardYear");
    By nameOnCard = By.id("nameOnCard");
    By rememberMe = By.id("rememberMe");

    By purchaseFlight = By.className("btn-primary");

    public Blazedemo(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMsg() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(welcomeMsg))).getText();
    }

    public void findFlights(String from, String to) {
        driver.findElement(logo).click();
        Select departureCity = new Select(driver.findElement(fromPort));
        departureCity.selectByValue(from);
        Select toCity = new Select(driver.findElement(toPort));
        toCity.selectByValue(to);
        driver.findElement(findFlightBtn).click();
    }

    public void chooseFlights() {
        driver.findElement(chooseFlightBtn).click();
    }

    public void fillFormAndPurchase(String custName, String custAddress,
                                    String custCity, String custState,
                                    String custZipCode, String custCardType,
                                    String custCardNo, String custCardMonth,
                                    String custYear, String custNameOnCard) {

        driver.findElement(name).sendKeys(custName);
        driver.findElement(address).sendKeys(custAddress);
        driver.findElement(city).sendKeys(custCity);
        driver.findElement(state).sendKeys(custState);
        driver.findElement(zipCode).sendKeys(custZipCode);
        Select card = new Select(driver.findElement(cardType));
        card.selectByValue(custCardType);
        driver.findElement(creditCardNumber).sendKeys(custCardNo);
        driver.findElement(creditCardMonth).sendKeys(custCardMonth);
        driver.findElement(creditCardYear).sendKeys(custYear);
        driver.findElement(nameOnCard).sendKeys(custNameOnCard);
        driver.findElement(rememberMe).click();
        driver.findElement(purchaseFlight).click();
    }

    public String purchaseConfirmation() {
        return driver.findElement(By.tagName("h1")).getText();
    }
}
