package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataPropertyFile {
	@Test
	public void readDataFromPropertyFile() throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/CommonData.properties");
		
	  Properties pobj = new Properties();
	  pobj.load(fis);
	  
	  String URL=pobj.getProperty("url");
	  String BROWSER=pobj.getProperty("browser");
	  String US=pobj.getProperty("username");
	  String PASSWORD=pobj.getProperty("password");
	  System.out.println(URL);
	  System.out.println(BROWSER);
	  System.out.println(US);
	  System.out.println(PASSWORD);
		
	}
	

}
