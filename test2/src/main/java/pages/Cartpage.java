package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import or.OR_Cartpage;

public class Cartpage {
	WebDriver driver;
	public static Double min;
	public static List<Double> list = new ArrayList();
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public Cartpage(WebDriver driver) {
		this.driver=driver;
	}
	

	
	//Method to click on cartin each item button
	public List<Double> Addingcartitemsinlist() {
		WebElement Table_1 = driver.findElement(By.xpath(OR_Cartpage.table));
		List Rows = Table_1.findElements(By.tagName(OR_Cartpage.rows));
		System.out.println("No. of rows: "+Rows.size());
		for(int j=1;j<Rows.size();j++) {
			String locpric=OR_Cartpage.priceItem.replace("tr[1]","tr["+j+"]");
			String test=driver.findElement(By.xpath(locpric)).getText();
			System.out.println(test);
			
			list.add(Double.valueOf(test.substring(1)));
		}
		 return list;

	}
	
	public void removecartitem(Double min) {
		WebElement Table_1 = driver.findElement(By.xpath(OR_Cartpage.table));
		List Rows = Table_1.findElements(By.tagName(OR_Cartpage.rows));
		for(int j=1;j<Rows.size();j++) {
			String locpric=OR_Cartpage.priceItem.replace("tr[1]","tr["+j+"]");
			String test=driver.findElement(By.xpath(locpric)).getText();
			System.out.println(test);
			System.out.println(Double.valueOf(test.substring(1)));
			System.out.println(min);
			if (Double.compare(Double.valueOf(test.substring(1)), min)==0) {
				String locremove= OR_Cartpage.removePriceItem.replace("tr[1]","tr["+j+"]");
				driver.findElement(By.xpath(locremove)).click();
				break;
			}
		}
	}
	
	

	
	
}
