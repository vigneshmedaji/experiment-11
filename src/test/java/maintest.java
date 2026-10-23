
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class maintest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testIncrementButton() {
        File htmlFile = new File("program.html");
        driver.get(htmlFile.toURI().toString());

        // Verify initial value
        String initialValue =
                driver.findElement(By.id("output")).getText();
        assertEquals("0", initialValue);

        // Click the Increment button
        driver.findElement(By.id("increment-button")).click();

        // Verify updated value
        String result =
                driver.findElement(By.id("output")).getText();
        assertEquals("1", result);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
