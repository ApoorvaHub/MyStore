package expackage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdown {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Explore\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,\"at-cv-lightbox-button\")]/a[2]"))).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("btn_basic_example")));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]//a[text() = \"Input Forms\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Select Dropdown List"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"easycont\"]//div[text() = \"Select List Demo\"]")));
		
		WebElement pleaseSelect = driver.findElement(By.id("select-demo"));
		Select select = new Select(pleaseSelect);
		select.selectByVisibleText("Monday");
			String DaySelected1 = driver.findElement(By.className("selected-value")).getText();
			System.out.println(DaySelected1);
		
		select.selectByIndex(1);
		String DaySelected2 = driver.findElement(By.className("selected-value")).getText();
		System.out.println(DaySelected2);
		
		select.selectByValue("Friday");
		String DaySelected3 = driver.findElement(By.className("selected-value")).getText();
		System.out.println(DaySelected3);
		
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement multi = driver.findElement(By.id("multi-select"));
		Select mselect = new Select(multi);
		Boolean flag = mselect.isMultiple();
		System.out.println("It is a multi select Drop-down "+ flag);
		
		List<WebElement> AllOptions = mselect.getOptions();
		for(WebElement option : AllOptions) {
			System.out.println(option.getText());
		}
		
		mselect.selectByIndex(2);
		//mselect.selectByIndex(4);
		
		String fselected = mselect.getFirstSelectedOption().getText();
		System.out.println("First Selected Option is: " +fselected);
		
		System.out.println("------------------All selected options are ------------------");
		List<WebElement> selectedOptions = mselect.getAllSelectedOptions();
		for(WebElement selected: selectedOptions) {
			System.out.println(selected.getText());
		}
		driver.findElement(By.id("printMe")).click();
		String display = driver.findElement(By.xpath(".//*[@class = 'getall-selected']")).getText();
		System.out.println(display);
		System.out.println("---------- Display First Selected Option using buttons in UI ------------");
		
		String [] parts = display.split(":");
			System.out.println(parts[1]);
			if(parts[1].contains(fselected)) {
				System.out.println("First selected option is displayed");
			}else {
				System.out.println("Its a DEFECT !!! as its displaying other than first selcted option!!");
			}
			mselect.deselectAll();
			mselect.selectByIndex(3);
			mselect.selectByIndex(5);
			mselect.selectByIndex(1);
			List<WebElement> selectall = mselect.getAllSelectedOptions();
			System.out.println("---------------All selected options are------------------");
			for (WebElement all : selectall) {
				System.out.println(all.getText());
			}
			driver.findElement(By.id("printAll")).click();
			String displayall = driver.findElement(By.xpath(".//*[@class = 'getall-selected']")).getText();
			System.out.println("------------displayed text is : -----------------");
			System.out.println(displayall);
			String[] slipts = displayall.split(":");
			System.out.println(slipts[1]);
			
			driver.close();
			}

}
