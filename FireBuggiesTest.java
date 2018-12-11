package com.FireBuggies.test;



import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.FireBuggies.pages.FirePages;





public class FireBuggiesTest {
	
	WebDriver driver;
	
	@BeforeClass
	public  void ChromeStart()
	{
		System.setProperty("webdriver.chrome.driver","D:/Users/ADM-IG-HWDLAB1B/Desktop/chrome/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.goibibo.com/flights/");
	}
	
	/*public  void FirefoxStart()
	{
		driver= new FirefoxDriver();
		driver.get("https://www.goibibo.com/");
	}*/
	
	
	@Test
	  public void testMethod() throws Exception
	  {
	   
		FirePages firepages = PageFactory.initElements(driver, FirePages.class);

	    /*----------------Read Data From XML File------------------------------------------*/ 
		
		
		 File src1= new File("./Config/pro.property");
		  FileInputStream fis1 = new FileInputStream(src1);
		  //to read the property file create an object of properties class
		  Properties pro= new Properties();
		  // to load property file 
		  pro.load(fis1);
		
		  firepages.Click(firepages.getXmlValue(pro.getProperty("roundPath")));
		
		  firepages.SendValues(firepages.getXmlValue(pro.getProperty("fromData")),firepages.getXmlValue(pro.getProperty("fromPath")));
	    
		  firepages.SendValues(firepages.getXmlValue(pro.getProperty("toData")),firepages.getXmlValue( pro.getProperty("toPath")));
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("openCalanderPath")));
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("dateSelectorPath")));
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("returnDatePath")));
		  firepages.Click(firepages.getXmlValue(pro.getProperty("returnDateSelectionPath")));
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("travellerXpath")));
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("adultXPath")));
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("childXPath")));
	   
		  firepages.DropDown(firepages.getXmlValue(pro.getProperty("Class")), "B");
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("PriceChange")));
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("GetSetGo")));
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("TicketBook")));
	     
     }
	
	@AfterClass
	public void Last() throws InterruptedException
	{
		Thread.sleep(4000);
		//driver.close();
	}
	
}
