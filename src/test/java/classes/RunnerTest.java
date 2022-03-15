package classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Utils;


import java.io.IOException;

public class RunnerTest {
    private static final WebDriver driver = new ChromeDriver();
//    public static ExtentReports extent;
//    public static ExtentTest test;


    @BeforeTest
    public static void main(String[] args) {
        // CHROMEDRIVER LOCATION IN THE UTILS CLASS
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }


    /**
     *  REGISTRATION
     * */
    @Test(testName = "User registration")
    public void paniniRegistration() throws IOException, InterruptedException {
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL);
        PageObjects pageObjects = new PageObjects(driver);

        pageObjects.paniniUserRegistration();
    }


    /**
     *  LOGIN
     * */
    @Test(testName = "User login")
    public void paniniLogin() throws IOException, InterruptedException {
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL);
        PageObjects pageObjects = new PageObjects(driver);

        pageObjects.paniniUserLogin();
    }

    @AfterTest
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        //driver.close();
    }
}
