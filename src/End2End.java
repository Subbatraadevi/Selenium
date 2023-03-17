import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class End2End {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();

		driver.findElement(By.cssSelector("a[value='DEL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

		driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
		Thread.sleep(3000);

		for (int i = 1; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		WebElement dropdownlist = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select options = new Select(dropdownlist);

		options.selectByValue("USD");

		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

	}

}
