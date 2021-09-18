import commonLibs.Browsers;
import inputs.Inputs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selectors.login.ElementLogin;
import utilities.Utility;

public class TestLogin {

    Browsers browser = new Browsers();
    Inputs input = new Inputs();
    ElementLogin elementsLogin = new ElementLogin();

    @BeforeMethod
    public void homePage(){

        browser.chromeBrowser(input.baseUrl);
    }

    @Test(description = "Test Login Functionality", dataProvider = "Credentials")
    public void loginTest(String userName, String passWord){

        try {
            WebElement username = browser.driver.findElement(By.xpath(elementsLogin.username));
            username.sendKeys(userName);

            WebElement password = browser.driver.findElement(By.xpath(elementsLogin.password));
            password.sendKeys(passWord);

            WebElement loginBtn = browser.driver.findElement(By.xpath(elementsLogin.loginBtn));
            loginBtn.click();

            WebElement mID = browser.driver.findElement(By.xpath(elementsLogin.mID));
            String aMID = mID.getText();
            String eMID = "Manger Id : mngr354191";

            Assert.assertEquals(aMID, eMID);

            if (aMID.equals(eMID)) {
                Utility.screenshot(browser.driver, "Login Successful");
            }
        }catch (Exception exception){

            exception.printStackTrace();
        }
    }

    @DataProvider(name="Credentials")
    public Object[][] loginCredentials(){

        Object[][] loginCredentials = new Object[4][2];
        //R1-Valid userId / Valid password
        loginCredentials[0][0] = "mngr354191";
        loginCredentials[0][1] = "EmYbepu";

        //R2-Invalid userId / Valid password
        loginCredentials[1][0] = "xyz@abc.com";
        loginCredentials[1][1] = "EmYbepu";

        //R3-Valid userid / Invalid password
        loginCredentials[2][0] = "mngr354191";
        loginCredentials[2][1] = "xyz@abc";

        //R4-Invalid userId / Invalid password
        loginCredentials[3][0] = "xyz@abc.com";
        loginCredentials[3][1] = "xyz@abc";

        return loginCredentials;
    }

    @AfterMethod
    public void tearDown(){

        browser.driver.close();
        browser.driver.quit();
    }
}
