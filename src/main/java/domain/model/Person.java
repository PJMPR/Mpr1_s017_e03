package domain.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.*;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class Person {
	
	private String pesel ;

	public Person(String pesel){
		this.pesel=pesel;
	}
	
	public String getDayOfBirth() throws ParseException{

		StringBuilder sb = new StringBuilder();
		sb.append(pesel);
		char[] cDate= {sb.charAt(0),sb.charAt(1),sb.charAt(2),sb.charAt(3),sb.charAt(4),sb.charAt(5)};
		String dateFromPesel= String.valueOf(cDate);
		SimpleDateFormat dt = new SimpleDateFormat("yyMMdd");
		Date date = dt.parse(dateFromPesel);

		dt.applyPattern("yy/MM/dd");
		String newDateString = dt.format(date);

		return newDateString;
	}
	
	public int getAge() throws ParseException{


		/* bez sensu */

		StringBuilder sb = new StringBuilder();
		sb.append(pesel);
		char[] cDate= {sb.charAt(0),sb.charAt(1),sb.charAt(2),sb.charAt(3),sb.charAt(4),sb.charAt(5)};
		String dateFromPesel= String.valueOf(cDate);
		SimpleDateFormat dt = new SimpleDateFormat("yyMMdd");
		Date date = dt.parse(dateFromPesel);

		/* aż dotąd */


		Calendar b = Calendar.getInstance();
		b.getTime();
		Calendar a = Calendar.getInstance();
		a.setTime(date);

			int diff = b.get(YEAR) - a.get(YEAR);
			if (a.get(MONTH) > b.get(MONTH) ||
					(a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
				diff--;
			}
			return diff;

	}


	
	public boolean checkPesel(){
		int summedPesel;

		StringBuilder sb = new StringBuilder();
		sb.append(pesel);

		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<11;i++) {
			list.add(Integer.parseInt(String.valueOf(sb.charAt(i))));
		}

		summedPesel= list.get(0) +3*list.get(1)+7*list.get(2)+9*list.get(3)+
				1*list.get(4)+3*list.get(5)+7*list.get(6)+9*list.get(7)+1*list.get(8)+3*list.get(9);

		if((10-summedPesel%10)==list.get(10) ){return true;}
		else {return false;}
	}

	public boolean checkPeselLength(){
		if (pesel.length()==11){return true;}
		else {return false;}
	}

	public enum Gender{
	Male,
	Female;

	}

	public Gender getGender(){
	if((Integer.parseInt(String.valueOf(pesel.charAt(10))))%2==0){return Gender.Female;}
	else {return Gender.Male;}
	}
 }
