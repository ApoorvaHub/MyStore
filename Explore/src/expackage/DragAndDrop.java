package expackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DragAndDrop {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'entry-title']")));
		WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		System.out.println("Inside the frame");
		
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target);
	}

}
