package projekat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Card {
    public static String haljina="//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";
    public static  String color="//a[@id='color_8']";
    public static String size="//select[@id='group_1']";
    public static String qantity="//i[@class='icon-plus']";
    public static String addCard="//span[contains(text(),'Add to cart')]";

    public static String getHaljina(WebDriver driver){
        return driver.findElement(By.xpath(haljina)).getText();

    }
    public static String getQantity(WebDriver driver){
        return driver.findElement(By.xpath(qantity)).getText();
    }
}
