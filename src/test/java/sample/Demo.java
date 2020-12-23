package sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {

	String spreadsheetId = "1ty-PpPVeeyqPsJj9W3t7Wo-z5wqONcUZRq0ZR06xWF8";
	@Test
	public void register() {
		try {
			
			String url = System.getProperty("AppUrlValue");
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\BrowserDriversEXE\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
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

			ReadWriteGoogleSheet sample = new ReadWriteGoogleSheet();
			String str = sample.getData(spreadsheetId, "Username");
			System.out.println(str);
			sample.updateData(spreadsheetId, str, dtf.format(now));
			
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
