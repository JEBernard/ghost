

import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.HttpCommandProcessor;
import com.thoughtworks.selenium.Selenium;

/**
*
* @author jbernard
*/

public class adminloginTest {
	
@BeforeTest 



  @Test
  	public static void AdminLogin(ITestContext context) {
  
			String seleniumHost = context.getCurrentXmlTest().getParameter("selenium.host"); 
			String seleniumPort = context.getCurrentXmlTest().getParameter("selenium.port"); 
			String seleniumBrowser = context.getCurrentXmlTest().getParameter("selenium.browser"); 
			String seleniumUrl = context.getCurrentXmlTest().getParameter("selenium.url"); 
			
			RemoteControlConfiguration rcc = new RemoteControlConfiguration(); 
			rcc.setSingleWindow(true); 
			try {
				SeleniumServer server = new SeleniumServer(false, rcc); 
				server.boot(); 
			} catch (Exception e){
				throw new IllegalStateException("Can't start selenium server", e);
				}
				
	    HttpCommandProcessor proc = new HttpCommandProcessor(seleniumHost, Integer.parseInt(seleniumPort), seleniumBrowser, seleniumUrl);
	    DefaultSelenium selenium = new DefaultSelenium(proc); 

	    selenium.start(); 
	    selenium.windowMaximize(); 
	    selenium.open(seleniumUrl);
	    selenium.click("link=Login"); 
	    selenium.waitForPageToLoad("30000");
	    selenium.click("id=username");
	    selenium.click("id=password"); 
	    selenium.click("id=loginbtn");
	    selenium.waitForPageToLoad("30000"); 
	    
			}
	  
 }
