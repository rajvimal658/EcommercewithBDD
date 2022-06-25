package testrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebBase {
	public static WebDriver driver;
	public static  WebDriver thelaunches_the_site() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options =new ChromeOptions();
		Options.addArguments("start-maximized");
		driver= new ChromeDriver(Options);
		return driver;
		
	}

}
