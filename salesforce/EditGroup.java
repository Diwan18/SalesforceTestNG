package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
@Test
public class EditGroup extends BaseSalesforceclass{
	
	public  void EditG() throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		Actions click = new Actions(driver);
		
		WebElement workTypeGroups = driver.findElement(By.xpath("//span/p[text()='Work Type Groups']"));
		
		click.moveToElement(workTypeGroups).click().perform();
		
		Thread.sleep(50);
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']"));
		searchbox.clear();
		searchbox.sendKeys("Salesforce Automation By Mohammad",Keys.ENTER);
		Thread.sleep(3000);
		JavascriptExecutor Executer = (JavascriptExecutor) driver;
		WebElement table = driver.findElement(By.xpath("//table/tbody/tr/th/span/a[@title='Salesforce Automation By MohammadDiwan']"));
		Thread.sleep(8000);
		String text = table.getText();
		if(text.equalsIgnoreCase("Salesforce Automation By MohammadDiwan")) {
			WebElement downicon = driver.findElement(By.xpath("//table/tbody/tr/td/span/div/a"));
			
			
			Executer.executeScript("arguments[0].click();",downicon);
		}
		
		
		
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		
		Thread.sleep(6000);
		
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).clear();
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@aria-label='Group Type']")).click();
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
		
		WebElement groupname = driver.findElement(By.xpath("//table/tbody/tr/th/span/a[@title='Salesforce Automation By MohammadDiwan']"));
		Executer.executeScript("arguments[0].click();",groupname);
		WebElement Description = driver.findElement(By.xpath("//slot/lightning-formatted-text[text()='Automation']"));
		String desctext = Description.getText();
		System.out.println(desctext);
		if(desctext.equalsIgnoreCase("Automation")) {
			System.out.println("Description is verified ");
			
			
		}else {
			System.out.println("Description is not matched");
		}
		
		driver.close();
	}

}
