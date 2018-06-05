
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  
	  DataHandler datahan1 = new DataHandler("test1",true);
	  Appt appt1 = new Appt(13, 10, 12, 3, 2018, "Concert", "Going to concert with friends", "xyz@gmail.com");
      String string1 = appt1.toString();
      assertEquals(2, appt1.getRecurBy());
      assertFalse(appt1.isRecurring());
      assertEquals("\t3/12/2018 at 1:10pm ,Concert, Going to concert with friends\n", string1);
      assertEquals(0, appt1.getRecurIncrement());
      appt1.setValid();
      
      Appt appt2 = new Appt(23, 30, 12, 18, 2018, "Meteor Shower", "Space rocks falling from the sky", "xyz@gmail.com");
      String string2 = appt2.toString();
      assertEquals(2, appt2.getRecurBy());
      assertFalse(appt2.isRecurring());
      assertEquals("\t18/12/2018 at 11:30pm ,Meteor Shower, Space rocks falling from the sky\n", string2);
      assertEquals(0, appt2.getRecurIncrement());
      appt2.setValid();
  }
  
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      
	  DataHandler datahan1 = new DataHandler("test2",true);
	  Appt appt2 = new Appt(13, 10, 12, 3, 2018, "Concert", "Going to concert with friends", "xyz@gmail.com");
	  appt2.setValid();
//      assertFalse(datahan1.saveAppt(appt2));
  }
  
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      
	  DataHandler datahan2 = new DataHandler("test3",false);
	  Appt appt3 = new Appt(13, 10, 12, 3, 2018, "Concert", "Going to concert with friends", "xyz@gmail.com");
	  appt3.setValid();
//      assertFalse(datahan2.saveAppt(appt3));
  }
  
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {

	  DataHandler datahan3 = new DataHandler("test4",true);
      Appt appt4 = new Appt(13, 10, 12, 3, 2018, "Concert", "Going to concert with friends", "xyz@gmail.com");
      appt4.setValid();
      assertTrue(datahan3.saveAppt(appt4));
  }
  
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {

	  DataHandler datahan4 = new DataHandler("test5",false);
	  Appt appt5 = new Appt(13, 10, 12, 3, 2018, "Concert", "Going to concert with friends", "xyz@gmail.com");
	  appt5.setValid();
	  assertTrue(datahan4.saveAppt(appt5));
}

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {

	  DataHandler datahan5 = new DataHandler("test6",true);
      Appt appt6 = new Appt(13, 10, 12, 3, 2018, "Concert", "Going to concert with friends", "xyz@gmail.com");
      appt6.setValid();
      datahan5.saveAppt(appt6);
      assertTrue(datahan5.saveAppt(appt6));
  }
  
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {

	  DataHandler datahan6 = new DataHandler("test7",false);
	  Appt appt7 = new Appt(13, 10, 12, 3, 2018, "Concert", "Going to concert with friends", "xyz@gmail.com");
	  appt7.setValid();
      datahan6.saveAppt(appt7);
	  assertTrue(datahan6.saveAppt(appt7));
}
  
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {

	  DataHandler datahan7 = new DataHandler("test8",true);
      Appt appt01 = new Appt(13, 10, 12, 3, 2018, "Concert", "Going to concert with friends", "xyz@gmail.com");
      Appt appt02 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      Appt appt03 = new Appt(23, 30, 12, 18, 2018, "Meteor Shower", "Space rocks falling from the sky", "xyz@gmail.com");
      int recurDaysv1[] = {};
      int recurDaysv2[] = {1};
      int recurDaysv3[] = {2};
      appt03.setRecurrence(recurDaysv1,1,5,3);
      Appt appt04 = new Appt(16, 35, 10, 15, 2018, "Test Meeting", "Another test meeting...", "xyz@gmail.com");
      Appt appt05 = new Appt(17, 40, 10, 15, 2018, "Test Meeting +1", "Another test meeting...", "xyz@gmail.com");
      Appt appt06 = new Appt(18, 45, 10, 15, 2018, "Test Meeting +2", "Another test meeting...", "xyz@gmail.com");
      appt04.setRecurrence(recurDaysv2,5,2,5);
      appt05.setRecurrence(recurDaysv3,5,1,5);
      datahan7.saveAppt(appt01);
      datahan7.saveAppt(appt02);
      datahan7.saveAppt(appt03);
      datahan7.saveAppt(appt04);
      datahan7.saveAppt(appt05);
      datahan7.saveAppt(appt06);

      GregorianCalendar calendarv1 = new GregorianCalendar(2018, 0, 1);
      GregorianCalendar calendarv2 = new GregorianCalendar(2018, 2, 3);
      LinkedList<CalDay> calDays = new LinkedList<CalDay>();
      LinkedList<CalDay> targetCalDays = new LinkedList<CalDay>();

      GregorianCalendar nextDay = (GregorianCalendar) calendarv1.clone();
      while (nextDay.before(calendarv2)) {
          targetCalDays.add(new CalDay(nextDay));
          nextDay.add(nextDay.DAY_OF_MONTH, 1);
      }
      targetCalDays.get(0).addAppt(appt01);
      targetCalDays.get(32).addAppt(appt02);
      targetCalDays.get(32).addAppt(appt03);
      targetCalDays.get(32).addAppt(appt04);
      targetCalDays.get(32).addAppt(appt05);
      targetCalDays.get(32).addAppt(appt06);
      targetCalDays.get(34).addAppt(appt01);
      targetCalDays.get(39).addAppt(appt02);
      targetCalDays.get(41).addAppt(appt03);
      targetCalDays.get(46).addAppt(appt04);
      targetCalDays.get(48).addAppt(appt05);
      targetCalDays.get(53).addAppt(appt06);
      targetCalDays.get(55).addAppt(appt01);
      targetCalDays.get(60).addAppt(appt02);
      targetCalDays.get(60).addAppt(appt03);
      targetCalDays.get(60).addAppt(appt04);
      targetCalDays.get(60).addAppt(appt05);
      targetCalDays.get(60).addAppt(appt06);
      calDays = (LinkedList<CalDay>) datahan7.getApptRange(calendarv1,calendarv2);
  }
 
