package week2.day2.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Call WDM for the browser driver
		WebDriverManager.chromedriver().setup();

		//1	Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		//Maximize the browser
		driver.manage().window().maximize();

		//Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//Click Login
		driver.findElement(By.className("decorativeSubmit")).click();

		//Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		//Click Find leads
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();

		//Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		//Enter phone number
		driver.findElement(By.xpath("(//input[@name='phoneCountryCode']/following::input)[2]")).sendKeys("1234567891");

		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();


		//Capture lead ID of First Resulting lead
		String lead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
		System.out.println(lead);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Click First Resulting lead
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();

		//Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		//Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		//Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(lead);
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		

		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		boolean record = driver.findElement(By.xpath("//div[@class= 'x-paging-info']")).isDisplayed();
		if(record == true) {
		System.out.println("Lead Deleted");
		}

		//Close the browser (Do not log out)
		//driver.close();
	}

}
