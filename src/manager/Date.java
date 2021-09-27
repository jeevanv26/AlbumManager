package manager;
import java.util.Calendar;

/**
 * Creates a Date object which is relevant for users when storing their  albums and its subfields in their collection
 * and ensures validity of a particular album date
 * @author Jeevan Vasanthan, Noah Young
 *
 */

public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;
	public static final int THE_EIGHTYS = 1980;
	public static final int QUADRENNIAL = 4;
	public static final int CENTENNIAL = 100;
	public static final int QUATERCENTENNIAL = 400;
	public static final int THIRTYONE = 31;
	public static final int THIRTY = 30;
	public static final int TWENTYEIGHT = 28;
	public static final int TWENTYNINE = 29;
	public static final int JANUARY = 1;
	public static final int FEBRUARY = 2;
	public static final int MARCH = 3;
	public static final int APRIL = 4;
	public static final int MAY = 5;
	public static final int JUNE = 6;
	public static final int JULY = 7;
	public static final int AUGUST = 8;
	public static final int SEPTEMBER = 9;
	public static final int OCTOBER = 10;
	public static final int NOVEMBER = 11;
	public static final int DECEMBER = 12;
	public static final int LOWESTDAY = 1;
	
	/**
	 * initializes Date object taking in a string in the format "mm/dd/yyyy"
	 * @param date date that is being initialized
	 */
	public Date(String date) { 
		String[] values = date.split("/");

		if(values.length != 3){
			this.month = LOWESTDAY;
			this.day = LOWESTDAY;
			this.year = LOWESTDAY;
		}
		else {
			this.year = Integer.valueOf(values[2]);
			this.day = Integer.valueOf(values[1]);
			this.month = Integer.valueOf(values[0]);
		}
	}

	/**
	 * Creates an object with today's date using the calendar class
	 */
	public Date() { 
		this.year = Calendar.getInstance().getTime().getYear() + 1900;
		this.month = Calendar.getInstance().getTime().getMonth() + 1;
		this.day = Calendar.getInstance().getTime().getDate();

	}

	/**
	 * checks if a particular date input is valid based on a set of conditional statements
	 * @return true if the date is valid and false otherwise
	 */
	public boolean isValid() {

		if(this.year < THE_EIGHTYS){
			return false;
		}
		Date current = new Date();
		if(this.compareTo(current) == 1)
			return false;
		
		if(this.day < LOWESTDAY )
			return false;
		
		if(this.month < JANUARY || this.month > DECEMBER)
			return false;
		
		boolean leapYear = false;
		if(this.year % QUADRENNIAL == 0){
			if(this.year % CENTENNIAL == 0){
				if(this.year % QUATERCENTENNIAL == 0)
					leapYear = true;
			}
			else
				leapYear = true;	
		}

		if(this.month == JANUARY || this.month == MARCH || this.month == MAY|| this.month == JULY || this.month == AUGUST || this.month == OCTOBER || this.month == DECEMBER){
			if(this.day > THIRTYONE){
				return false;
			}
		}
		else if(this.month == APRIL || this.month == JUNE || this.month == SEPTEMBER || this.month == NOVEMBER){
			if(this.day > THIRTY){
				return false;
			}
		}
		else if(this.month == FEBRUARY){
			if(leapYear == true){
				if(this.day > TWENTYNINE)
					return false;
			}
			else {
				if(this.day > TWENTYEIGHT)
					return false;
			}
			
			
		}
		return true;
	}

	/**
	 * compares the current date instance with another date; overrides the Comparable interface
	 * @param date that is being compared with
	 * @return 1, if the instance date happens after the parameter date, 0 if the dates are the same, and -1 if the date happens before the parameter date
	 */
	@Override
	public int compareTo(Date date) {
		if(this.year > date.year){
			return 1;
		}
		else if((this.year == date.year) && (this.month > date.month)){
			return 1;
		}
		else if((this.year == date.year) && (this.month == date.month) && (this.day > date.day)){
			return 1;
		}
		else if(this.year < date.year){
			return -1;
		}
		else if((this.year == date.year) && (this.month < date.month)){
			return -1;
		}
		else if((this.year == date.year) && (this.month == date.month) && (this.day < date.day)){
			return -1;
		}
		else
			return 0;
	}
	
	/**
	 * creates a string representation of the date object to be used in print statements
	 * @return a string 
	 */
	public String toString() {
		return this.month+"/" +this.day+"/"+this.year;
	}
	
	/**
	 * testbed main that implements test cases in the test design document
	 * @param args arguments that the user can input
	 */
	public static void main(String[] args){
		Date testdate1 = new Date("1/16/1800"); 
		System.out.println(testdate1.isValid()); // Test Case #1
		Date testdate2 = new Date("2/29/2019"); 
		Date testdate3 = new Date("2/28/2019"); 
		System.out.println((testdate2.isValid() || testdate3.isValid()) && testdate3.isValid()); //Test Case #2
		Date testdate4 = new Date("2/30/2020"); 
		Date testdate5 = new Date("2/29/2020"); 
		System.out.println((testdate4.isValid() || testdate5.isValid()) && testdate5.isValid()); // Test Case #3
		Date testdate6 = new Date("3/0/2015"); 
		System.out.println(testdate6.isValid()); //Test Case #4
		Date testdate7 = new Date("0/23/2001"); 
		Date testdate8 = new Date("13/22/2002");
		System.out.println(testdate7.isValid() || testdate8.isValid() ); //Test Case #5
		Date testdate9 = new Date("1/32/2004"); 
		Date testdate10 = new Date("1/31/2004");
		System.out.println((testdate9.isValid() || testdate10.isValid()) && testdate10.isValid()); //Test Case #6
		Date testdate11 = new Date("3/32/2005"); 
		Date testdate12 = new Date("3/31/2005"); 
		System.out.println((testdate11.isValid() || testdate12.isValid()) && testdate12.isValid()); //Test Case #7
		Date testdate13 = new Date("4/31/2011"); 
		Date testdate14 = new Date("4/30/2011"); 
		System.out.println((testdate13.isValid() || testdate14.isValid()) && testdate14.isValid()); //Test Case #8
		Date testdate15 = new Date("5/32/2006"); 
		Date testdate16 = new Date("5/31/2006"); 
		System.out.println((testdate15.isValid() || testdate16.isValid()) && testdate16.isValid()); //Test Case #9
		Date testdate17 = new Date("6/31/2012"); 
		Date testdate18 = new Date("6/30/2012"); 
		System.out.println((testdate17.isValid() || testdate18.isValid()) && testdate18.isValid()); //Test Case #10
		Date testdate19 = new Date("7/32/2007"); 
		Date testdate20 = new Date("7/31/2007");
		System.out.println((testdate19.isValid() || testdate20.isValid()) && testdate20.isValid()); //Test Case #11
		Date testdate21 = new Date("8/32/2008"); 
		Date testdate22 = new Date("8/31/2008"); 
		System.out.println((testdate21.isValid() || testdate22.isValid()) && testdate22.isValid()); //Test Case #12
		Date testdate23 = new Date("9/31/2012"); 
		Date testdate24 = new Date("9/30/2012"); 
		System.out.println((testdate23.isValid() || testdate24.isValid()) && testdate24.isValid()); //Test Case #13
		Date testdate25 = new Date("10/32/2009"); 
		Date testdate26 = new Date("10/31/2009"); 
		System.out.println((testdate25.isValid() || testdate26.isValid()) && testdate26.isValid()); //Test Case #14
		Date testdate27 = new Date("11/31/2013"); 
		Date testdate28 = new Date("11/30/2013"); 
		System.out.println((testdate27.isValid() || testdate28.isValid()) && testdate28.isValid()); //Test Case #15
		Date testdate29 = new Date("12/32/2010");
		Date testdate30 = new Date("12/31/2010"); 
		System.out.println((testdate29.isValid() || testdate30.isValid()) && testdate30.isValid()); //Test Case #16
		Date testdate31 = new Date("5/12/2028"); 
		System.out.println(testdate31.isValid()); //Test Case #17
		
	}
}

