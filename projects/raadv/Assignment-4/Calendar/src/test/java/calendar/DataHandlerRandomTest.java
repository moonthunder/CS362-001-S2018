package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=(3 * 100);
	long randomseed =System.currentTimeMillis();
	long startTime = Calendar.getInstance().getTimeInMillis();
	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
	Random random = new Random(randomseed);
	
	
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {
		  long randomseed =System.currentTimeMillis();
		  long startTime = Calendar.getInstance().getTimeInMillis();
		  long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		  Random random = new Random(randomseed);
		  System.out.println("Let's start testing...!!");
		 
		 
		 		  		try{ 
					for (int iteration = 0; elapsed < TestTimeout; iteration++) {
						//System.out.println(" Seed:"+randomseed );
						float roll = (float)(1/2);
						int day001 = ValuesGenerator.getRandomIntBetween(random, 1, 31);
						int month001 = ValuesGenerator.getRandomIntBetween(random, 0, 11);
						int year001 = ValuesGenerator.getRandomIntBetween(random, 1, 2018);
						int day002 = ValuesGenerator.getRandomIntBetween(random, 1, 31);
						int month002 = ValuesGenerator.getRandomIntBetween(random, 0, 11);
						int year002 = ValuesGenerator.getRandomIntBetween(random, 1, 2018);
						GregorianCalendar calendar01 = new GregorianCalendar(year001, month001, day001);
						CalDay calday1 = new CalDay(calendar01);
						GregorianCalendar calendar02 = new GregorianCalendar(year002, month002, day002);
						CalDay calday2 = new CalDay(calendar02);
		
						boolean doesSave = ValuesGenerator.getBoolean(roll, random);
						DataHandler dataHan = new DataHandler("testData",doesSave);
//
						
						 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
						 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
						 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
						 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
						 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
						 String title="Birthday Party";
						 String description="This is my birthday party.";
						 String emailAddress="xyz@gmail.com";

						 //Construct a new Appointment object with the initial data	 
						 Appt appt01 = new Appt(startHour,
								  startMinute ,
								  startDay ,
								  startMonth ,
								  startYear ,
								  title,
								 description,
								 emailAddress);
								 appt01.setValid();
								 
								 int startHour02=ValuesGenerator.getRandomIntBetween(random, 1, 24);
								 int startMinute02=ValuesGenerator.getRandomIntBetween(random, 0, 60);
								 int startDay02=ValuesGenerator.getRandomIntBetween(random, 1, 31);
								 int startMonth02=ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 int startYear02=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
								 String title02="Test Event";
								 String description02="This is another test event.";
								 String emailAddress02="xyz@gmail.com";
								 
						 //Construct a new Appointment object with the initial data	 
						 Appt appt02 = new Appt(startHour02,
								  startMinute02 ,
								  startDay02 ,
								  startMonth02 ,
								  startYear02 ,
								  title02,
								 description02,
								 emailAddress02);
								 appt02.setValid();
								 
								 int startHour03=ValuesGenerator.getRandomIntBetween(random, 0, 15);
								 int startMinute03=ValuesGenerator.getRandomIntBetween(random, 0, 15);
								 int startDay03=ValuesGenerator.getRandomIntBetween(random, 0, 15);
								 int startMonth03=ValuesGenerator.getRandomIntBetween(random, 0, 15);
								 int startYear03=ValuesGenerator.getRandomIntBetween(random, 2000, 2018);
								 String title03="Test Event";
								 String description03="This is another test event.";
								 String emailAddress03="xyz@gmail.com";
								 
						 //Construct a new Appointment object with the initial data	 
						 Appt appt03 = new Appt(startHour03,
								  startMinute03 ,
								  startDay03 ,
								  startMonth03 ,
								  startYear03 ,
								  title03,
								 description03,
								 emailAddress03);
								 appt03.setValid();
								 
								 int startHour04=ValuesGenerator.getRandomIntBetween(random, -1, 30);
								 int startMinute04=ValuesGenerator.getRandomIntBetween(random, -1, 30);
								 int startDay04=ValuesGenerator.getRandomIntBetween(random, -1, 30);
								 int startMonth04=ValuesGenerator.getRandomIntBetween(random, -1, 30);
								 int startYear04=ValuesGenerator.getRandomIntBetween(random, 1000, 2018);
								 String title04="Test Event";
								 String description04="This is another test event.";
								 String emailAddress04="xyz@gmail.com";
								 
						 //Construct a new Appointment object with the initial data	 
						 Appt appt04 = new Appt(startHour04,
								  startMinute04 ,
								  startDay04 ,
								  startMonth04 ,
								  startYear04 ,
								  title04,
								 description04,
								 emailAddress04);
								 appt04.setValid();
								 
///////////////////////////////////////
/*********Test for deleteAppt*********/
///////////////////////////////////////
		assertFalse(dataHan.deleteAppt(appt01));
		dataHan.saveAppt(appt01);
		if(appt01.getValid() == false){				//try deleting appt
			assertFalse(dataHan.deleteAppt(appt01));
		}
		else{										//delete the appt
			assertTrue(dataHan.deleteAppt(appt01));
		}
///////////////////////////////////////
///////////////////////////////////////
/**
						 if(!appt01.getValid())continue;
						 for (int x = 0; x < NUM_TESTS; x++) {
							String methodName = ApptRandomTest.RandomSelectMethod(random);
							   if (methodName.equals("setTitle")){
								   String newTitle=(String) ValuesGenerator.getString(random);
								   appt01.setTitle(newTitle);						   
								}
							   else if (methodName.equals("setRecurrence")){
								   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
								   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
								   int recur=ApptRandomTest.RandomSelectRecur(random);
								   int recurIncrement = ValuesGenerator.RandInt(random);
								   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
								   appt01.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
								}				
						}
***/
///////////////////////////////////////
/********Test for getApptRange********/
///////////////////////////////////////
		//4 recurring appts
		float rolling01 = (float)(1/2);
		boolean noRecurringDays01 = ValuesGenerator.getBoolean(rolling01, random);
		int[] recurDays01 = null;
		float rolling02 = (float)(1/2);
		boolean noRecurringDays02 = ValuesGenerator.getBoolean(rolling02, random);
		int[] recurDays02 = null;
		float rolling03 = (float)(1/2);
		boolean noRecurringDays03 = ValuesGenerator.getBoolean(rolling03, random);
		int[] recurDays03 = null;
		float rolling04 = (float)(1/2);
		boolean noRecurringDays04 = ValuesGenerator.getBoolean(rolling04, random);
		int[] recurDays04 = null;
		///////////////////////////////
		// rucurring #01
		if (noRecurringDays01 == false){
			int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
			recurDays01=ValuesGenerator.generateRandomArray(random, sizeArray);
		}
		int recurring01=ApptRandomTest.RandomSelectRecur(random);
		int recurIncrement01 = ValuesGenerator.RandInt(random);
		int recurNumber01=ApptRandomTest.RandomSelectRecurForEverNever(random);
		appt01.setRecurrence(recurDays01, recurring01, recurIncrement01, recurNumber01);
		// rucurring #02
		if (noRecurringDays02 == false){
			int sizeArray2=ValuesGenerator.getRandomIntBetween(random, 0, 8);
			recurDays02=ValuesGenerator.generateRandomArray(random, sizeArray2);
		}
		int recurring02=ApptRandomTest.RandomSelectRecur(random);
		int recurIncrement02 = ValuesGenerator.RandInt(random);
		int recurNumber02=ApptRandomTest.RandomSelectRecurForEverNever(random);
		appt02.setRecurrence(recurDays02, recurring02, recurIncrement02, recurNumber02);
		// rucurring #03
		if (noRecurringDays03 == false){
			int sizeArray03=ValuesGenerator.getRandomIntBetween(random, 0, 8);
			recurDays03=ValuesGenerator.generateRandomArray(random, sizeArray03);
		}
		int recurring03=ApptRandomTest.RandomSelectRecur(random);
		int recurIncrement03 = ValuesGenerator.RandInt(random);
		int recurNumber03=ApptRandomTest.RandomSelectRecurForEverNever(random);
		appt03.setRecurrence(recurDays03, recurring03, recurIncrement03, recurNumber03);
		// rucurring #04		
		if (noRecurringDays04 == false){
			int sizeArray04=ValuesGenerator.getRandomIntBetween(random, 0, 8);
			recurDays04=ValuesGenerator.generateRandomArray(random, sizeArray04);
		}
		int recurring04=ApptRandomTest.RandomSelectRecur(random);
		int recurIncrement04 = ValuesGenerator.RandInt(random);
		int recurNumber04=ApptRandomTest.RandomSelectRecurForEverNever(random);
		appt04.setRecurrence(recurDays04, recurring04, recurIncrement04, recurNumber04);
		///////////////////////////////
		try{
			dataHan.saveAppt(appt01);
			dataHan.saveAppt(appt02);
			dataHan.saveAppt(appt03);
			dataHan.saveAppt(appt04);

			LinkedList<CalDay> caldays = new LinkedList<CalDay>();
			caldays = (LinkedList<CalDay>) dataHan.getApptRange(calendar01,calendar02);
		}catch (DateOutOfRangeException D){

		}
  			  elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
  				 if((iteration%100)==0 && iteration!=0 )
  					   System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

				   File dataTestFile = new File("./testData");
				   dataTestFile.delete();
  		 }
  	 }catch(NullPointerException e){

  	 }
  	  System.out.println("Now done testing...!!");
	 }
}
















































