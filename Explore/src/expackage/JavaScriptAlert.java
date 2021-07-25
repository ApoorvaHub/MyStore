package expackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), \"JavaScript\")]")));
		driver.findElement(By.xpath("//*[@class = 'btn btn-default']")).click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", clickme);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		Thread.sleep(3000);
		System.out.println("--------------------------------------------------------------");
		driver.findElement(By.xpath("//*[@class = 'btn btn-default btn-lg' and text() = \"Click me!\"]")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.dismiss();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class = 'btn btn-default btn-lg' and text() = \"Click for Prompt Box\"]")).click();
		driver.switchTo().alert().sendKeys("Apoorva");
		driver.switchTo().alert().accept();
		String prompttext = driver.findElement(By.id("prompt-demo")).getText();
		System.out.println(prompttext);
		System.out.println("-------------------------------------------------------------------");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class = 'btn btn-default btn-lg' and text() = \"Click me!\"]")).click();
		Thread.sleep(3000);
		Alert confirm = driver.switchTo().alert();
		confirm.getText();
		confirm.accept();
		String confirmtext = driver.findElement(By.id("confirm-demo")).getText();
		System.out.println(confirmtext);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class = 'btn btn-default btn-lg' and text() = \"Click me!\"]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		String confirmtext1 = driver.findElement(By.id("confirm-demo")).getText();
		System.out.println(confirmtext1);
		driver.close();

	}

}
