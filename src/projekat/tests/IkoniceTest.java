package projekat.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import projekat.pages.Home;

import java.util.ArrayList;

public class IkoniceTest extends BaseSeleniumTest {


    // Proveriti da li ikonice koje se nalaze u meniju na kraju stranice vode na odgovarajuće adrese
    // (ikonice za Facebook, Twitter, YouTube...)
    @Test
    void ikoniceTest() throws InterruptedException {

        // go to website
        Home home = new Home(getWebDriver());
        home.goToWebpage();
        Actions actions = new Actions(getWebDriver());

        //////////////

        // facebook icon
        WebElement faceboook = getWebDriver().findElement(By.xpath("//li[@class='facebook']//a"));
        faceboook.click();

        // prebaci se na novi tab
        ArrayList<String> tabs = new ArrayList<> (getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1)); //switches to new tab

        // proveri da li je adresa dobra
        String expectedPage = "https://www.facebook.com/groups/525066904174158/";
        Assert.assertEquals(expectedPage, getWebDriver().getCurrentUrl());
        getWebDriver().close(); // close new window

        getWebDriver().switchTo().window(tabs.get(0)); //switches back to starting tab

        //////////////

        // twitter icon
        WebElement twitter = getWebDriver().findElement(By.xpath("//li[@class='twitter']//a"));
        twitter.click();

        // prebaci se na novi tab
        tabs = new ArrayList<> (getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1)); //switches to new tab

        // proveri da li je adresa dobra
        String twitterPage = "https://twitter.com/seleniumfrmwrk";
        Assert.assertEquals(twitterPage, getWebDriver().getCurrentUrl());
        getWebDriver().close(); // close new window

        getWebDriver().switchTo().window(tabs.get(0)); //switches back to starting tab

        //////////////

        // youtube icon
        WebElement youtube = getWebDriver().findElement(By.xpath("//li[@class='youtube']//a"));
        youtube.click();

        // prebaci se na novi tab
        tabs = new ArrayList<> (getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1)); //switches to new tab

        // proveri da li je adresa dobra
        String youtubePage = "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA";
        Assert.assertEquals(youtubePage, getWebDriver().getCurrentUrl());
        getWebDriver().close(); // close new window

        getWebDriver().switchTo().window(tabs.get(0)); //switches back to starting tab
    }
}
