package NewTabWindow;

import org.testng.annotations.Test;

public class TestRunner extends Setup {
    NewTabWindowElements newTabWindow;

    @Test(priority = 1)
    public void testIsLogoDisplayed() throws InterruptedException{
        newTabWindow = new NewTabWindowElements(driver);
        newTabWindow.isLogoDisplayed();
        Thread.sleep(500);
    }

    @Test(priority = 2)
    public void testNewTabOrWindow() throws InterruptedException {
        newTabWindow.newTabOrWindow();
        Thread.sleep(1000);
    }
}
