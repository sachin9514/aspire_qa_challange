package test_aspire;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom_aspire.Aspire_base;
import pom_aspire.Aspire_homepage;
import pom_aspire.Aspire_login;

public class Aspire_inventory extends Aspire_base
{
	WebDriver driver;
	Aspire_login loginpg;
	Aspire_homepage homepg;
	Aspire_base screenshot;
	public void startbrowser() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "E:\\JAVA\\selenium\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		 driver.get("https://aspireapp.odoo.com");
		 driver.manage().window().maximize();
}
	@BeforeClass
	public void stratbrowser() throws InterruptedException
	{
			startbrowser();
	}
		@BeforeMethod
		public void login_aspire()
		{
			String ID="user@aspireapp.com";
			String PWD= "@sp1r3app";
			loginpg= new Aspire_login(driver);
			
			loginpg.enter_usre_id(ID);
			Reporter.log("Enterning the userid", true);
			loginpg.enter_password(PWD);
			Reporter.log("Enterning the password", true);
			loginpg.clickon_login();
			Reporter.log("clicking on login button", true);
			homepg=new Aspire_homepage(driver);
			homepg.click_on_inventory();
			Reporter.log("click on inventory", true);
		}
	@Test
	public void  Aspire_inventry_test() throws IOException, InterruptedException
	  {
		int tcid=01;
	
	driver.findElement(By.xpath("//span[@data-section='120']")).click();
	Reporter.log("click on products", true);
	driver.findElement(By.xpath("//a[@data-section='124']")).click();
	driver.findElement(By.xpath("//button[@title='Create record']")).click();
	Reporter.log("click on creat", true);
	driver.findElement(By.xpath("//input[@name='name']")).sendKeys("paneer");
	Reporter.log("Enter the product name sucessfully", true);
	driver.findElement(By.xpath("//span[text()='Update Quantity']")).click();
	Reporter.log("click on update quntity", true);
	Aspire_base.capturescreenshoat(driver, tcid);
	Reporter.log("Taking screenshot for updated qty", true); 
	driver.findElement(By.xpath("//button[@class='btn btn-primary o_list_button_add']")).click();
	WebElement qty = driver.findElement(By.xpath("//input[@name='inventory_quantity']"));
	qty.clear();
	qty.sendKeys("11.00");
	Reporter.log("update the product quntity sucessfully", true);
	driver.findElement(By.xpath("//a[@title='Home menu']")).click();
	Reporter.log("click on application icon", true);
	driver.findElement(By.xpath("//a[@id='result_app_2']")).click();
	Reporter.log("nevigate to Manufacturing and click on Manufacturing", true);
	driver.findElement(By.xpath("//button[@class='btn btn-primary o_list_button_add']")).click();
	Reporter.log("click on creat button", true);
	WebElement dd = driver.findElement(By.xpath("(//input[@class='o_input ui-autocomplete-input'])[1]"));
	dd.sendKeys("paneer");
	Reporter.log("sending the oreder name", true);
	List<WebElement> ddlist = driver.findElements(By.xpath("(//ul[@tabindex='0'])[1]//li"));
	String expectedresult= "paneer";
	for(WebElement w: ddlist)
	{		
		System.out.println(w.getText());
		String actual = w.getText();				
		if(actual.equalsIgnoreCase(expectedresult))
		{
			w.click();
			break;
		}
	  }
	driver.findElement(By.xpath("(//input[@name='product_qty'])[1]")).clear();
	driver.findElement(By.xpath("(//input[@name='product_qty'])[1]")).sendKeys("11.00");
	Aspire_base.capturescreenshoat(driver, 01);
	  }	
}
