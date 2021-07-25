package expackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tooltip {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/tool-tips");
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonToolTopContainer")));
		Thread.sleep(1000);
		WebElement tooltipButton = driver.findElement(By.id("toolTipButton"));
		Actions act = new Actions(driver);
		act.moveToElement(tooltipButton).perform();
		Thread.sleep(1000);
		String tooltip = driver.findElement(By.xpath("//*[@class=\'tooltip-inner\']")).getText();
		System.out.println(tooltip);
		String Expected = "You hovered over the button";
		if(tooltip.equalsIgnoreCase(Expected)) {
			System.out.println("Pass: tooltip is displaying properly");
		}else {
			System.out.println("Fail: tooltip does not match");
		}
		Thread.sleep(2000);
		
		WebElement tooltipplaceholder= driver.findElement(By.id("toolTipTextField"));
		act.moveToElement(tooltipplaceholder).perform();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\'tooltip-inner\']")));
		String placeholder = driver.findElement(By.xpath("//*[@class=\'tooltip-inner\']")).getText();
		System.out.println(placeholder);
		String hoveredtext = "You hovered over the text field";
		if(placeholder.equalsIgnoreCase(hoveredtext)) {
			System.out.println("PASS: tool tip displayed");
		}else {
			System.out.println("FAIL: Tooltip did not display");
		}
		Thread.sleep(2000);
		WebElement contrary = driver.findElement(By.xpath("//*[text()=\"Contrary\"]"));
		act.moveToElement(contrary).perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\'tooltip-inner\']")));
		String contrarytext = driver.findElement(By.xpath("//*[@class=\'tooltip-inner\']")).getText();
		System.out.println(contrarytext);
		String expectcontrary = "You hovered over the contrary";
		if(contrarytext.equalsIgnoreCase(expectcontrary)) {
			System.out.println("PASS: Contrary tooltip is displayed ");
		}else {
			System.out.println("FAIL:Tooltip did not display");
		}
		driver.close();
	}

}
