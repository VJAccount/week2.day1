package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		String attribute = driver.findElement(By.className("decorativeSubmit")).getAttribute("value");
		System.out.println(attribute);
		if(attribute.equals("Logout")) {
			System.out.println("Successfully logged in");
		}
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("abc.org");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sai");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Prasad");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Hari");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Marketing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is a new lead creation");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@xyz.com");
		
		WebElement stateDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selectState = new Select(stateDropdown);
		selectState.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("View Lead")) {
			System.out.println("Lead creation successful");
		}
		else
			System.out.println("Lead creation NOT successful");
		
		//Thread.sleep(3000);
		driver.quit();
	}

}
