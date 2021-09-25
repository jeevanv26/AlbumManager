import java.util.Calendar;

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
	public static final int TWENTYNINE= 29;
	public static final int JANUARY=1;
	public static final int FEBRUARY=2;
	public static final int MARCH=3;
	public static final int APRIL=4;
	public static final int MAY=5;
	public static final int JUNE=6;
	public static final int JULY=7;
	public static final int AUGUST=8;
	public static final int SEPTEMBER=9;
	public static final int OCTOBER=10;
	public static final int NOVEMBER=11;
	public static final int DECEMBER=12;
	
	public Date(String date) { //take "mm/dd/yyyy" and create a Date object
		String[] values = date.split("/");

		if(values.length != 3){
			this.month = 0;
			this.day = 0;
			this.year = 0;
			return;
		}

		this.year = Integer.valueOf(values[2]);
		this.day = Integer.valueOf(values[1]);
		this.month = Integer.valueOf(values[0]);
	}

	public Date() { //create an object with today's date ( see Calendar class)
		this.year = Calendar.getInstance().getTime().getYear() + 1900;
		this.month = Calendar.getInstance().getTime().getMonth() + 1;
		this.day = Calendar.getInstance().getTime().getDate();

	}

	public boolean isValid() {

		if(this.year < THE_EIGHTYS){
			return false;
		}
		Date current = new Date();
		if(this.compareTo(current)==1)
			return false;
		
		if(this.day < 1){
			return false;
		}
		
		boolean leapYear = false;
		if(this.year % QUADRENNIAL == 0){
			if(this.year % CENTENNIAL == 0){
				if(this.year % QUATERCENTENNIAL == 0)
					leapYear = true;
			}
			else
				leapYear=true;	
		}

		if(this.month == SEPTEMBER || this.month == MARCH || this.month == MAY|| this.month == JULY || this.month == AUGUST || this.month == OCTOBER || this.month == DECEMBER){
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
			
			
		}
		return true;
	}

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
		else if((this.year == date.year) && (this.month <date.month)){
			return -1;
		}
		else if((this.year == date.year) && (this.month == date.month) && (this.day <date.day)){
			return -1;
		}
		else
			return 0;
	}
	public static void main(String[] args){
		Date testdate = new Date("2/16/2021");
		if(testdate.isValid() == true){
			System.out.println("pass");
		}
		else 
			System.out.println("fail");
		
	}
}

