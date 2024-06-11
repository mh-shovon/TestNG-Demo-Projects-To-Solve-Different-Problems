package NewTabWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class NewTabWindowElements extends Setup{
    public NewTabWindowElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void isLogoDisplayed() {
        WebElement isLogoDisplayed = driver.findElement(By.xpath("//*[@id=\"topActionHeader\"]/div/div[2]/div/div[1]/a/img"));
        if(isLogoDisplayed.isDisplayed()) {
            System.out.println("Test Case Passed.");
        } else {
            System.out.println("Test Case Failed. Bug found");
        }
    }
    public void newTabOrWindow() {
        WebElement loginIcon = driver.findElements(By.className("login-icon")).get(0);
        loginIcon.click();
        String mainWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String childWindow : windowHandles) {
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(driver.getTitle());
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getTitle());
    }

}
