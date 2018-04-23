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
  
  @Test(timeout = 4000)
  public void test05() throws Throwable {
	    GregorianCalendar calendar5 = new GregorianCalendar(2018, 6, 3);
	    CalDay calday5 = new CalDay(calendar5);
	    Appt appt5 = new Appt(24, 30, 7, 12, 2018, "Another Event", "This is another test appointment", "xyz@gmail.com");
	    calday5.addAppt(appt5);
//	    assertEquals(targetString5, string5);
  }

  
}
