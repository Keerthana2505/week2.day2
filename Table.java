package week2.day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
		 //Download and set the path
		WebDriverManager.chromedriver().setup();
		
		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://leafground.com/pages/table.html");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Get the count of number of columns
		System.out.println("Number of Columns: " +driver.findElements(By.tagName("th")).size());
		
		//Get the count of number of rows
		System.out.println("Number of Rows: " +driver.findElements(By.tagName("tr")).size());
		
		//Get the progress value of 'Learn to interact with Elements'
		for (int j = 3; j<=5; j++)
		{
			String value = driver.findElement(By.xpath("//section[@class='innerblock']//tbody/tr["+j+"]/td[2]")).getText();
			System.out.println("Progress value of 'Learn to interact with Elements'["+j+"]-> "+value);
		}
		
		//Check the vital task for the least completed progress.
		driver.findElement(By.xpath("//font[text()[normalize-space()='Handle Exceptions']]/following::input[1]")).click();

	}

}
