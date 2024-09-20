package myapp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.time.Duration;

public class Driver {

    //This is SIMPLE Driver class.. created on Singleton design pattern.. but we will make it more dynamic later on.

    /*
    NOTE: This Driver class will work the same way with Sequential tests as well as Parallel tests.

    PLAN:
    1. Create a private constructor => to prevent an external instantiation
    2. Use ThreadLocal class from Java to create thread-safe variable
    3. Driver.getDriver() will be used the same way as before.. this will return us the copy of Driver each time for parallel testing
    4. Create a separate method for switch statement called initialiseDriver() and a call that method in getDriver() to implement the same method in all existing codes
     */

    private Driver(){}; //private constructor => to prevent any external instantiation

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //returns thread-safe Driver instance each time

    public static WebDriver getDriver(){
        if (driver.get()==null){
            initialiseDriver(); //method call for switch statement
        }
        return driver.get();
    }

    public static void initialiseDriver(){
        switch (ConfigReader.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver.set(new SafariDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver.set(ThreadGuard.protect(new ChromeDriver(options)));
                break;
        }

        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get().manage().window().maximize();
    }

    public static void closeDriver(){
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }





















}





