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

public class OpenBrowser {
	
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://www.seleniumeasy.com/test/");
			System.out.println("Opening the test page");
			
			WebDriverWait wait = new WebDriverWait(driver,100);
			WebElement NotAgree = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,\"at-cv-lightbox-button\")]/a[2]")));
			NotAgree.click();
						
			WebElement start = driver.findElement(By.id("btn_basic_example"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", start);
			start.click();
			
			WebElement simpleForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basic\"]//a[text() = \"Simple Form Demo\"]")));
			simpleForm.click();
			System.out.println("start with Simple forms");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"easycont\"]//div[text() = \"Single Input Field\"]")));
			
			String eText = "I will succeed, if not immediately but definitely";
			driver.findElement(By.xpath("//*[@id=\"user-message\" and @class= 'form-control']")).sendKeys(eText);
			js.executeScript("window.scrollBy(0,500)");
			
			driver.findElement(By.xpath("//button[text()=\"Show Message\"]")).click();
			String aText = driver.findElement(By.id("display")).getText();
			System.out.println("Your message is: "+  aText);
			if(eText.equals(aText)) {
				System.out.println("Matching !!");
			}else {
				System.out.println(" Not matching :(");
			}
			driver.findElement(By.id("sum1")).sendKeys("10");
			driver.findElement(By.id("sum2")).sendKeys("20");
			driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
			String Total = driver.findElement(By.id("displayvalue")).getText();
			System.out.println("Grand total is: " + Total);
	
			WebElement InputForms= driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]//a[contains(text(), \"Input Forms\")]"));
			
			js.executeScript("arguments[0].scrollIntoView();", InputForms);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			
			InputForms.click();
			driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]//a[text() = 'Checkbox Demo']")).click();
			
			//click on checkbox
			
			 WebElement checkbox = driver.findElement(By.id("isAgeSelected"));
			 if(checkbox.isDisplayed()){
				 checkbox.click();
			 }else {
				 System.out.print("Checkbox does not exists");
			 }
			 
			 if(checkbox.isSelected()) {
				 String actText = driver.findElement(By.id("txtAge")).getText();
				 System.out.println(actText);	 
			 }
			 
			 js.executeScript("window.scrollBy(0,500)");
			 
			 List<WebElement> AllOptions =  driver.findElements(By.xpath("//input[@type = 'checkbox' and  @class = 'cb1-element']"));
			 for(int i = 0; i< AllOptions.size();i++) {
				 AllOptions.get(i).click();
				 if(AllOptions.get(i).isSelected()) {
					 System.out.println("Checkbox "+i+" is selected");
				 }
			 }
			 String value = driver.findElement(By.id("check1")).getAttribute("value");
			 System.out.println("button name changed to: "+ value);
			 if (value.equals("Uncheck All")) {
				 System.out.println("All checkboxes are checked and button name changed");
			 }else{
				 System.out.println("Its a DEFECT !!!");
			 }
			 
			 driver.findElement(By.id("check1")).click();
			 String value1 = driver.findElement(By.id("check1")).getAttribute("value");
			 if (value1.equals("Uncheck All")) {
				 System.out.println("All checkboxes are checked and button name changed");
				 driver.findElement(By.id("check1")).click();
				 String value2 = driver.findElement(By.id("check1")).getAttribute("value");
				 if(value2.equals("Check All")) {
					 System.out.println("All checkboxes are unchecked and button name changed to 'Check ALL'");
				 }
			 } 
			 driver.close();

}
}
