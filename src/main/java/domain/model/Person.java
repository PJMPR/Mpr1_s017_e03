package domain.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Person {
	
	private String pesel;

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public GregorianCalendar getDayOfBirth(){

		if (Character.getNumericValue(getPesel().charAt(2)) >1 && Character.getNumericValue(getPesel().charAt(2)) < 5){
			StringBuilder yearOfBirth = new StringBuilder();
			yearOfBirth.append("2" + "0" + getPesel().charAt(0) + getPesel().charAt(1));

			StringBuilder monthOfBirth = new StringBuilder();
			monthOfBirth.append("" + (getPesel().charAt(2)-2) + getPesel().charAt(3));

			StringBuilder dayOfBirth = new StringBuilder();
			dayOfBirth.append("" + getPesel().charAt(4) + getPesel().charAt(5));

			String YearString = yearOfBirth.toString();
			String MonthString = monthOfBirth.toString();
			String DayString = dayOfBirth.toString();

			Integer Year = Integer.valueOf(YearString);
			Integer Month = Integer.valueOf(MonthString);
			Integer	Day = Integer.valueOf(DayString);

			return new GregorianCalendar(Year, Month, Day);
		}

		else if (Character.getNumericValue(getPesel().charAt(2)) <=1){
			StringBuilder yearOfBirth = new StringBuilder();
			yearOfBirth.append("1" + "9" + getPesel().charAt(0) + getPesel().charAt(1));

			StringBuilder monthOfBirth = new StringBuilder();
			monthOfBirth.append("" + getPesel().charAt(2) + getPesel().charAt(3));

			StringBuilder dayOfBirth = new StringBuilder();
			dayOfBirth.append("" + getPesel().charAt(4) + getPesel().charAt(5));

			String YearString = yearOfBirth.toString();
			String MonthString = monthOfBirth.toString();
			String DayString = dayOfBirth.toString();

			Integer Year = Integer.valueOf(YearString);
			Integer Month = Integer.valueOf(MonthString);
			Integer	Day = Integer.valueOf(DayString);

			return new GregorianCalendar(Year, Month, Day);
		}
		return null;
	}
	
	public int getAge(){
		Calendar today = new GregorianCalendar();
		int actualMonth = today.get(Calendar.MONTH);
		int actualYear = today.get(Calendar.YEAR);

		GregorianCalendar age = getDayOfBirth();
		int month = age.get(Calendar.MONTH);
		int year = age.get(Calendar.YEAR);

		if (actualMonth>month)
			 return actualYear - year;
		else return actualYear - year - 1;
	}


	public Gender getGender(){
		if (Character.getNumericValue(getPesel().charAt(9))%2 == 0){
			return Gender.Female;
		}
		else return Gender.Male;
	}

	public boolean checkPesel(){
		List<Integer> validatePesel = new ArrayList<Integer>();

		for(int i = 0; i<=10; i++){
			validatePesel.add(Character.getNumericValue(getPesel().charAt(i)));
		}

		int sumOfPesel = (validatePesel.get(0) + validatePesel.get(4) + validatePesel.get(8) + validatePesel.get(10))
				+ 3*(validatePesel.get(1) + validatePesel.get(5) + validatePesel.get(9))
				+ 7*(validatePesel.get(2) + validatePesel.get(6))
				+ 9*(validatePesel.get(3) + validatePesel.get(7));


		if (getPesel().length() == 11 && sumOfPesel%10 == 0) return true;
		else return false;
	}

	public enum Gender { Male, Female}
}