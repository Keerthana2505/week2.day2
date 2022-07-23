package week2.day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {

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
		
		//Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Keerthana");
		
		//Click Find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Click on first resulting lead
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		
		
		//Verify title of the page
		String str = driver.getTitle();
		if(str.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Title Verified ");
		}
		else {
			System.out.println("Title not Found");
		}
		//Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//Change the company name
		String newComp="SRM Tech";
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newComp);
		
		//Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Confirm the changed name appears
		if (driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(newComp))
		{
			System.out.println("Company name updated as "+newComp);
		}
		else
		{
			System.out.println("Company name is not updated");
		}
		
		//Close the browser (Do not log out)
		driver.close();
	}

}
