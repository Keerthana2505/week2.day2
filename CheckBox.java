package week2.day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		 //Download and set the path
		WebDriverManager.chromedriver().setup();
		
		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://leafground.com/pages/checkbox.html");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Select the languages that you know?
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		
		
		//Confirm Selenium is checked
		boolean checked = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::input")).isSelected();

		if(checked)
		{
			System.out.println("Selenium Checkbox Enabled");
		}
		else
		{
			System.out.println("Selenium Checkbox Disabled");
		}
		
		//DeSelect only checked
		Boolean checkd = driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).isSelected();
		
		if (checkd.equals(true)) {
			driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();
		}
		
		//Select all below checkboxes
		for (int i=1; i<=6; i++)
		{
			driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input["+i+"]")).click();
			
		}
	}

}
