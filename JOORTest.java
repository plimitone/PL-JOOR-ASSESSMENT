package com.joor.assessment;
//This may need to be commented out or modified if running on another machine


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


public class JOORTest {
	 
	public static void main(String[] args) throws InterruptedException {
				
		// Create a new instance of the Firefox driver
		WebDriver ffd = new FirefoxDriver();
		ffd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		///Launch the Online Store Website
		//String url = "http://www.store.demoqa.com";
		//driver.get("http://www.store.demoqa.com");
		//driver.get(url);
		
		//Launch the JOOR staging page
		String url = "https://staging.joordev.com/";
		ffd.get("https://staging.joordev.com/");
		ffd.get(url);
		
        // Print a Log In message to the screen
        System.out.println("Successfully opened the website staging.joordev.com");
        
		//Store the title name into the String variable
		String title = ffd.getTitle();
		
		//Store the title length into the int variable
		int titleLength = ffd.getTitle().length();
		
		//Print the title and length to the Console window
		System.out.println("The title of the page is, " + title);
		System.out.println("The length of the title is, " + titleLength);
		
		//Store the URL in String variable
		String actualUrl = ffd.getCurrentUrl();
		
		if (actualUrl.equals(url)){
			System.out.println("Verification is successful --- The correct URL was opened");
		}else{
			System.out.println("Verification has failed -- Incorrect URL has opened");
			//IN CASE OF FAILURE
			System.out.println("Actual URL is " + actualUrl);
			System.out.println("Expected URL is " + url);
		}
		
		//Store the page source into String variable
		String pageSource = ffd.getPageSource();
		
		//Store page source length into string
		int pageSourceLength = pageSource.length();
		
		//Print the length of the page source
		System.out.println("Total length of page source is " + pageSourceLength);
		//Wait for 5 Sec
		Thread.sleep(5);
		
		//Maximize the webpage
		ffd.manage().window().maximize();
		
		//Find the login button/sidenav item, need to use xpath...firefox said it was not accessible
		ffd.findElement(By.xpath("//div[2]/a"));
		System.out.println("Found the login button");
		
		//now click on it
		ffd.findElement(By.xpath("//div[2]/a")).click();
		System.out.println("Clicked on the login button");
		
		//Login area should be opened
		//Find the username and password fields
		ffd.findElement(By.xpath("//input"));
		System.out.println("Found the username text field");
		
		ffd.findElement(By.xpath("//input[2]"));		
		System.out.println("Found the password text field");
		
		//Find the Sign in button
		ffd.findElement(By.xpath("//input[4]"));
		System.out.println("Found the sign in button");
		
		//Login to the staging environment using the provided credentials (Username: qatest1.....Password: qatest1)
		ffd.findElement(By.xpath("//input")).sendKeys("qatest1");
		System.out.println("Entered username into text field");
		
		ffd.findElement(By.xpath("//input[2]")).sendKeys("qatest1");
		System.out.println("Entered password in to text field");
		
		//now sign in
		ffd.findElement(By.xpath("//input[4]")).click();
		System.out.println("Clicked on the sign in button");
		
		//on the orders page, click on the Messages item in the top nav bar
		//find it first
		ffd.findElement(By.xpath("//li[4]/div/a/span"));
		System.out.println("Found messages on the nav bar");
		
		//then click on messages in the nav bar
		ffd.findElement(By.xpath("//li[4]/div/a/span")).click();
		System.out.println("Clicked on messages in nav bar");

		//then click on Send a message
		ffd.findElement(By.xpath("//li[4]/ul/li[2]/a")).click();
		System.out.println("Clicked on messages in the nav bar");
		
		//Compose a message should now be open
		//Check for send to all connections
		ffd.findElement(By.xpath("//span/div/input[2]"));
		System.out.println("Found send to all connections");
		
		//Check for Select Connections
		ffd.findElement(By.xpath("//input[3]"));
		System.out.println("Found select connections");
		
		//Check for the Recipients field
		ffd.findElement(By.xpath("//div[2]/div[2]/input"));
		System.out.println("Found recipients field");

		//Check for the Subject Field
		ffd.findElement(By.xpath("//div[3]/input"));
		System.out.println("Found subject field");

		//Check for the message body field
		ffd.findElement(By.xpath("//textarea"));
		System.out.println("Found message body area");

		//Find the Send Button
		ffd.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/a"));
		System.out.println("Found the send button");
		
		//System.out.println("For now...we're done");
        // Close the driver
        //driver.close();
		//ffd.close();

	
	//Verify error message appears when sending empty message
	//compose window should already be open
	//find the send button and then click it
	ffd.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/a")).click();
	System.out.println("Verify error message appears when sending empty message....clicked send button");
	
	//then when the alert appears, get rid of it
	ffd.switchTo().alert().accept();
	System.out.println("Verify error message appears when sending empty message....Dismissed the alert");
	
	
	//compose window should still be open
	//Verify error message appears when sending message to all connections (no subject, no message, no attachment)
	//find send to all connections and click it
	ffd.findElement(By.xpath("//span/div/input[2]")).click();
	System.out.println("Verify error message appears when sending message to all connections (no subject, no message, no attachment..clicked send to all connections");
	
	//then find and click send
	ffd.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/a")).click();
	System.out.println("Found the send button and clicked it");
	
	//when the alert appears, get rid of it
	ffd.switchTo().alert().accept();
	System.out.println("Verify error message appears when sending message to all connections (no subject, no message, no attachment...dismissed the alert");
	
	//compose window should still be open
	//Verify error message appears when sending message to select connections (No subject, no message, no attachment)
	//Find select connections and click it
	ffd.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/span/div/label[2]")).click();
	System.out.println("Found and clicked on select connections");
	
	//click the send button
	ffd.findElement(By.xpath("//form[@id='MessageSendForm']/a")).click();
	System.out.println("No subject, no message, no attachment...Found and clicked on send button");
	
	//when the alert appears, get rid of it
	ffd.switchTo().alert().accept();
	System.out.println("Verify error message appears when sending message to select connections (No subject, no message, no attachment...dismissed the alert");
	
	//Verify send message not successful (Send all connections, No Recipients, Subject populated, message body populated, no attachment)
	//Find select all connections and click it
	ffd.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/span/div/label[2]")).click();
	System.out.println("Found and clicked on select connections");
	
	//Populate the subject area with text
	ffd.findElement(By.xpath("//div[3]/input")).sendKeys("Sample subject...Sample subject");
	System.out.println("Found subject field and populated it");
	
	//Populate the message body
	ffd.findElement(By.xpath("//textarea")).sendKeys("This is some sample message body text for testing purposes");
	System.out.println("Found message body area and populated it");
	
	//Then send the message
	ffd.findElement(By.xpath("//form[@id='MessageSendForm']/a")).click();
	System.out.println("Verify send message not successful (Send all connections, No Recipients, Subject populated, message body populated, no attachment...Found and clicked on send button");
	
	//when the alert appears, get rid of it...Send all connections, No Recipients, Subject populated, message body populated, no attachment
	ffd.switchTo().alert().accept();
	System.out.println("Dismissed the alert");
	
	//Verify send message successful (Send to all connections, populate subject, populate message, no attachment
	//Find send to all connections and click on it
	ffd.findElement(By.xpath("//span/div/input[2]")).click();
	System.out.println("Send message successful...all connections, populate subject, popuplate message,  no attachment...Found and clicked send to all connections");
	
	//Populate the subject
	ffd.findElement(By.xpath("//div[3]/input")).sendKeys("send message successful (Send to all connections, populate subject, populate message, no attachment");
	System.out.println("send message successful (Send to all connections, populate subject, populate message, no attachment.....Found subject field and populated it");
	
	//Populate message body
	ffd.findElement(By.xpath("//textarea")).sendKeys("send message successful (Send to all connections, populate subject, populate message, no attachment");
	System.out.println("send message successful (Send to all connections, populate subject, populate message, no attachment...Found message body area and populated it");
	
	//Send the message
	ffd.findElement(By.xpath("//form[@id='MessageSendForm']/a")).click();
	System.out.println("Send to all connections, populate subject, populate message, no attachment...send the message");
	
	System.out.println("");
	System.out.println("");
	System.out.println("DONE FOR NOW");
	//Verify send message successful (Select connection, Subject populated, message body populated, no attachment
	
	
	//Verify send message successful (Add multiple recipients, Subject populated, Add message body, select attachment)
	
	//Verify error message appears when sending message with invalid attachment type
	
	//Verify error message appears when sending message with LARGE Valid attachment type
	
	//Verify error message appears when sending message with large and invalid type
	
	}
}