package pom_aspire;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Aspire_base 
{
	public static void capturescreenshoat(WebDriver driver,int tcid) throws IOException
	{
		File sorce = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\JAVA\\screenshot\\testid"+tcid+".png");
		FileHandler.copy(sorce, dest);
		
	}
}
