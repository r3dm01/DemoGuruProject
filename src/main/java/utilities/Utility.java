package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class Utility {

    public static void screenshot(WebDriver driver, String filename){
        try{

            TakesScreenshot scrnsht = (TakesScreenshot) driver;
            File source = scrnsht.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File("src/Screenshots/"+filename+".png"));
            System.out.println("Screenshot Captured... \n Path : "+filename+".png");

        }catch (Exception exc){

            exc.printStackTrace();
        }

    }
}
