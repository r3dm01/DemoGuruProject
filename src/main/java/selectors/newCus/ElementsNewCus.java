package selectors.newCus;

public class ElementsNewCus {

    //NEW CUSTOMER
    public String newCustomerPage = "//a[@href=\"addcustomerpage.php\"]";
    public String cusName = "//input[@name=\"name\"]";
    public String cusDOB = "//input[@name=\"dob\"]";
    public String cusAdd = "//textarea[@name=\"addr\"]";
    public String cusCity = "//input[@name=\"city\"]";
    public String cusState = "//input[@name=\"state\"]";
    public String cusPin = "//input[@name=\"pinno\"]";
    public String cusMobNum = "//input[@name=\"telephoneno\"]";
    public String cusEmail = "//input[@name=\"emailid\"]"; //CHANGE BEFORE EVERY TEST
    public String cusPassword = "//input[@name=\"password\"]";
    public String submitBtn = "//input[@name=\"sub\"]";

    public String newCus = "//p[@class=\"heading3\"]";
    public String cusID = "//tr[4]/td[2]";

    //NEW ACCOUNT
    public String newAccPage = "//a[@href=\"addAccount.php\"]";
    public String customerId = "//input[@name=\"cusid\"]";
    public String accTyp = "//select[@name=\"selaccount\"]";
    public String initDep = "//input[@name=\"inideposit\"]";

    public String subBtn = "//input[@value=\"submit\"]";


    public String newAccTable  = "//table[@id=\"account\"]";
    public String newAccID = "//tr[4]/td[2]";



}
