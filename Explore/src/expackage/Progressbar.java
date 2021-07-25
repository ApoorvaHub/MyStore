package expackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Progressbar {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/bootstrap-progress-bar-dialog-demo.html");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text() = \"Modal dialog with progress bar\"]")));
		driver.findElement(By.xpath(".//h3[contains(text(),\"Simple dialog\")]/following-sibling::button[1]")).click();
		//WebElement loadingbar = driver.findElement(By.className("modal-content"));
		
//		int count = 0;
//		while(loadingicon.size()!=0 && count<5) {
//			count++;
//			Thread.sleep(2000);
//		}
//		if(count !=0) {
//		System.out.println("SimpleLoading bar is displayed and closed after 2 seconds " + count);
//		}else {
//			System.out.println("SimpleLoading bar does not displayed");
//		}
//		while(true) {
//		    try {
//		       if (loadingbar.isDisplayed())
//		          return;
//		    } catch (StaleElementReferenceException e) {
//		       return;
//		    }
//		   Thread.sleep(1000);
//		  }
		}
	}

