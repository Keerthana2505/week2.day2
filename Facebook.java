package week2.day2Assignment;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {

		//Download and set the path
		WebDriverManager.chromedriver().setup();

		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("https://en-gb.facebook.com/");

		//Maximize the window
		driver.manage().window().maximize();

		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click on Create New Account button
		driver.findElement(By.xpath("//a[contains(text(),\"Create New Account\")]")).click();

		//Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Keerthana");			

		//Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("J");			

		//Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("keerthana25@gmail.com");

		//Enter the password
		driver.findElement(By.id("password_step_input")).sendKeys("Testleaf.25");

		//Handle all the three drop downs
		Select date = new Select(driver.findElement(By.id("day")));

		date.selectByIndex(24);

		Select month = new Select(driver.findElement(By.id("month")));

		month.selectByValue("5");

		Select year = new Select(driver.findElement(By.id("year")));

		year.selectByVisibleText("2000");

		//Select the radio button "Female" ( A normal click will do for this step) 
		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
