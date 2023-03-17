import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("checkBoxOption2")).click();

		String selectedOption = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");

		Select options = new Select(driver.findElement(By.id("dropdown-class-example")));
		options.selectByValue(selectedOption);

		driver.findElement(By.id("name")).sendKeys(selectedOption);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		if(alertText.contains(selectedOption))
		{
		System.out.println("Alert message is successful");
		}
		else
		{
			System.out.println("Message is not correct");
		}

	}

}
