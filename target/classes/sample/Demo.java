package sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	@Test
	public void register() {
		try {
			WebDriver driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDriversEXE\\chromedriver.exe"); 	
			driver.get("https://demoqa.com/register");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			driver.findElement(By.id("firstname")).sendKeys("Arunava");
			driver.findElement(By.id("lastname")).sendKeys("Chatterjee");
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
			LocalDateTime now = LocalDateTime.now();  
			System.out.println(dtf.format(now));
			
			driver.findElement(By.id("userName")).sendKeys(dtf.format(now));
			driver.findElement(By.id("password")).sendKeys("Pasword1$");
			
			Thread.sleep(5000);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
