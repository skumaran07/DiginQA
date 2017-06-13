package com.test.Automation.sel.Digin.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.Automation.sel.Digin.excelReader.Excel_Reader;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String browser = "chrome";
	String url = "https://70.35.206.154/";
	Excel_Reader excel;
	public void init(){
		selectBrowser(browser);
		getUrl(url);
		String log4jpath = "log4j.properties";
		PropertyConfigurator.configure(log4jpath);
		
	}
		
public void selectBrowser(String browser){	
	if(browser == "chrome")
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\Drivers\\chromedriver.exe");
		log.info("Create a browser" +browser);
		driver = new ChromeDriver();
	}
	else if (browser =="firefox"){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\Drivers\\geckodriver.exe");
		log.info("Create a browser" +browser);
		driver = new ChromeDriver();
	}
}

public void getUrl(String url){
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}
 public String[][] getData(String sheetName, String excelName){
	 //C:\Users\WMS\workspace\Digin\src\main\java\com\test\Automation\sel\Digin\excelReader\Excel_Reader.java
	 
	 String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\Automation\\sel\\Digin\\excelReader\\"+excelName;
	 excel = new Excel_Reader(path);
	 String[][] data = excel.getDataFromExcel(sheetName, excelName);
	 return data;
 }
}
