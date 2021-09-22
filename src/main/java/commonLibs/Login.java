package commonLibs;

import inputs.Inputs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selectors.login.ElementLogin;

public class Login {


    ElementLogin elementsLogin = new ElementLogin();
    Inputs input = new Inputs();

    public void loginSetup(String userName, String passWord, Browsers browser){
        try {
            //HOME PAGE SETUP
            browser.setHomePage(input.baseUrl);
            WebElement username = browser.driver.findElement(By.xpath(elementsLogin.username));
            username.sendKeys(userName);

            WebElement password = browser.driver.findElement(By.xpath(elementsLogin.password));
            password.sendKeys(passWord);

            WebElement loginBtn = browser.driver.findElement(By.xpath(elementsLogin.loginBtn));
            loginBtn.click();
        }catch (Exception exception){

            exception.printStackTrace();
        }
    }


}
