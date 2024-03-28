import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SignInPage;
import utils.FrameworkProperties;

import static utils.Constants.EMAIL;
import static utils.Constants.PASSWORD;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://bitheap.tech");

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();

        homePage.clickSignIn();
        signInPage.logIn(EMAIL,PASSWORD);

        if(homePage.getUsername().equals("Hello, Sergey"))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
        DriverSingleton.closeObjectInstance();
    }
}