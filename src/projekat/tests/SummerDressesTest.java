package projekat.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import projekat.pages.Home;

public class SummerDressesTest extends BaseSeleniumTest {

    // Testirati da li kada se na početnoj stranici sajta mišem stane na dugme WOMEN,
    // a zatim odatle odabere SummerDresses odlazi na korektnu stranu.
    @Test
    void testWomenSummerDresses() {

        Home home = new Home(getWebDriver());
        home.goToWomanSummerDresses();

        // provera da je strana korektna
        String expectedPage = "http://automationpractice.com/index.php?id_category=11&controller=category";
        System.out.println("CURRENT URL: " + getWebDriver().getCurrentUrl());
        Assert.assertEquals(expectedPage, getWebDriver().getCurrentUrl(), "Invalid expected SummerDresses page URL!");

        // provera da postoji element
        String expectedCategoryName = "SUMMER DRESSES";
        System.out.println("CATEGORY NAME: " + getWebDriver().findElement(By.xpath("//span[@class='cat-name']")).getText());
        Assert.assertTrue(getWebDriver().findElement(By.xpath("//span[@class='cat-name']")).getText().contains(expectedCategoryName));
    }

    //Testirati da li kada se na početnoj stranici sajta mišem stane na dugme DRESSES,
    // a zatim odatle odabere SUMMER DRESSES odlazi na korektnu stranu.
    @Test
    void testDressesSummerDresses() {

        Home home = new Home(getWebDriver());
        home.goToDressesSummerDresses();

        // provera da je strana korektna
        String expectedPage = "http://automationpractice.com/index.php?id_category=11&controller=category";
        System.out.println("CURRENT URL: " + getWebDriver().getCurrentUrl());
        Assert.assertEquals(expectedPage, getWebDriver().getCurrentUrl(), "Invalid expected SummerDresses page URL!");

        // provera da postoji element
        String expectedCategoryName = "SUMMER DRESSES";
        System.out.println("CATEGORY NAME: " + getWebDriver().findElement(By.xpath("//span[@class='cat-name']")).getText());
        Assert.assertTrue(getWebDriver().findElement(By.xpath("//span[@class='cat-name']")).getText().contains(expectedCategoryName));
    }

    // Proverite da li prethodne dve tačke vode na istu stranicu.
    @Test
    void testSummerDressesSamePage() {

        Home home = new Home(getWebDriver());

        // Women -> SummerDresses
        home.goToWomanSummerDresses();
        String firstAddress = getWebDriver().getCurrentUrl();

        // Dresses -> SummerDresses
        home.goToDressesSummerDresses();
        String secondAddress = getWebDriver().getCurrentUrl();

        // provera
        Assert.assertEquals(firstAddress, secondAddress);
    }
}
