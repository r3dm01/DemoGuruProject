package commonLibs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selectors.newCus.ElementsDelCus;

public class DelCus {

    ElementsDelCus elementsDelCus = new ElementsDelCus();

    public void delCustomer(Browsers browser, String customerID){
        try {
            WebElement delCusPage = browser.driver.findElement(By.xpath(elementsDelCus.delCusPage));
            WebDriverWait wait = new WebDriverWait(browser.driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(delCusPage));
            delCusPage.click();
            WebElement delCusId = browser.driver.findElement(By.xpath(elementsDelCus.delCusID));
            delCusId.sendKeys(customerID);
            WebElement submitBtn = browser.driver.findElement(By.xpath(elementsDelCus.subBtn));
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
            submitBtn.click();

//            Utility.screenshot(browser.driver, "DELETE ACC");
        }catch (Exception exception){

            exception.printStackTrace();
        }




    }
}
