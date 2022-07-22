package week2.day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Images {

	public static void main(String[] args) {
		
		 //Download and set the path
		WebDriverManager.chromedriver().setup();
		
		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://leafground.com/pages/Image.html");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Click on image to go home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.navigate().back();
		
		//Am I Broken Image?
		boolean img = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).isSelected();
		
		if(img != true) {
			System.out.println("Broken Image");
		}
		else {
			System.out.println("Image is not Broken");
		}
		
		//Click me using Keyboard or Mouse
		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img")).click();

	}
	

}
