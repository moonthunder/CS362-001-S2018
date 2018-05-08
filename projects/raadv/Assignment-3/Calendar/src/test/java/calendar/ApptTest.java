/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;

public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
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
	
	 Appt appt2 = new Appt(23, 30, 12, 18, 2018, "Meteor Shower", "Space rocks falling from the sky", "xyz@gmail.com");
     String string2 = appt2.toString();
     assertEquals(2, appt2.getRecurBy());
     assertFalse(appt2.isRecurring());
     assertEquals("\t18/12/2018 at 11:30pm ,Meteor Shower, Space rocks falling from the sky\n", string2);
     assertEquals(0, appt2.getRecurIncrement());
     appt2.setValid();
}

@Test(timeout = 4000)
public void test03()  throws Throwable  {

	Appt appt3 = new Appt(24, 30, -7, 12, 2018, "Invalid Day Event", "This event has an invalid day", "xyz@gmail.com");
    appt3.setValid();
//    assertFalse(appt3.getValid());
    Appt appt03 = new Appt(24, 30, 7, 12, 2018, "Another Event", "This is another test appointment", "xyz@gmail.com");
    appt03.setValid();
//    assertFalse(appt03.getValid());
}

@Test(timeout = 4000)
public void test04()  throws Throwable  {
	
    Appt appt4 = new Appt(2, 4, 6, null, null, null);
    assertEquals("", appt4.getTitle());
    assertEquals("", appt4.getDescription());
    assertEquals("", appt4.getEmailAddress());
    Appt appt04 = new Appt(5, 5, 2018, "Invalid Time Event", "This event has no time set", "xyz@gmail.com");
    assertFalse(appt04.hasTimeSet());
}

@Test(timeout = 4000)
public void test05() throws Throwable {
	
    Appt appt5 = new Appt(24, 30, 7, 12, -2018, "False Year Event", "This event has a false year", "xyz@gmail.com");
    appt5.setValid();
    assertFalse(appt5.getValid());
    String string5 = appt5.toString();
    Appt appt05 = new Appt(25, 30, 7, 12, 2018, "Another Event", "This is another test appointment", "xyz@gmail.com");
//    String string5 = appt05.toString();
//    assertEquals("\t12/10/2018 at 11:15am ,Birthday Party, This is my birthday party\n", string5);
}

//////////////////////////////
/// Added for Assignment 3 ///
//////////////////////////////
@Test(timeout = 4000)
public void test06()  throws Throwable  {
Appt appt6 = new Appt(1, 1, 1, 1, 1, "Another Event", "This is another test appointment", "xyz@gmail.com");
appt6.setValid();
assertTrue(appt6.getValid());
int[] intT = {1, 2, 3};
appt6.setRecurrence(intT, 1, 2, 3);
assertEquals(appt6.getRecurDays(),intT);
assertEquals(appt6.getRecurBy(), 1);
assertEquals(appt6.getRecurIncrement(), 2);
assertEquals(appt6.getRecurNumber(), 3);
}

@Test(timeout = 4000)
public void test07()  throws Throwable  {
Appt appt7 = new Appt(1, 1, 1, 1, 1, "Another Event", "This is another test appointment", "xyz@gmail.com");
appt7.setValid();
assertTrue(appt7.getValid());
appt7.setStartMonth(0);
assertEquals(appt7.getStartMonth(), 0);
appt7.setValid();
assertFalse(appt7.getValid());
appt7.setStartMonth(13);
appt7.setValid();
assertFalse(appt7.getValid());
}

@Test(timeout = 4000)
public void test08()  throws Throwable  {
Appt appt8 = new Appt(1, 1, 1, 1, 1, "Another Event", "This is another test appointment", "xyz@gmail.com");
appt8.setValid();
assertTrue(appt8.getValid());
appt8.setStartHour(-1);
assertEquals(appt8.getStartHour(), -1);
appt8.setValid();
assertFalse(appt8.getValid());
appt8.setStartHour(24);
appt8.setValid();
assertFalse(appt8.getValid());
}

@Test(timeout = 4000)
public void test09()  throws Throwable  {
Appt appt9 = new Appt(1, 1, 1, 1, 1, "Another Event", "This is another test appointment", "xyz@gmail.com");
appt9.setValid();
assertTrue(appt9.getValid());
appt9.setStartMinute(-1);
assertEquals(appt9.getStartMinute(), -1);
appt9.setValid();
assertFalse(appt9.getValid());
appt9.setStartMinute(60);
appt9.setValid();
assertFalse(appt9.getValid());
appt9.setStartMinute(0);
}

@Test(timeout = 4000)
public void test10()  throws Throwable  {
Appt appt10 = new Appt(1, 1, 1, 1, 1, "Another Event", "This is another test appointment", "xyz@gmail.com");
appt10.setValid();
assertTrue(appt10.getValid());
appt10.setStartYear(-1);
assertEquals(appt10.getStartYear(), -1);
appt10.setValid();
assertFalse(appt10.getValid());
}

@Test(timeout = 4000)
public void test11()  throws Throwable  {
Appt appt11 = new Appt(1, 1, 1, 1, 1, "Another Event", "This is another test appointment", "xyz@gmail.com");
appt11.setValid();
assertTrue(appt11.getValid());
appt11.setStartDay(-1);
assertEquals(appt11.getStartDay(), -1);
appt11.setValid();
assertFalse(appt11.getValid());
appt11.setStartDay(32);
appt11.setValid();
assertFalse(appt11.getValid());
}

@Test(timeout = 4000)
public void test12()  throws Throwable  {
Appt appt12 = new Appt(1, 1, 1, 1, 1, "Another Event", "This is another test appointment", "xyz@gmail.com");
appt12.setValid();
assertTrue(appt12.getValid());
assertTrue(appt12.hasTimeSet());
appt12.setStartHour(-1);
assertFalse(appt12.hasTimeSet());
}

@Test(timeout = 4000)
public void test13()  throws Throwable  {
Appt appt13 = new Appt(1, 1, 1, 1, 1, "Another Event", "This is another test appointment", "xyz@gmail.com");
assertEquals(appt13.getStartHour(),1);
assertEquals(appt13.getStartMinute(),1);
assertEquals(appt13.getStartDay(),1);
assertEquals(appt13.getStartMonth(),1);
assertEquals(appt13.getStartYear(),1);
assertEquals(appt13.getTitle(),"Another Event");
assertEquals(appt13.getDescription(),"This is another test appointment");
assertEquals(appt13.getEmailAddress(),"xyz@gmail.com");
}


}