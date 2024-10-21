package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LegalEntityClass extends BaseSalesforceclass {
	@Test
	public void LegalEC() throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		Actions action = new Actions(driver);
		WebElement legalEntity = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		action.moveToElement(legalEntity).click().perform();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]")).click();
		
		WebElement LEdropdown = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LEdropdown);
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation By Diwan");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement LEName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='outputField']"));
		String EntityName = LEName.getText();
		System.out.println(EntityName);
		Assert.assertEquals(EntityName, "Salesforce Automation By Diwan");
		System.out.println("The Legal Entity Name is Verified");
		driver.close();
		
	}

}
