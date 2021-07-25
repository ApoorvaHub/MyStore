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

public class radioButton {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,\"at-cv-lightbox-button\")]/a[2]"))).click();
		System.out.println("Pop-up handled");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("btn_basic_example")));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]//a[text() = \"Input Forms\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"treemenu\"]//a[text() = \"Radio Buttons Demo\"]")));
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]//a[text() = \"Radio Buttons Demo\"]")).click();
		
		boolean flag = js.executeScript("return document.readyState").toString().equals("complete");
		System.out.println(flag);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"easycont\"]//div[text() = \"Radio Button Demo\"]"))));
		System.out.println("Radio button demo page is displayed");
		
		WebElement Radio1 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input"));
		String Selected = Radio1.getAttribute("value");
		Radio1.click();
		if (Radio1.isSelected()) {
			driver.findElement(By.id("buttoncheck")).click();
			System.out.println("Radio button "+ Selected+" is selected");
			WebElement checktext = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]"));
			if(checktext.isDisplayed()){
				String text = checktext.getText();
				System.out.println("Radio button is checked and the text is: " + text);
			}else {
				System.out.print("text is not displayed");
			}
		}else {
		System.out.println("Radio button "+Selected+ " is not selected");
		}
		
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath(".//h4[contains(text(), \"Sex\")]/following-sibling::label[2]")).click();
		driver.findElement(By.xpath(".//h4[contains(text(), \"Age Group\")]/following-sibling::label[3]")).click();
		driver.findElement(By.xpath(".//button[text() = \"Get values\"]")).click();
		List<WebElement> radios = driver.findElements(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]//*[@type= 'radio']"));
		int rcount = radios.size();
		System.out.println("number of group radio button: "+rcount);
		for( int i =0; i < rcount; i++ ) {
			if(radios.get(i).isSelected()) {
				System.out.println("Selected button: " + radios.get(i).getAttribute("value"));
			}
		}
		String resulttext = driver.findElement(By.className("groupradiobutton")).getText();
		System.out.println(resulttext);
		
		driver.close();
	}

}
