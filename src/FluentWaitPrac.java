import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitPrac {

    public void checkFluentWait(){
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");

        //ChromeDriver(); is a class which is Implementing WedDriver interface
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();

        /*Fluent Wait:
        Fluent wait finds the web element repeatedly at regular intervals of time until the timeout or till object gets found
        */

       //FluentWait(); is the class which is implementing Wait interface. You need to let it know that ita <WebDriver>
        Wait <WebDriver>wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                //asking it to monitor the seconds below
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
                {
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                } else
                    return null;
            }
        });
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
    }
}
