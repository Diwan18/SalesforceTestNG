package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseSalesforceclass {
	
	public  ChromeDriver driver;
	public ChromeOptions chromeoption;
	@BeforeMethod
	public void PreCondition() throws InterruptedException{
		
		chromeoption = new ChromeOptions();
		chromeoption.addArguments("--disable-notifications");		
		driver = new ChromeDriver(chromeoption);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
	}
	
	@AfterMethod
	public void PostCondition() {
		
	driver.quit();
	}

}
