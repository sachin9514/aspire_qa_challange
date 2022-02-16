package pom_aspire;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Aspire_login 
{
@FindBy(xpath="//input[@name='login']") private WebElement userid;
@FindBy(xpath="//input[@name='password']") private WebElement pass;
@FindBy(xpath = "//button[@type='submit']") private WebElement login_button;

public Aspire_login(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void enter_usre_id(String ID)
{
	userid.sendKeys(ID);
}
public void enter_password(String PWD)
{
	pass.sendKeys(PWD);
}
public void clickon_login() 
{
	login_button.click();
}


}
