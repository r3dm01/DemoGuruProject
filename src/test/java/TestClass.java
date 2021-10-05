import commonLibs.*;
//import inputs.Inputs;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selectors.login.ElementLogin;
import selectors.newCus.ElementsNewCus;
import utilities.Utility;

public class TestClass {

    Browsers browser = new Browsers();
    Login login = new Login();
    ElementLogin elementsLogin = new ElementLogin();
    NewCus newCus = new NewCus();
    ElementsNewCus elementsNewCus = new ElementsNewCus();
//    Inputs input = new Inputs();
    NewAcc newAcc = new NewAcc();
    DelCus delCus = new DelCus();
    DelAcc delAcc = new DelAcc();

    //Customer ID and Account ID
    public String newCusID;
    public String newAccountID;

    @BeforeMethod
    public void homePage(){

        browser.chromeBrowser();

    }

    @Test(priority = 1, description = "Test Login Functionality", dataProvider = "Credentials", enabled = false)
    public void loginTest(String userID, String passcode){

        try {

            //LOGIN
            login.loginSetup(userID, passcode, browser);

            //VERIFICATION OF MANAGER ID

            WebElement mID = browser.driver.findElement(By.xpath(elementsLogin.mID));

            if(mID.isDisplayed()){

                String aMID = mID.getText();
                String eMID = "Manger Id : mngr354191";
                Assert.assertEquals(aMID, eMID);
                Utility.screenshot(browser.driver, "Login Successful");

            }else{
                //ALERT ACCEPTING
                Alert alert = browser.driver.switchTo().alert();
                System.out.println("ALERT MESSAGE : " + alert.getText());
                alert.accept();
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    //DATA PROVIDER FOR TESTING LOGIN
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

    @Test(priority = 2, description = "Add New Customer, assign an Account and delete the account and customer", enabled = true)
    public void newCusAcc(){

        try{
        //LOGIN
        login.loginSetup("mngr354191", "EmYbepu", browser);
        //ADDING NEW CUSTOMER
        newCus.newCustomer(browser);

//        CHANGE input.emailAdd BEFORE EVERY TEST
        WebElement newCus = browser.driver.findElement(By.xpath(elementsNewCus.newCus));
        String aMessage = newCus.getText();
        String eMessage = "Customer Registered Successfully!!!";
        Assert.assertEquals(aMessage, eMessage);
        if(newCus.isDisplayed()){

            WebElement cusID = browser.driver.findElement(By.xpath(elementsNewCus.cusID));
            String NcusID = cusID.getText();
            Utility.screenshot(browser.driver, "CustomerID-"+NcusID);

            newCusID = NcusID;
        }
        //ADDING NEW ACCOUNT TO NEWLY CREATED CUSTOMER
        newAcc.newAcc(browser, newCusID);

        WebElement newAccTable = browser.driver.findElement(By.xpath(elementsNewCus.newAccTable));
        if(newAccTable.isDisplayed()) {

            WebElement newAccId = browser.driver.findElement(By.xpath(elementsNewCus.newAccID));
            String accountID = newAccId.getText();

            Utility.screenshot(browser.driver, "AccountID-"+accountID);

            newAccountID = accountID;
        }

            //DELETE ACCOUNT CREATED ABOVE
            delAcc.delAccount(browser, newAccountID);
            //CONFORMATION ALERT
            WebDriverWait webDriverWait = new WebDriverWait(browser.driver, 15);
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            String ConfirmationAlrtMsg = browser.driver.switchTo().alert().getText();
            System.out.println(ConfirmationAlrtMsg);
            browser.driver.switchTo().alert().accept();
            //ALERT
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            String AlertMessage = browser.driver.switchTo().alert().getText();
            System.out.println(AlertMessage);
            browser.driver.switchTo().alert().accept();

            //DELETE CUSTOMER (ONLY AFTER DELETING ALL ACCOUNTS FOR THE CUSTOMER)
            delCus.delCustomer(browser, newCusID);
            //CONFIRMATION ALERT
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            String ConAlertMess = browser.driver.switchTo().alert().getText();
            System.out.println(ConAlertMess);
            browser.driver.switchTo().alert().accept();
            //ALERT
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            String AlertMess = browser.driver.switchTo().alert().getText();
            System.out.println(AlertMess);
            browser.driver.switchTo().alert().accept();

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }


    @AfterMethod
    public void tearDown(){

        browser.driver.close();
        browser.driver.quit();
    }
}
