import java.util.Calender
public class Date implements Comparable<Date>{
private int year;
private int month;
private int day;

public static final int QUADRENNIAL = 4;
public static final int CENTENNIAL = 100;
public static final int QUATERCENTENNIAL = 400;
public static final int THE_EIGHTYS = 1980;

public Date(String date) { //take "mm/dd/yyyy" and create a Date object
	String[] values = date.split("/");
	this.year = values[2];
	this.day = values[1];
	this.month = values[0];
	new Date(year, month-1, day);
}

public Date() { //create an object with today's date ( see Calendar class)
	Date today = new Date();
	Calender current = Calender.getInstance();
	current.setTime(today);
	int currentYear = current.get(Calender.YEAR);
	int currentMonth = current.get(Calender.MONTH);
	int currentDay = current.get(Calender.DAY_OF_MONTH);
}

public boolean isValid() {

	if((day >  31 && month == 1 || 3 || 5 || 7 || 8 || 10 || 12) || (day > 30 && month = 4 || 6 || 9 || 11)){
		return false;
	}else if((month == 2) && (year % QUADRENNIAL == 0) && (year % CENTENNIAL == 0) && (year % QUATERCENTENNIAL == 0)){
		if(day > 29){
			return false;
		}
	}else if(day > 28){
		return false;
	}else if(year < THE_EIGHTYS || year > currentYear){
		return false;
	}else if(year == currentYear && month > currentMonth){
		return false;
	}else if(year == currentYear && month == currentMonth && day > currentDay){
		return false;
	}else{
		return true;
	}


}

@Override
public int compareTo(Date date) {
	
}

}
