package projekat.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import projekat.pages.Home;

public class HaljineTest extends BaseSeleniumTest {

    // Odabrati drugu haljinu koja se nalazi u Summer Dresses ponudi.
    // Staviti u korpu dve takve haljine, M veličine u beloj boji.

    // Proveriti da li se u korpi zaista nalaze dve haljine sa odgovarajućim nazivom, u beloj boji, M veličine.
    @Test
    void summerDressesDrugaHaljina2xTest() throws InterruptedException {

        // actions
        Actions actions = new Actions(getWebDriver());

        // odlazak na homepage i prelazak na Summer Dresses stranu
        Home home = new Home(getWebDriver());
        home.goToWomanSummerDresses();
        System.err.println(">>> SUMMER DRESSES PAGE REACHED!");

        // odabiranje druge haljine iz liste
        WebElement secondDress = getWebDriver().findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-line last-item-of-tablet-line last-mobile-line']//a[@class='product_img_link']"));
        actions.moveToElement(secondDress).click().build().perform();
        System.err.println(">>> DRUGA HALJINA ODABRANA!");

        //odabir boje (WHITE)
        WebElement color = getWebDriver().findElement(By.name("White"));
        actions.click(color).build().perform();
        System.err.println(">>> WHITE BOJA ODABANA!");

        // unos kolicine haljina (2)
        WebElement quantity = getWebDriver().findElement(By.xpath("//input[@id='quantity_wanted']"));
        quantity.clear();
        quantity.sendKeys("2");
        System.err.println(">>> KOLICINA ODABANA!");

        //selektovanje velicine (M)
        Select velicinaHaljine = new Select(getWebDriver().findElement(By.xpath("//select[@id='group_1']")));
        velicinaHaljine.selectByVisibleText("M");
        System.err.println(">>> VELICINA ODABANA!");

        //add to card
        WebElement AddToCard = getWebDriver().findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        actions.click(AddToCard).build().perform();
        System.err.println(">>> UBACENO U KORPU!");

        // provera
        // cekamo da se ucita strana gde je prikazana korpa
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='layer_cart_product_title']")));

        // title-> //span[@id='layer_cart_product_title']
        WebElement productTitle = getWebDriver().findElement(By.xpath("//span[@id='layer_cart_product_title']"));
        Assert.assertEquals(productTitle.getText(), "Printed Summer Dress");

        // white, M -> //span[@id='layer_cart_product_attributes']
        WebElement atributiHaljine = getWebDriver().findElement(By.xpath("//span[@id='layer_cart_product_attributes']"));
        Assert.assertEquals(atributiHaljine.getText(), "White, M");

        // quantity:2 -> //span[@id='layer_cart_product_quantity']
        WebElement kolicinaHaljina = getWebDriver().findElement(By.xpath("//span[@id='layer_cart_product_quantity']"));
        Assert.assertEquals(kolicinaHaljina.getText(), "2");

        // total price -> //span[@id='layer_cart_product_price']
        WebElement ukupnaCena = getWebDriver().findElement(By.xpath("//span[@id='layer_cart_product_price']"));
        Assert.assertEquals(ukupnaCena.getText(), "$61.00");
    }
}
