package com.FireBuggies.test;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.FireBuggies.pages.FirePages;
public class FireBuggiesTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void Start()
	{
		System.out.println("Please enter your desired browser name:");
		System.out.println("Enter your choice(Chrome/IE/Firefox):");
		Scanner s=new Scanner(System.in);
		String choice = s.nextLine();
		if(choice.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:/Users/ADM-IG-HWDLAB1B/Desktop/chromedriver.exe");
      	    driver= new ChromeDriver();
		    driver.get("https://www.goibibo.com/flights/");	
		}
		else if(choice.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","D:/Users/ADM-IG-HWDLAB1B/Desktop/IEDriverServer.exe");
	       // InternetExplorerDriver IEDriver=new InternetExplorerDriver();
	        driver = new InternetExplorerDriver();
	        driver.get("https://www.goibibo.com/flights/");
	        
		}
		else if(choice.equals("Firefox"))
		{
			driver= new FirefoxDriver();
			driver.get("https://www.goibibo.com/");
		}
		else
		{
			System.out.println("Please enter a valid data!!!!!");
		}
		    
}
	
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
	   
		  firepages.Click(firepages.getXmlValue(pro.getProperty("openCalenderPath")));
	   
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
