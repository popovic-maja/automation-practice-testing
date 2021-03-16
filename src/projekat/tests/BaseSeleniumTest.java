package projekat.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseSeleniumTest extends BaseTest{

    static WebDriver WEB_DRIVER;

    public WebDriver getWebDriver() {
        return WEB_DRIVER;
    }

    @BeforeSuite
    public void openBrowser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\38163\\Desktop\\chromedriver_win32\\chromedriver.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();

        ChromeOptions options = new ChromeOptions().merge(capabilities);

        WEB_DRIVER = new ChromeDriver(service, options);
        WEB_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WEB_DRIVER.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WEB_DRIVER.manage().window().maximize();
    }

    @AfterSuite
    public void closeBrowser() {
//        WEB_DRIVER.close();
        for(String tab: WEB_DRIVER.getWindowHandles()){
            getWebDriver().switchTo().window(tab).close();
        }
    }

    @DataProvider(name = "ExcelPodaci")
    public static Object[][] excelData() {
        return getExcelData("MOCK_DATA_2.xlsx", 0);
    }
}
