import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

//Implicit Wait Machine
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        Explicit wait is used to target specific Elements
        //Common Template to create Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //Given an Array to send to the cart
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");



        addItems(driver, itemsNeeded);//This is taking care of everything to run the test. (This is a utility:We successfully built a utility)
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        //Using Xpath, the text on the button will never change.
        driver.findElement(By.cssSelector("div.container div.container div.cart div.cart-preview.active:nth-child(6) div.action-block:nth-child(2) > button:nth-child(1)")).click();
        //Solved this solution with implicit wait declaration in selenium
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");// Building css when you have class name
        driver.findElement(By.cssSelector("button.promoBtn")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


        //Implementation of a class
        FluentWaitPrac wait1 = new FluentWaitPrac();
        wait1.checkFluentWait();
        

    }
//Creating a method outside of the main method
    public static void addItems(WebDriver driver, String[] itemsNeeded)
    {
        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++)
        {
            String[] name = products.get(i).getText().split("-"); //To get the text present on the product cart
            String formattedName = name[0].trim(); //Method trim in Java removes all the white spaces.

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                j++;

                driver.findElements(By.xpath("//div[@class='product-action'] /button")).get(i).click();

                if(j == itemsNeeded.length)
                {
                    break;
                }

            }
        }
    }
}
