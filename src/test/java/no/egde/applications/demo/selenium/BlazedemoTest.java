package no.egde.applications.demo.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import no.egde.applications.demo.selenium.home.Blazedemo;
import no.egde.applications.demo.selenium.login.Login;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlazedemoTest {

    private static WebDriver driver;
    private static Blazedemo home;

    private static Login login;

    @BeforeAll
    public static void setup() {
        System.out.println("Starting execution........");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login = new Login(driver);
        home = new Blazedemo(driver);
        driver.get("https://blazedemo.com/login");
        driver.manage().window().maximize();
    }

    @Test
    public void testcase_book_flights() throws InterruptedException {
        login.login("TestUser123@testing.com", "testuser123");
        home.findFlights("Paris", "London");
        home.chooseFlights();
        home.fillFormAndPurchase("Test Name", "Test Address", "Test City",
                "Test State", "Test Zipcode", "visa",
                "4000100020003000", "06", "2021", "Test Name");
        Assertions.assertEquals("Thank you for your purchase today!", home.purchaseConfirmation());
        Thread.sleep(2000);
    }

    @AfterAll
    public static void teardown() {
        driver.close();
    }
}
