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

public class PitanjaIzExcelaTest extends BaseSeleniumTest {

    // Poslati 30 pitanja pri čemu se podaci o svakoj poruci čitaju iz xlsx ili xls fajla.
    // Za svaku poruku proveriti da li je slanje bilo uspešno.
    @Test(dataProvider = "ExcelPodaci")
    void slanje30PitanjaTest(String email, String orderReference, String message) {

        System.out.println("Testiram formu za sledece vrednosti -> email:" + email + ", orderReference:" + orderReference + ", message:" + message);

        Home home = new Home(getWebDriver());
        home.goToContactUs();

        // popunjavamo formu
        //selektovanje Subject Heading
        Select subjectSelect = new Select(getWebDriver().findElement(By.xpath("//select[@id='id_contact']")));
        subjectSelect.selectByVisibleText("Customer service");

        // popunimo email
        WebElement emailPolje = getWebDriver().findElement(By.xpath("//input[@id='email']"));
        emailPolje.clear();
        emailPolje.sendKeys(email);

        // popunimo Order reference
        WebElement order = getWebDriver().findElement(By.xpath("//input[@id='id_order']"));
        order.clear();
        order.sendKeys(orderReference);

        // popunimo message
        WebElement messageElement = getWebDriver().findElement(By.xpath("//textarea[@id='message']"));
        messageElement.clear();
        messageElement.sendKeys(message);

        // submitujemo poruku
        WebElement submitDugme = getWebDriver().findElement(By.xpath("//span[contains(text(),'Send')]"));
        submitDugme.click();

        // proverimo da je uspesno poslata poruka
        // Your message has been successfully sent to our team.
        WebDriverWait waitForSuccess = new WebDriverWait(getWebDriver(), 2);
        waitForSuccess.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='alert alert-success']")));

        // provera da je postoji text o uspesnosti
        WebElement success = getWebDriver().findElement(By.xpath("//p[@class='alert alert-success']"));
        Assert.assertTrue(success.getText().contains("Your message has been successfully sent to our team."));

    }
}
