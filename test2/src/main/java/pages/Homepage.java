package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import or.OR_Homepage;

public class Homepage {
	
	
		WebDriver driver;
		
		//Constructor that will be automatically called as soon as the object of the class is created
		public Homepage(WebDriver driver) {
			this.driver=driver;
		}
		
		
	
		
		//Method to click on cartin each item button 
		public void selectAddtoCartinHomepage() {
			for(int i=1;i<5;i++) {
				String viewcart=OR_Homepage.viecart.replace("li[1]","li["+i+"]" );
				driver.findElement(By.xpath(viewcart)).click();
			}
		}
		
		public void clickCart() {
			driver.findElement(By.xpath(OR_Homepage.cartbtn)).click();
			driver.navigate().refresh();
			
		}

}
