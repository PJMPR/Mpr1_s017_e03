package domain.model;

import java.util.Date;
import java.util.*;

public class Person {
	
	private String pesel ;

	public Person(String pesel){
		this.pesel=pesel;
	}
	
	//public Date getDayOfBirth(){}
	
	//public int getAge(){}


	
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
