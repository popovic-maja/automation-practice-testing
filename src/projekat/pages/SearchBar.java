package projekat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchBar {
    public static String serchBarPage="http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=yellow&submit_search=";

    public static String className="search_query form-control ac_input";
    public static WebElement getClassName(WebDriver driver){
        return driver.findElement(By.className(className));
    }
}
