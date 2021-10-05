package commonLibs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selectors.newCus.ElementsDelCus;

public class DelAcc {
        ElementsDelCus elementsDelCus = new ElementsDelCus();

        public void delAccount(Browsers browser, String accountID){

                try{
                        WebElement delAccPage = browser.driver.findElement(By.xpath(elementsDelCus.delAccPage));
                        delAccPage.click();
                        WebElement delAccId = browser.driver.findElement(By.xpath(elementsDelCus.delAccID));
                        delAccId.sendKeys(accountID);
                        WebElement submitBtn = browser.driver.findElement(By.xpath(elementsDelCus.subBtn));
                        submitBtn.click();


                }catch (Exception exception){

                        exception.printStackTrace();
                }
        }


        }
