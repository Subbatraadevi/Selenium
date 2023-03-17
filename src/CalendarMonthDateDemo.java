import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarMonthDateDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		String Month = "July";
		String Date = "04";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,800)");
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("form-field-travel_comp_date"))));
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[id='form-field-travel_comp_date']")).click();
		WebElement month = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']"));
		System.out.println(month.getText()); 
		
		while(!month.getText().contains(Month))
		{
			try
			{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			}
			
			catch(StaleElementReferenceException ex)
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			}
		}
		
		int count = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
			if(text.equalsIgnoreCase(Date))
			{
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				break;
			}
		}

	}

}
