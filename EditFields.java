package week2.day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		
		//Download and set the path
		WebDriverManager.chromedriver().setup();
		
		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://leafground.com/pages/Edit.html");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Enter your Email Address
		driver.findElement(By.id("email")).sendKeys("keerthana25@gmail.com");
	
		//Append a text and press keyboard tab
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(" text displays"+Keys.TAB);
		
		//Get default text entered
		System.out.println("Default Text: " +driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value"));
		
		//Clear the text
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		
		//Confirm that edit field is disabled
		System.out.println(driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled()); 
		
	}

}