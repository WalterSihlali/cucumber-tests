import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import java.io.File;
import java.io.IOException;

public class TestBase {

        private static ChromeDriverService service;
        private WebDriver driver;

        @BeforeClass
        public static void createAndStartService() {
            try {
                service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("C:\\Users\\Public\\Documents\\testingProjects\\chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                service.start();
            } catch (IOException ex) {
            }

        }

        @AfterClass
        public static void createAndStopService() {
            service.stop();
        }

        @Before
        public void createDriver() {
            driver = new ChromeDriver();
        }

        @After
        public void quitDriver() {
            if(driver != null) {
                driver.quit();
            }
        }

        @Test
        public void testGoogleSearch() {
            driver.get("http://www.store.demoqa.com");
             driver.findElement(By.xpath("//*[@id=\"dk1\"]")).click();
//            boolean displayed = driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li[1]/a/div[2]/span[2]")).isDisplayed();
            // rest of the test...
        }
    }
