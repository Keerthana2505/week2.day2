package week2.day2.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		 //Download and set the path
		WebDriverManager.chromedriver().setup();
		
		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Select training program using Index
		Select program = new Select(driver.findElement(By.id("dropdown1")));
		program.selectByIndex(1);

		//Select training program using Text
		Select UsingText = new Select(driver.findElement(By.name("dropdown2")));
		UsingText.selectByVisibleText("Selenium");
		
		//Select training program using Value
		Select UsingValue = new Select(driver.findElement(By.id("dropdown3")));
		UsingValue.selectByValue("1");
		
		//Get the number of dropdown options
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select options = new Select(dropdown);
		int size = options.getOptions().size();
		System.out.println("No of options in Dropdown: "+size);
		
		//sendKeys to select
		driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/..")).sendKeys("Selenium");
		
		driver.findElement(By.xpath("//div[@class='example'][5]")).click();
		driver.findElement(By.xpath("//div[@id='contentblock']/section/div[5]/select")).sendKeys("Appium",Keys.ENTER);
		 
		//select your Programs
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select/option[2]")).click();
	}

}
