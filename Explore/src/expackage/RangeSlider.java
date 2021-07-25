package expackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RangeSlider {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='col-md-6 text-left']/h2")));
		WebElement slider = driver.findElement(By.xpath("//*[@id=\'slider1\']/div/input"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, 30, 0).perform();
		String slide = driver.findElement(By.id("range")).getText();
		String color = driver.findElement(By.id("range")).getCssValue("color");
		System.out.println("slider slided to " +slide);
		System.out.println(color);
		driver.close();

	}

}
