package NewTabWindow;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class NewTabWindowElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        //driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("window.open()");

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(newTab.get(1));
        driver.get("https://www.youtube.com");
        Thread.sleep(3000);

        driver.switchTo().window(newTab.get(2));
        driver.get("https://www.facebook.com");
        Thread.sleep(3000);
    }
}
