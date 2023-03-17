import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();

		//System.out.println(driver.findElements(By.tagName("frame")).size());
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		
		//driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		
		System.out.println(driver.findElement(By.id("content")).getText()); 
		
		driver.switchTo().defaultContent();
		

	}

}
