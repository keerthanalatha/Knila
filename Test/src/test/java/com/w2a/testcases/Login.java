package com.w2a.testcases;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import base.TestBase;

public class Login extends TestBase{
	
	
	private CSVReader csvReader;
    String[] csvCell;
 

	@Test()
	public void LoginTest() throws InterruptedException, IOException, CsvValidationException{
		
		


 
    logger.log(Status.INFO, "Login to site");

		driver.findElement(By.name(OR.getProperty("userName_NAME"))).sendKeys("admin");

		driver.findElement(By.name(OR.getProperty("password_NAME"))).sendKeys("admins");

		driver.findElement(By.xpath(OR.getProperty("loginBtn_XPATH"))).click();
		
		
		
		WebElement uploadlink= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("uploadlink_XPATH"))));
	    logger.log(Status.PASS, "Logged in Successfully");
	    logger.log(Status.INFO, "Downloading the CSV and Uploading with Data");
		uploadlink.click();
		WebElement subscriberImportLink= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("subscriberImport_XPATH"))));
		subscriberImportLink.click();
		WebElement downloadCSVbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("downloadCSVbtn_XPATH"))));
		downloadCSVbtn.click();
		
		Thread.sleep(10000);
		
		 csvReader = new CSVReader(new FileReader("/Users/keerthanae/Downloads/ACTIO_Bulk.csv"));
	
		 
		 while ((csvCell = csvReader.readNext()) != null) {
	            String sno = csvCell[0];
	            String fullName = csvCell[1];
	            String isdCode = csvCell[2];
	            String mobileNumber = csvCell[3];
	            String emailID = csvCell[4];
	            String dob = csvCell[5];
	            String idType = csvCell[6];
	            String idNumber = csvCell[7];
	            String username = csvCell[8];
	            String password = csvCell[9];
	           
	            System.out.print(sno );
	            System.out.print(" " + fullName);
	            System.out.print(" " +isdCode );
	            System.out.print(" " +mobileNumber );
	            System.out.print(" " + emailID);
	            System.out.print(" " +dob );
	            System.out.print(" " +idType );
	            System.out.print(" " +idNumber );
	            System.out.print(" " + username);
	            System.out.print(" " +password );
	            System.out.println(" ");
	          
	        }
		 
		 
		 CSVWriter writer = new CSVWriter(new FileWriter("/Users/keerthanae/Downloads/ACTIO_Bulk.csv"));
		 
		 List<String[]> data = new ArrayList<String[]>();
		 data.add(new String[] {"sno","fullName","isdCode","mobileNumber","emailID","dob","idType","idNumber","userName","password"});
		 data.add(new String[] {"1","Keer0","91","9629012789","info@knila.com","01/02/1992","1","1234567891","knila","123456789"});
		 data.add(new String[] {"2","Keer1","91","9629012789","info@knila.com","01/02/1992","1","1234567891","knila","123456789"});
		 data.add(new String[] {"3","Keer2","91","9629012789","info@knila.com","01/02/1992","1","1234567891","knila","123456789"});
		 data.add(new String[] {"4","Keer3","91","9629012789","info@knila.com","01/02/1992","1","1234567891","knila","123456789"});
		 data.add(new String[] {"5","Keer4","91","9629012789","info@knila.com","01/02/1992","1","1234567891","knila","123456789"});

		 writer.writeAll(data);

		
		 
		 
		 
		 while ((csvCell = csvReader.readNext()) != null) {
	            String sno = csvCell[0];
	            String fullName = csvCell[1];
	            String isdCode = csvCell[2];
	            String mobileNumber = csvCell[3];
	            String emailID = csvCell[4];
	            String dob = csvCell[5];
	            String idType = csvCell[6];
	            String idNumber = csvCell[7];
	            String username = csvCell[8];
	            String password = csvCell[9];
	           
	            System.out.print(sno );
	            System.out.print(" " + fullName);
	            System.out.print(" " +isdCode );
	            System.out.print(" " +mobileNumber );
	            System.out.print(" " + emailID);
	            System.out.print(" " +dob );
	            System.out.print(" " +idType );
	            System.out.print(" " +idNumber );
	            System.out.print(" " + username);
	            System.out.print(" " +password );
	            System.out.println(" ");
	           
	        }
		 
		 writer.close();
		 
		 
		 
		 driver.findElement(By.xpath(OR.getProperty("browseBtn_XPATH"))).sendKeys("/Users/keerthanae/Downloads/ACTIO_Bulk1.csv");
		 
		 
		 driver.findElement(By.xpath(OR.getProperty("savebtn_XPATH"))).click();
		 
		 WebElement SuccessMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("successUploadMsg_Toast_XPATH"))));
		  logger.log(Status.PASS, "Data Uploaded Successfully");
		  logger.log(Status.INFO, "Verifying for the Data uploaded");
		 driver.findElement(By.xpath(OR.getProperty("subscriberlink_XPATH"))).click();
		 driver.findElement(By.xpath(OR.getProperty("subscriberList_XPATH"))).click();
		 
		 DateFormat dateFormat = new SimpleDateFormat("D");
		 Date date = new Date();
		 
		 String date1= dateFormat.format(date);
		 System.out.println(date1);
		 
		 driver.findElement(By.xpath(OR.getProperty("fromDatePicker_XPATH"))).click();
		 Actions actions = new Actions(driver);
		 WebElement elementLocator = driver.findElement(By.xpath("//div[@ngbdatepickerdayview and text()='"+date1+"']"));
		 actions.click(elementLocator).perform();
		 
		
		 driver.findElement(By.xpath(OR.getProperty("toDatePicker_XPATH"))).click();
		 WebElement elementLocator1 = driver.findElement(By.xpath("//div[@ngbdatepickerdayview and text()='"+date1+"']"));
		 actions.click(elementLocator1).perform();
		 
		 WebElement updatedTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("datatableEntries_XPATH"))));
		 
		 String updatedTableText = updatedTable.getText();
		 Assert.assertTrue(updatedTableText.contains("Keer0"));
		 Assert.assertTrue(updatedTableText.contains("Keer1"));
		 Assert.assertTrue(updatedTableText.contains("Keer2"));
		 Assert.assertTrue(updatedTableText.contains("Keer3"));
		 Assert.assertTrue(updatedTableText.contains("Keer4"));
		 logger.log(Status.PASS, "Data Reflected in the Subscriber list");
	 

	}
	
	@Test
	
	public void FailTest() {
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals("xyz", "ABC");
		logger.log(Status.FAIL, "To check Screenshot");
		
		
	}
	

	
}
