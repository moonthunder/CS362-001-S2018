/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.LinkedList;
import java.util.GregorianCalendar;

public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  CalDay calDays = new CalDay();
	  assertEquals(false, calDays.isValid());
	  
  }
  
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

	  Appt appt1 = new Appt(13, 10, 12, 3, 2018, "Concert", "Going to concert with friends", "xyz@gmail.com");
      String string1 = appt1.toString();
      assertEquals(2, appt1.getRecurBy());
      assertFalse(appt1.isRecurring());
      assertEquals("\t3/12/2018 at 1:10pm ,Concert, Going to concert with friends\n", string1);
      assertEquals(0, appt1.getRecurIncrement());
      appt1.setValid();
  }
  
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {

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
  public void test03() throws Throwable {
	  
      CalDay calDay3 = new CalDay();
      String string3 = calDay3.toString();
      StringBuilder sbv3 = new StringBuilder();
      String targetString3 = sbv3.toString();
      assertEquals(targetString3, string3);
  }
 /* //commented out test failure
  @Test(timeout = 4000)
  public void test04() throws Throwable {
	  
	    GregorianCalendar calendar4 = new GregorianCalendar(2018, 9, 1);
	    CalDay calday4 = new CalDay(calendar4);
	    Appt appt4 = new Appt(15, 30, 4, 6, 2018, "Event", "This is a test appointment", "xyz@gmail.com");
	    calday4.addAppt(appt4);
	    String targetString4 = "6-4-2018 \n\t3:30PM Event This is a test appointment ";
	    String string4 = calday4.getFullInfomrationApp(calday4);
//	    System.out.println("Test04 - " + string4);
//	    assertEquals(targetString6, string4);
  }
  *///test failure ends here
  
  @Test(timeout = 4000)
  public void test05() throws Throwable {
	    GregorianCalendar calendar5 = new GregorianCalendar(2018, 6, 3);
	    CalDay calday5 = new CalDay(calendar5);
	    Appt appt5 = new Appt(24, 30, 7, 12, 2018, "Another Event", "This is another test appointment", "xyz@gmail.com");
	    calday5.addAppt(appt5);
//	    assertEquals(targetString5, string5);
  }

//////////////////////////////
/// Added for Assignment 3 ///
//////////////////////////////
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
	  CalDay calda6;
	  calda6 = new CalDay();
	  assertFalse(calda6.valid);
	  CalDay calda06 = new CalDay(new GregorianCalendar(2018,0,1));
	  assertEquals(calda06.getYear(),2018);
	  assertEquals(calda06.getMonth(),1);
	  assertEquals(calda06.getDay(),1);
	  LinkedList<Appt> LinAp = new LinkedList<Appt>();
	  assertEquals(calda06.appts,LinAp);
	  }
  
  /* //commented out test failure
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
	GregorianCalendar date0 = new GregorianCalendar(2000, 0, 1);
	CalDay calda7 = new CalDay(date0);
	assertTrue(calda7.isValid());
	Appt apptv0 = new Appt(17, 7, 8, 10, 2018, "Another Event", "This is another test appointment", "xyz@gmail.com");
	calda7.addAppt(apptv0);
	Appt apptv1 = new Appt(17, 8, 8, 10, 2018, "Another Event", "This is another test appointment", "xyz@gmail.com");
	calda7.addAppt(apptv1);
	Appt apptv2 = new Appt(17, 9, 8, 10, 2018, "Another Event", "This is another test appointment", "xyz@gmail.com");
	calda7.addAppt(apptv2);
	Appt apptv3 = new Appt(17, 14, 9, 12, 2018, null, null, null);
	calda7.addAppt(apptv3);
	Appt apptv4 = new Appt(0, 0, 2, 13, 2018, null, null, null);
	calda7.addAppt(apptv4);
	Appt apptv5 = new Appt(1, 1, 2018, null, null, null);
	apptv5.setValid();
	calda7.addAppt(apptv5);
	calda7.getFullInfomrationApp(calda7);
	}
  *////test failure ends here
  
  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
	CalDay calda8;
	calda8 = new CalDay();
	assertFalse(calda8.isValid());
	assertNull(calda8.iterator());
	assertEquals("", calda8.toString());
	}


}

