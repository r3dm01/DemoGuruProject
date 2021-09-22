package commonLibs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selectors.newCus.ElementsDelAcc;
import utilities.Utility;

public class DelAcc {

    ElementsDelAcc elementsDelAcc = new ElementsDelAcc();

    public void delAcc(Browsers browser, String customerID){
        try {
            WebElement delAccPage = browser.driver.findElement(By.xpath(elementsDelAcc.delAccPage));
            WebDriverWait wait = new WebDriverWait(browser.driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(delAccPage));
            delAccPage.click();
            WebElement delCusId = browser.driver.findElement(By.xpath(elementsDelAcc.delCusID));
            delCusId.sendKeys(customerID);
            WebElement submitBtn = browser.driver.findElement(By.xpath(elementsDelAcc.subBtn));
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
            submitBtn.click();

            Utility.screenshot(browser.driver, "DELETE ACC");
        }catch (Exception exception){

            exception.printStackTrace();
        }




    }
}
