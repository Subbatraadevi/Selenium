import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// implicit wait
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// explicit wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		String[] itemsToAdd = { "Brocolli", "Carrot", "Potato", "Raspberry", "Cashews" };

		addItems(driver, itemsToAdd);

		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

		driver.findElement(By.xpath("//div[@class='cart-preview active']/div/button")).click();
		// driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/cart");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		// Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		// driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/country");

		WebElement countryList = driver.findElement(By.cssSelector("div[class='wrapperTwo'] div select"));

		countryList.click();

		Select options = new Select(countryList);

		String country = "India";

		options.selectByVisibleText(country);

		driver.findElement(By.className("chkAgree")).click();

		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

	}

	public static void addItems(WebDriver driver, String[] itemsToAdd) {
		int j = 0;

		List<WebElement> productList = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < productList.size(); i++) {
			// driver.findElement(null);
			String[] veggieNameToFormat = productList.get(i).getText().split("-");
			String veggieName = veggieNameToFormat[0].trim();

			List<String> veggiesList = Arrays.asList(itemsToAdd);

			if (veggiesList.contains(veggieName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}

			if (j == itemsToAdd.length) {
				break;
			}

		}
	}

}