//////////////////////////////
/// Added for Assignment 3 ///
//////////////////////////////
  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
	  Appt appt8 = new Appt(17, 7, 8, 10, 2018, "Another Event", "This is another test appointment", "xyz@gmail.com");
	  appt8.setValid();
	  DataHandler datahan1 = new DataHandler("test8v1", false);
	  DataHandler datahan2 = new DataHandler("test8v2", true);

	  assertTrue(datahan1.saveAppt(appt8));
	  assertTrue(datahan1.deleteAppt(appt8));
	  assertTrue(datahan2.saveAppt(appt8));
	  assertTrue(datahan2.deleteAppt(appt8));
	  assertTrue(datahan2.saveAppt(appt8));
	  appt8.setXmlElement(null);
	  assertFalse(datahan2.deleteAppt(appt8));
	  appt8.setXmlElement(null);
	  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
	  DataHandler datahan1 = new DataHandler();
	  Appt appt9 = new Appt(17, 7, 8, 10, 2018, null, null, null);
	  Appt appt09 = new Appt(75, 18, 11, 5, 2018, null, null, null);
	  appt9.setValid();
	  appt09.setValid();		
	  assertFalse(datahan1.saveAppt(appt09));
	  assertTrue(datahan1.saveAppt(appt9));
	  assertFalse(datahan1.deleteAppt(appt09));
	  assertTrue(datahan1.deleteAppt(appt9));
	  }
  
  @Test(timeout = 4000)
  public void test10()  throws Throwable  {

	  GregorianCalendar firstDay = new GregorianCalendar(2018, 0, 1);
	  GregorianCalendar dayx1 = new GregorianCalendar(2019, 11, 25);
	  int[] recurring = {2};
	  DataHandler datahan1 = new DataHandler("calendar.xml", false);
	  
	  Appt appt10v1 = new Appt(0, 0, 8, 7, 2018, null, null, null);
  	  appt10v1.setRecurrence(recurring, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
	  assertTrue(datahan1.saveAppt(appt10v1));
	  Appt appt10v2 = new Appt(0, 0, 9, 7, 2018, null, null, null);
	  appt10v2.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
	  assertTrue(datahan1.saveAppt(appt10v2));
	  Appt appt10v3 = new Appt(0, 0, 10, 7, 2018, null, null, null);
	  appt10v3.setRecurrence(null, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
	  assertTrue(datahan1.saveAppt(appt10v3));
	  Appt appt10v4 = new Appt(0, 0, 14, 7, 2018, null, null, null);
	  appt10v4.setRecurrence(null, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
	  assertTrue(datahan1.saveAppt(appt10v4));
	  
	  datahan1.getApptRange(firstDay, dayx1);
	  assertTrue(datahan1.deleteAppt(appt10v1));
	  }

}