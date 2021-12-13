package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Base {
	
	public static WebDriver driver; 
	public static Properties properties; 
	public static Logger logger; 
	private String propertyPath =".\\src\\test\\resource\\input\\property.properties";
	private String log4jPath = ".\\src\\test\\resource\\input\\log4j.properties";
	
	/*create a constructor to initialize the variable values from properties file*/
	public Base() {
	
		try {
			//we creare bufferedReader class object to read values of properties file by byte,char, or line of value 
			BufferedReader reader = new BufferedReader (new FileReader(propertyPath));
			properties = new Properties();//object of properties class
			properties.load(reader);// using .load method of properties to load the properties file
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger = Logger.getLogger("logger_File");
		PropertyConfigurator.configure(log4jPath);
	}
	
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url;
		
	}
	
	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}

	public static void openBrowser() {
		driver.get(getUrl());
	}
	
	public static void tearDown() {
	//	driver.close();
	//	driver.quit();
	}
	//this method will run cross browsers, we can change value of the browser in properties file and it will run test cases on specified browser
    public	static void browser() {
    	String browserName = getBrowser();
    	switch(browserName) {
    	case "chrome":
    		WebDriverManager.chromedriver().setup();
    		driver =new ChromeDriver();
    		break;
    	case "ff":
    		WebDriverManager.firefoxdriver().setup();
    		driver= new FirefoxDriver();
    		break;
    	case"edge":
    		WebDriverManager.edgedriver().setup();
    		driver=new EdgeDriver();
    		break;
    	default:
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	//driver.manage().deleteAllCookies();
    	
    }
}
