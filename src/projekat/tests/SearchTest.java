package projekat.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import projekat.pages.Home;

import java.util.List;

public class SearchTest extends BaseSeleniumTest {

    //Testirati da li radi ‘search’ bar. Ukucati ‘yellow’ i ispitati rezultat pretrage.
    // Očekivan ishod je prikaz tri artikla, pri čemu svaki od njih ima mogućnost odabira žute boje.
    @Test
    void searchBarTest() throws InterruptedException {

        Home home = new Home(getWebDriver());
        WebElement search = home.getSearchbar();

        search.clear();
        search.sendKeys("yellow");
        search.sendKeys(Keys.ENTER);

        // cekamo da se ucita strana
        Thread.sleep(2_000);

        // provera da ima 3 artikla
        List<WebElement> items = getWebDriver().findElements(By.xpath("//ul[@class='product_list grid row']/li"));
        System.err.println(">>>> List size is: " + items.size());
        Assert.assertEquals(3, items.size());


        // provera da ima 3 zute boje
        List<WebElement> colours = getWebDriver().findElements(By.className("color_pick"));
        int yellowIcons = 0;
        for (WebElement we : colours) {
            if (we.getCssValue("background-color").trim().equalsIgnoreCase("rgba(241, 196, 15, 1)")) {
                yellowIcons++;
            }
        }
        Assert.assertEquals(3, yellowIcons);
    }
}
