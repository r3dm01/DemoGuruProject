package commonLibs;

import inputs.Inputs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import selectors.newCus.ElementsNewCus;

public class NewAcc {

    Inputs input = new Inputs();
    ElementsNewCus elementsNewCus = new ElementsNewCus();


    public void newAcc(Browsers browser, String customerID) {
        try {
            WebElement newAccPage = browser.driver.findElement(By.xpath(elementsNewCus.newAccPage));
            newAccPage.click();
            WebElement customerId = browser.driver.findElement(By.xpath(elementsNewCus.customerId));
            customerId.sendKeys(customerID);

            WebElement accType = browser.driver.findElement(By.xpath(elementsNewCus.accTyp));
            Select select = new Select(accType);
            select.selectByValue("Current");

            WebElement initialDep = browser.driver.findElement(By.xpath(elementsNewCus.initDep));
            initialDep.sendKeys("5000");

            WebElement subBtn = browser.driver.findElement(By.xpath(elementsNewCus.subBtn));
            subBtn.click();


        }catch (Exception exception){

            exception.printStackTrace();
        }
    }
}
