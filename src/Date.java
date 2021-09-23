import java.util.Calendar;

public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;

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
		final int THE_EIGHTYS = 1980;
		final int QUADRENNIAL = 4;
		final int CENTENNIAL = 100;
		final int QUATERCENTENNIAL = 400;
		final int THIRTYONE = 31;
		final int THIRTY = 30;
		final int TWENTYEIGHT = 28;
		final int FEBLEAP = 29;

		if(this.year < THE_EIGHTYS){
			return false;
		}

		Date current = new Date();
		if(this.year > current.year){
			return false;
		}else if((this.year == current.year) && (this.month > current.month)){
			return false;
		}else if((this.year == current.year) && (this.month == current.month) && (this.day > current.day)){
			return false;
		}

		if(this.day < 1){
			return false;
		}

		boolean leapYear = false;
		if(this.year % QUADRENNIAL == 0){
			if(this.year % CENTENNIAL == 0){
				if(this.year % QUATERCENTENNIAL == 0){
					leapYear = true;
				}
			}
		}

		if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12){
			if(this.day > THIRTYONE){
				return false;
			}
		}else if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){
			if(this.day > THIRTY){
				return false;
			}
		}else if(this.month == 2){
			if(leapYear == true){
				if(this.day > FEBLEAP){
					return false;
				}
			}else if(this.day > TWENTYEIGHT){
				return false;
			}
		}
		return true;
	}

	@Override
	public int compareTo(Date date) {
		return 1;
	}
	public static void main(String[] args){
		Date testdate = new Date("2/16/2021");
		if(testdate.isValid() == true){
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	}
}

