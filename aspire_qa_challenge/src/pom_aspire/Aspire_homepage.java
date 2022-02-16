package pom_aspire;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Aspire_homepage 
{
@FindBy(xpath = "(//div[@class='o_caption'])[2]") private WebElement inventory;
@FindBy(xpath = "//a[@id='result_app_2']") private WebElement manufacturing;

public Aspire_homepage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void click_on_inventory()
{
	inventory.click();	
}
public void click_manufacturing()
{
	manufacturing.click();
}
}

