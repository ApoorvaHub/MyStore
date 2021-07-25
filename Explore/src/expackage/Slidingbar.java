package expackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Slidingbar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/slider");
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='main-header']")));
		WebElement slider = driver.findElement(By.xpath("//*[@class='range-slider range-slider--primary']"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, 20, 0).perform();
		String slide = driver.findElement(By.id("sliderValue")).getAttribute("value");
		System.out.println("slider slided to " +slide);
		act.dragAndDropBy(slider, -60, 0).perform();
		String slide1 = driver.findElement(By.id("sliderValue")).getAttribute("value");
		System.out.println("slider slided to " +slide1);
		
	}

}
