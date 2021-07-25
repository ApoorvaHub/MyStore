package expackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Filedownload {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/generate-file-to-download-demo.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), \"File to Download\")]")));
		WebElement EnterData = driver.findElement(By.id("textbox"));
		EnterData.sendKeys("By default Download link will be hidden");
		WebElement GenerateFile = driver.findElement(By.id("create"));
		wait.until(ExpectedConditions.elementToBeClickable(GenerateFile)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Download"))).click();
	}
}
