package stepdefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import or.OR_Cartpage;
import pages.Cartpage;
import pages.Homepage;
import testrunner.WebBase;

public class Ecommercestepdef extends WebBase {


	public static List<Double> list = new ArrayList();
	public static Double min;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Homepage home = new Homepage(driver);


	@After
	public void afterScenario(Scenario sceanrio) {

		final byte[] screenshots =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sceanrio.attach(screenshots, "image/png", "test");

	}

	//**** BackGorund starts here

	@Given("the user launches the site")
	public void the_user_launches_the_site() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options =new ChromeOptions();
		Options.addArguments("start-maximized");
		driver= new ChromeDriver(Options);
		driver.get("https://cms.demo.katalon.com");
	}

	//**** BackGorund Ends here


	//**** Scenarios : Removing the lowest price item from cart Starts here
	@Given("I add four random items to my cart")
	public void i_add_four_random_items_to_my_cart() {
		Homepage home = new Homepage(driver);
		home.selectAddtoCartinHomepage();
	}
	@When("I view my cart")
	public void i_view_my_cart() {
		Homepage home = new Homepage(driver);
		home.clickCart();

	}
	@Then("I find total four items listed in my cart")
	public void i_find_total_four_items_listed_in_my_cart() {
		Cartpage cart=new Cartpage(driver);
		list=cart.Addingcartitemsinlist();
	}
	@When("I search for the lowest price item")
	public void i_search_for_the_lowest_price_item() {
		min = Collections.min(list);
		System.out.println("Lowset Price Item is: "+min);
	}
	@When("I am able to remove the lowest price item from my cart")
	public void i_am_able_to_remove_the_lowest_price_item_from_my_cart() {
		Cartpage cart=new Cartpage(driver);
		cart.removecartitem(min);
	}
	@Then("I am able to verify the three items in my cart")
	public void i_am_able_to_verify_the_three_items_in_my_cart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR_Cartpage.afterRmvPriceItem)));
		WebElement Table_1 = driver.findElement(By.xpath(OR_Cartpage.table));
		List Rows = Table_1.findElements(By.tagName(OR_Cartpage.rows));
		for(int j=1;j<Rows.size();j++) {
			    String locpric=OR_Cartpage.priceItem.replace("tr[1]","tr["+j+"]");
				String verify=driver.findElement(By.xpath(OR_Cartpage.priceItem)).getText();

				Assert.assertFalse("Lowest Item has not been deleted ",((Double.valueOf(verify.substring(1))).toString()).equalsIgnoreCase(min.toString()));
				break;
	
		}

	}

	//**** Scenarios : Removing the lowest price item from cart ends here

}
