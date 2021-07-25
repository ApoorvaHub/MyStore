package expackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxForm {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,\"at-cv-lightbox-button\")]/a[2]"))).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("btn_basic_example")));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]//a[text() = \"Input Forms\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ajax Form Submit"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Ajax Form\"]")));
		driver.findElement(By.id("title")).sendKeys("Apoorva");
		driver.findElement(By.id("description")).sendKeys("This page is regarding Ajax for submit with loading icon");

		driver.findElement(By.id("btn-submit")).click();
		List<WebElement> loadingicon = driver.findElements(By.xpath("//*[@id=\"submit-control\"]/img"));
		int count = 0;
		while(loadingicon.size()!=0 && count <3) {
			Thread.sleep(1000);
			count ++;
		}
		String sucess = driver.findElement(By.id("submit-control")).getText();
		System.out.println(sucess);
		driver.close();
	}

}
