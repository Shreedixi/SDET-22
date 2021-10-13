package testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.vitiger.GenericUtils.ExcelUtility;
import com.crm.vitiger.GenericUtils.FileUtility;
import com.crm.vitiger.GenericUtils.JavaUtility;
import com.crm.vitiger.GenericUtils.WebDriverUtility;

public class TC_01CreateOrganisation {
	static {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		FileUtility file=new FileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		ExcelUtility eutil=new ExcelUtility();
		String USERNAME = file.getPropertyKeyValue("username");
		String PASSWORD = file.getPropertyKeyValue("password");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Org')]")).click();
		 String oname = eutil.getExcelData("Sheet1", 1, 1);
		driver.findElement(By.name("accountname")).sendKeys(oname+JavaUtility.getRandomData()); //we can use same name then it will take random numbers
		WebElement dropdown = driver.findElement(By.name("assigned_user_id"));
		Select s=new Select(dropdown);
		s.selectByIndex(0);
		wutil.SelectOption(dropdown, 0);
		driver.findElement(By.name("button")).click();
		Actions act=new Actions(driver);
		//act.moveToElement(ele).perform();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		wutil.mouseOver(driver, ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(3000);
		driver.close();
		
	}
};