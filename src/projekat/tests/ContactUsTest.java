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

public class ContactUsTest extends BaseSeleniumTest {

    // Kliknuti na “Contact us” i proveriti formu za slanje korisničkih pitanja.
    @Test
    void contactUsTest() throws InterruptedException {

        Home home = new Home(getWebDriver());
        home.goToContactUs();
        Actions actions = new Actions(getWebDriver());

        // popunjavamo formu
        //selektovanje Subject Heading
        Select subjectSelect = new Select(getWebDriver().findElement(By.xpath("//select[@id='id_contact']")));
        subjectSelect.selectByVisibleText("Customer service");

        // popunimo email
        WebElement emailPolje = getWebDriver().findElement(By.xpath("//input[@id='email']"));
        emailPolje.clear();
        emailPolje.sendKeys("test@email.com");

        // popunimo Order reference
        WebElement order = getWebDriver().findElement(By.xpath("//input[@id='id_order']"));
        order.clear();
        order.sendKeys("12345");

        // popunimo message
        WebElement message = getWebDriver().findElement(By.xpath("//textarea[@id='message']"));
        message.clear();
        message.sendKeys("Ovo je testna poruka!");

        // submitujemo poruku
        WebElement submitDugme = getWebDriver().findElement(By.xpath("//span[contains(text(),'Send')]"));
        submitDugme.click();

        // proverimo da je uspesno poslata poruka
        // Your message has been successfully sent to our team.
        WebDriverWait waitForSuccess = new WebDriverWait(getWebDriver(), 5);
        waitForSuccess.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='alert alert-success']")));

        // provera da je postoji text o uspesnosti
        WebElement success = getWebDriver().findElement(By.xpath("//p[@class='alert alert-success']"));
        Assert.assertTrue(success.getText().contains("Your message has been successfully sent to our team."));
    }
}
