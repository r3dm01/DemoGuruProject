package commonLibs;

import inputs.Inputs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selectors.newCus.ElementsNewCus;

public class NewCus {

    Inputs input = new Inputs();
    ElementsNewCus elementsNewCus = new ElementsNewCus();

    public void newCustomer(Browsers browser){

        try {
            WebElement newCusPage = browser.driver.findElement(By.xpath(elementsNewCus.newCustomerPage));
            newCusPage.click();

            WebElement cusNamebox = browser.driver.findElement(By.xpath(elementsNewCus.cusName));
            cusNamebox.sendKeys(input.cusName);

            WebElement cusDOBbox = browser.driver.findElement(By.xpath(elementsNewCus.cusDOB));
            cusDOBbox.sendKeys(input.dateOBirth);

            WebElement cusAddBox = browser.driver.findElement(By.xpath(elementsNewCus.cusAdd));
            cusAddBox.sendKeys(input.address);

            WebElement cusCity = browser.driver.findElement(By.xpath(elementsNewCus.cusCity));
            cusCity.sendKeys(input.city);


            WebElement cusState = browser.driver.findElement(By.xpath(elementsNewCus.cusState));
            cusState.sendKeys(input.state);

            WebElement cusPin = browser.driver.findElement(By.xpath(elementsNewCus.cusPin));
            cusPin.sendKeys(input.pin);

            WebElement cusMobNm = browser.driver.findElement(By.xpath(elementsNewCus.cusMobNum));
            cusMobNm.sendKeys(input.mobileNum);

            //Change This before each test
            WebElement cusEmail = browser.driver.findElement(By.xpath(elementsNewCus.cusEmail));
            cusEmail.sendKeys(input.emailAdd);

            WebElement cusPwd = browser.driver.findElement(By.xpath(elementsNewCus.cusPassword));
            cusPwd.sendKeys(input.password);

            WebElement submitButn = browser.driver.findElement(By.xpath(elementsNewCus.submitBtn));
            submitButn.click();

            Thread.sleep(2000);

        }catch (Exception exception){

            exception.printStackTrace();
        }
        }
}
