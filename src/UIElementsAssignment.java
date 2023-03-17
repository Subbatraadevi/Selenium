import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UIElementsAssignment {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Subbatraadevi");
		driver.findElement(By.name("email")).sendKeys("subha@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("DhivishaMahanth");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select options = new Select(dropdown);
		
		options.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio2")).click();
		
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("01/25/1988");
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("btn-success")).click();
		
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
	}
}
