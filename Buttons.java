package week2.day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {

	public static void main(String[] args) {
		
		//Download and set the path
		WebDriverManager.chromedriver().setup();
		
		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://leafground.com/pages/Button.html");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Click button to travel home page
		driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.findElement(By.xpath("//h5[text()='Button']")).click();
		
		// Find position of button (x,y)

		System.out.println("X Position: " +driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation().getX());
		System.out.println("Y Position: " +driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation().getY());
		
		
		//Find button color
		System.out.println("Button Color: " +driver.findElement(By.xpath("//button[text()='What color am I?']")).getCssValue("background-color"));
		
		//Find the height and width
		System.out.println("Height: " +driver.findElement(By.xpath("//button[@id='size']")).getSize().getHeight());
		System.out.println("Width: " +driver.findElement(By.xpath("//button[@id='size']")).getSize().getWidth());
	
	}

}
