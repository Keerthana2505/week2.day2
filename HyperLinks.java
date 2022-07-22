package week2.day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinks {

	public static void main(String[] args) {
		
		        //Download and set the path
				WebDriverManager.chromedriver().setup();
				
				//Launch the ChromeBrowser
				ChromeDriver driver = new ChromeDriver();
				
				//Load the URL
				driver.get("http://leafground.com/pages/Link.html");
				
				//Maximize the window
				driver.manage().window().maximize();
				
				// Go to Home Page
				driver.findElement(By.linkText("Go to Home Page")).click();
				driver.get("http://leafground.com/pages/Link.html");
				
				//Find where am supposed to go without clicking me?
				System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Find where am supposed to go without clicking me?')]")).getAttribute("href"));
				
				//Verify am I broken?
				driver.findElement(By.linkText("Verify am I broken?")).click();

				if (driver.getTitle().contains("TestLeaf"))
				{
					System.out.println("The Link is not Broken");
				}
				else
				{
					System.out.println("Broken Link");
				}
				
				//Go to Home Page (Interact with same link name)
				driver.get("http://leafground.com/pages/Link.html");
				
				//How many links are available in this page?
				 System.out.println("Number of links on Page: " +driver.findElements(By.tagName("a")).size());

	}

}
