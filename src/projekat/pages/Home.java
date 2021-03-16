package projekat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home {

    public static final String URL = "http://automationpractice.com/index.php";
    public static String dugmeWomen ="//a[@class='sf-with-ul'][contains(text(),'Women')]";
    public static String urlSummerDresses="http://automationpractice.com/index.php?id_category=11&controller=category";
    public static String dugmeDresses ="//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]";
    public static String dugmeMenuDresssByXpath="//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";
    public static String dugmeSearchBar="//input[@id='search_query_top']";

    private final WebDriver webDriver;

    public Home(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToWomanSummerDresses(){

        // go to website
        webDriver.get(URL);

        // mouse over "women" button
        Actions actions = new Actions(webDriver);
        WebElement women = webDriver.findElement(By.xpath(dugmeWomen));
        actions.moveToElement(women).build().perform();

        // odabiranje SummerDresses opcije iz menija (nakon pomeranja misa iznad dugmeta "women")
        WebElement summerDresses = webDriver.findElement(By.xpath(dugmeMenuDresssByXpath));
        actions.click(summerDresses).build().perform();
    }

    public void goToDressesSummerDresses() {

        // go to website
        webDriver.get(URL);

        // postavljanje misa preko dugmeta DRESSES
        Actions actions = new Actions(webDriver);
        WebElement dresses = webDriver.findElement(By.xpath(dugmeDresses));
        actions.moveToElement(dresses).build().perform();

        // odabiranje SummerDresses opcije iz menija
        WebElement summerDresses = webDriver.findElement(By.xpath(dugmeMenuDresssByXpath));
        actions.click(summerDresses).build().perform();
    }

    public void goToContactUs(){

        // go to website
        webDriver.get(URL);

        // click on contactUs
        WebElement contactUsButton = webDriver.findElement(By.xpath(Contact.contactUsXpath));
        contactUsButton.click();
    }

    public WebElement getSearchbar(){

        // go to website
        webDriver.get(URL);

        // return search element
        return webDriver.findElement(By.xpath(dugmeSearchBar));
    }

    public void goToWebpage() {
        // go to website
        webDriver.get(URL);
    }

}
