package calendar;

import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;
import static org.junit.Assert.*;

/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	//private static final int NUM_TESTS=(3 * 100);
	long randomseed =System.currentTimeMillis();
	long startTime = Calendar.getInstance().getTimeInMillis();
	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
	Random random = new Random(randomseed);
	
	
    /**
     * Generate Random Tests that tests CalDay Class.
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
			//			System.out.println(" Seed:"+randomseed );
						int day = ValuesGenerator.getRandomIntBetween(random, 1, 31);
						int month = ValuesGenerator.getRandomIntBetween(random, 0, 11);
						int year = ValuesGenerator.getRandomIntBetween(random, 1, 2018);
						
						GregorianCalendar calendar1 = new GregorianCalendar(year, month, day);
						CalDay calday1 = new CalDay(calendar1);
						
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
////////////////////////////////////////
/***********Test for addAppt***********/
////////////////////////////////////////
						LinkedList<Appt> appts = new LinkedList<Appt>();	
						 //Add the appts to Appt Linked List...
						 //adding appt 01
						 calday1.addAppt(appt01);
						 if (appt01.getValid()) {
							 boolean apptAdded = false;
							for (int x = 0; x < appts.size(); x++) {
								if ((appts.get(x)).getStartHour() > appt01.getStartHour()) {
									appts.add(x, appt01);
									apptAdded = true;
									Appt added1 = appt01;
									break;
								}
							}
							if(apptAdded == false){
								appts.add(appt01);
							}
						}
						//adding appt 02
						calday1.addAppt(appt02);
						if (appt02.getValid()) {
							boolean apptAdded = false;
						   for (int x = 0; x < appts.size(); x++) {
							   if ((appts.get(x)).getStartHour() > appt02.getStartHour()) {
								   appts.add(x, appt02);
								   apptAdded = true;
								   Appt added2 = appt02;
								   break;
							   }
						   }
						   if(apptAdded == false){
							appts.add(appt02);
							}
					   }
					   //adding appt 03
						calday1.addAppt(appt03);
						if (appt03.getValid()) {
						   boolean apptAdded = false;
						  for (int x = 0; x < appts.size(); x++) {
							  if ((appts.get(x)).getStartHour() > appt03.getStartHour()) {
								  appts.add(x, appt03);
								  apptAdded = true;
								  Appt added3 = appt03;
								  break;
							  }
						  }
						  if(apptAdded == false){
							appts.add(appt03);
						}
					  }
					  //adding appt 04
						calday1.addAppt(appt04);
						if (appt04.getValid()) {
							boolean apptAdded = false;
						   for (int x = 0; x < appts.size(); x++) {
							   if ((appts.get(x)).getStartHour() > appt04.getStartHour()) {
								   appts.add(x, appt04);
								   apptAdded = true;
								   Appt added4 = appt04;
								   break;
							   }
						   }
						   if(apptAdded == false){
							appts.add(appt04);
							}
					   }
						assertEquals(appts, calday1.getAppts());
						 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
							if((iteration%10000)==0 && iteration!=0 ){
								  System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
							}
					 /////////////////////////////////////////////////////////////////////////////////
					}
				}catch(NullPointerException e){
					
				}
				 System.out.println("Now done testing...!!");		 
	 }
	
}