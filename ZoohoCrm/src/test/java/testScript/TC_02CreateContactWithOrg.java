package testScript;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_02CreateContactWithOrg {
	static {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("manager");
	    driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	    driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
	    WebElement ele = driver.findElement(By.name("salutationtype"));
	    Select s=new Select(ele);
	    s.selectByVisibleText("Mr.");
	    driver.findElement(By.name("firstname")).sendKeys("Varshil");
	    driver.findElement(By.name("lastname")).sendKeys("Gowda");
	    driver.findElement(By.xpath("//img[(@title='Select')]")).click();
	    Set<String> window = driver.getWindowHandles();
	    for(String b:window) {
			driver.switchTo().window(b);
	}
	    driver.findElement(By.xpath("//a[text()='NaguDixith']")).click();
	    WebElement d = driver.findElement(By.name("assigned_user_id"));
	    Select drop=new Select(d);
		drop.selectByVisibleText(" Administrator");
		//driver.findElement(By.name("button")).click();
		//Actions act=new Actions(driver);
		//WebElement sout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		//act.click(sout);
		//Thread.sleep(3000);
		//driver.close();
	    
	}
	
	

}
