import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		String userName = "rahulshettyacademy";
		String password = "learning";
		String[] itemsToAdd = { "iphone", "Samsung" };

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);

		 driver.findElement(By.cssSelector("input[value='user']")).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		 driver.findElement(By.id("okayBtn")).click();
		// Thread.sleep(2000);
		// System.out.println(driver.switchTo().alert().getText());
		// driver.switchTo().alert().accept();

		WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select options = new Select(dropdown);
		options.selectByValue("consult");

		driver.findElement(By.cssSelector("input[id='terms']")).click();

		driver.findElement(By.id("signInBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-link.btn.btn-primary")));

		addItems(driver, itemsToAdd);
		
		driver.findElement(By.partialLinkText("Checkout")).click();

	}

	public static void addItems(WebDriver driver, String[] itemsToAdd) {

		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

		for (int i = 0; i < products.size(); i++) {
			int j = 0;
			String[] itemsFormatted = products.get(i).getText().split(" ");
			String itemName = itemsFormatted[0].trim();

			List<String> itemsAdded = Arrays.asList(itemsToAdd);

			if (itemsAdded.contains(itemName)) {
				j++;
				driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();

			}

			if (j == itemsToAdd.length) {
				break;
			}

		}
	}

}
