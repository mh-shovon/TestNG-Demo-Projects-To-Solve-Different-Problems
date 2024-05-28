package AutomateDatePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatePickerDemo1 {
    public static void main(String[] args) throws InterruptedException {
        String month = "June 2024";
        String day = "20";

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://phptravels.net/");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[normalize-space()='Hotels']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"checkin\"]")).click();
        Thread.sleep(2000);
        while (true) {
            String text = driver.findElement(By.xpath("//*[@id=\"#fadein\"]/div[8]/div[1]/table/thead/tr[1]/th[2]")).getText();
            if (text.equals(month)){
                break;
            }
            else {
                driver.findElement(By.xpath("//*[@id=\"#fadein\"]/div[8]/div[1]/table/thead/tr[1]/th[3]")).click();
            }
        }
        driver.findElement(By.xpath("//body[1]/div[8]/div[1]/table[1]/tbody[1]/tr/td[contains(text(),'20')]")).click();
    }
}
