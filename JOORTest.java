package com.joor.assessment;
//This may need to be commented out or modified if running on another machine


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;


public class JOORTest {
	 
	public static void main(String[] args) throws InterruptedException {
				
		// Create a new instance of the Firefox driver
		WebDriver ffd = new FirefoxDriver();
		ffd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
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
		System.out.println("Waiting for things to clear up......");
		Thread.sleep(5000);
		
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
	
	//Wait for the messages to clear up
	System.out.println("Waiting for things to clear up......");
	Thread.sleep(5000);
	
	//Verify send message successful (Select connection, Subject populated, message body populated, no attachment
	//Find and select Compose mail
	ffd.findElement(By.xpath("//a[contains(text(),'Compose Mail')]")).click();
	System.out.println("Verify send message successful (Select connection, Subject populated, message body populated, no attachment...clicked Compose mail");
	
	//This opens the message window
	//click select connections
	ffd.findElement(By.xpath("//input[3]")).click();
	System.out.println("Click select connections");
	
	//Enter recipients into field
	ffd.findElement(By.xpath("//div[2]/div[2]/input")).sendKeys("JOOR");
	System.out.println("Entered JOOR");
	
	//Then select the recipient
	ffd.findElement(By.xpath("//body/ul/li[3]/a")).click();
	System.out.println("Select the recipient to send...JOOR Florida");
	
	//Populate the subject
	ffd.findElement(By.xpath("//div[3]/input")).sendKeys("send message successful Select connection, Subject populated, message body populated, no attachment");
	System.out.println("send message successful (Select connection, Subject populated, message body populated, no attachment.....Found subject field and populated it");
	
	//Populate message body
	ffd.findElement(By.xpath("//textarea")).sendKeys("send message successful (Select connection, Subject populated, message body populated, no attachment........send message successful (Select connection, Subject populated, message body populated, no attachment");
	System.out.println("send message successful send message successful (Select connection, Subject populated, message body populated, no attachment...Found message body area and populated it");
	
	//Click send to send the message
	ffd.findElement(By.xpath("//form[@id='MessageSendForm']/a")).click();
	System.out.println("Send to all connections, populate subject, populate message, no attachment...send the message");

	
	//Verify send message successful (Add multiple recipients, Subject populated, Add message body)
	//Wait for the messages to clear up before the next one is done
	System.out.println("Waiting for things to clear up......");
	Thread.sleep(5000);
	
	//Find and select Compose mail
	ffd.findElement(By.xpath("//a[contains(text(),'Compose Mail')]")).click();
	System.out.println("send message successful (Add multiple recipients, Subject populated, Add message body");
	
	//click select connections
	ffd.findElement(By.xpath("//input[3]")).click();
	System.out.println("Click select connections");
	
	//Enter first recipients into field
	ffd.findElement(By.xpath("//div[2]/div[2]/input")).sendKeys("JOOR");
	System.out.println("Entered JOOR ( first recipient");
	
	//Then select the first recipient
	ffd.findElement(By.xpath("//body/ul/li[3]/a")).click();
	System.out.println("Select the recipient to send...JOOR Florida");
	
	//Enter second recipients into field
	ffd.findElement(By.xpath("//div[2]/div[2]/input")).sendKeys("x");
	System.out.println("Entered JOOR ( second recipient");
	
	//Wait to catch up
	System.out.println("Wait for things to catch up");
	Thread.sleep(5000);
	
	//Select the second recipient
	ffd.findElement(By.xpath("//body/ul/li/a")).click();
	System.out.println("Select the recipient to send...JOOR Edmonton AB");
	
	//Populate the subject
	ffd.findElement(By.xpath("//div[3]/input")).sendKeys("Verify send message successful (Add multiple recipients, Subject populated, Add message body");
	System.out.println("send message successful (Verify send message successful (Add multiple recipients, Subject populated, Add message body.....Found subject field and populated it");
	
	//populate the message field
	ffd.findElement(By.xpath("//textarea")).sendKeys("Verify send message successful (Add multiple recipients, Subject populated, Add message body,..........Verify send message successful (Add multiple recipients, Subject populated, Add message body,");
	System.out.println("Verify send message successful (Add multiple recipients, Subject populated, Add message body, ...Found message body area and populated it");
	
	//Click send to send the message
	ffd.findElement(By.xpath("//form[@id='MessageSendForm']/a")).click();
	System.out.println("Send to all connections, populate subject, populate message, no attachment...send the message");
	
	System.out.println("Waiting for things to clear up......");
	Thread.sleep(5000);
	

	//Verify error message appears when sending message with invalid attachment type
	//Find and select Compose mail
	ffd.findElement(By.xpath("//a[contains(text(),'Compose Mail')]")).click();
	System.out.println("Compose mail selected");
	
	//send to all connections
	ffd.findElement(By.xpath("//span/div/input[2]")).click();
	System.out.println("Attachment invalid...Found and clicked send to all connections");

	//populate the subject
	ffd.findElement(By.xpath("//div[3]/input")).sendKeys("Invalid attachment....invalid attachment");
	System.out.println("populated subject...invalid attachment");
	
	//populate the message body
	ffd.findElement(By.xpath("//textarea")).sendKeys("Invalid attachment.....INVALID ATTACHMENT!");
	System.out.println("populated message body...invalid attachment");
	
	//find and click Browse to open the dialog...and select the invalid attachment (do the fancy stuff here)
	ffd.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/div[5]/input")).sendKeys("/Users/flimitone/Desktop/article.json");
	System.out.println("open browse dialog and select the invalid...invalid attachment");
	
	//Wait for things to catch up
	System.out.println("Wait for things to catch up before selecting the invalid attachment from the dialog");
	Thread.sleep(5000);
	
	//find and click send button
	ffd.findElement(By.xpath("//form[@id='MessageSendForm']/a")).click();
	System.out.println("Click send button...INVALID ATTACHMENT");
	
	//dismiss the alert
	ffd.switchTo().alert().accept();
	System.out.println("Dismissed the alert");
	System.out.println("Now back to the mail screen");
	
	//wait for things to catch up
	System.out.println("Wait for things to catch up...");
	Thread.sleep(5000);
	
	//Verify error message appears when sending message with LARGE Valid attachment type
	//Find and select Compose Mail
	ffd.findElement(By.xpath("//a[contains(text(),'Compose Mail')]")).click();
	System.out.println("Compose mail selected");
	
	//Click send to all connections
	ffd.findElement(By.xpath("//span/div/input[2]")).click();
	System.out.println("Attachment VALID and LARGE...Found and clicked send to all connections");
	
	//populate subject
	ffd.findElement(By.xpath("//div[3]/input")).sendKeys("Large and valid attachment....");
	System.out.println("populated subject...VALID attachment and large");
	
	//populate the message body
	ffd.findElement(By.xpath("//textarea")).sendKeys("LARGE AND VALID ATTACHMENT.....LARGE AND VALID ATTACHMENT!");
	System.out.println("populated message body...VALID AND LARGE attachment");
	
	//find and click Browse to open the dialog...and select the invalid attachment (do the fancy stuff here)
	ffd.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/div[5]/input")).sendKeys("/Users/flimitone/Desktop/Hi Res Test Images/DigitalGlobe_WorldView2_50cm_8bit_Pansharpened_RGB_DRA_Rome_Italy_2009DEC10_8bits_sub_r_1.jpg");
	System.out.println("open browse dialog and select the VALID AND LARGE");
	
	//Wait for things to catch up
	System.out.println("Wait for things to catch up...valid and large attachment from the dialog");
	Thread.sleep(5000);
	
	//click send
	//find and click send button
	ffd.findElement(By.xpath("//form[@id='MessageSendForm']/a")).click();
	System.out.println("Click send button...INVALID ATTACHMENT");
	
	//Wait for the error to appear
	System.out.println("Wait for things to catch up before selecting the valid and large attachment from the dialog");
	Thread.sleep(10000);
	
	//dismiss the alert
	ffd.switchTo().alert().accept();
	System.out.println("Dismissed the alert");
	System.out.println("Now back to the mail screen");

	
	//Verify error message appears when sending message with large and invalid type
	//First close the open mail window
	ffd.findElement(By.xpath("//div[2]/div/div/div/div/div/a/img")).click();
	System.out.println("The mail window is now closed");
	
	//Hang out and wait
	System.out.println("Wait for things to catch up");
	Thread.sleep(5000);
	
	//Select Compose Mail
	ffd.findElement(By.xpath("//a[contains(text(),'Compose Mail')]")).click();
	System.out.println("Compose mail selected");
	
	//Click send to all connections
	ffd.findElement(By.xpath("//span/div/input[2]")).click();
	System.out.println("Attachment INVALID and LARGE...Found and clicked send to all connections");
	
	//populate subject
	ffd.findElement(By.xpath("//div[3]/input")).sendKeys("Large and invalid attachment....");
	System.out.println("populated subject...INVALID attachment and large");
	
	//populate the message body
	ffd.findElement(By.xpath("//textarea")).sendKeys("LARGE AND INVALID ATTACHMENT.....LARGE AND INVALID ATTACHMENT!");
	System.out.println("populated message body...INVALID AND LARGE attachment");
	
	//find and click Browse to open the dialog...and select the invalid and large attachment (do the fancy stuff here)
	ffd.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/div[5]/input")).sendKeys("/Users/flimitone/Desktop/charles-proxy-4.0.2.dmg");
	System.out.println("open browse dialog and select the INVALID AND LARGE");
	
	//Wait for things to catch up
	System.out.println("Wait for things to catch up.. invalid and large attachment from the dialog");
	Thread.sleep(10000);
	
	//find and click send button
	ffd.findElement(By.xpath("//form[@id='MessageSendForm']/a")).click();
	System.out.println("Click send button...INVALID LARGE ATTACHMENT");
	
	//Wait for the error to appear
	System.out.println("Wait for things to catch up before selecting the valid and large attachment from the dialog");
	Thread.sleep(15000);
	
	//dismiss the alert
	ffd.switchTo().alert().accept();
	System.out.println("Dismissed the alert");
	System.out.println("Now back to the mail screen");
	
	
	//Close the open mail window
	ffd.findElement(By.xpath("//div[2]/div/div/div/div/div/a/img")).click();
	System.out.println("Closed the open mail window");
	
	//Logout
	//click the drop down first
	ffd.findElement(By.xpath("//a/div")).click();
	System.out.println("Clicked the drop down");
	
	//then click logout from the drop
	ffd.findElement(By.xpath("//ul[2]/li/ul/li[6]/a")).click();
	System.out.println("Click logout");
	
	//now should be back at the JOOR main screen and logged out, check something on the main screen
	ffd.findElement(By.id("about-menu-button"));
	System.out.println("Back at the home screen");
	
	
	System.out.println("");
	System.out.println("For now...we're done\n");
	
	//close the browser window
	ffd.close();
	
	System.out.println("Browser window closed");
	}
}