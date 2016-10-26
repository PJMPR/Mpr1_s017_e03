package domain.model;

import java.util.*;

public class Person {

	private String pesel;
	private int age;
	private Date DayOfBirth;
	public enum Gender{
		Male, Female
	}

    public Person(){
    String pesel;
    }

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Date getDayOfBirth(){

        return null;
    }

	public int getAge(){
        return 20;


	}

	public Gender getGender(){
        if (getPesel().charAt(10)%2 == 1 ){
            return Gender.Male;
        }
        else {
            return Gender.Female;
        }
	}

	public boolean checkPesel(){
        List<Integer> peselValidator = new ArrayList();
        peselValidator.add(1);
        peselValidator.add(3);
        peselValidator.add(7);
        peselValidator.add(9);

        int verify  = 0;
        for(int k=1; k<11; k++){
            verify = getPesel().charAt(k) + getPesel().charAt(k)* peselValidator.get(k % 4) % 10;

        }



        if(getPesel().length() == 11 && (10 - verify)%10 == 0  ){
            return true;
        }
        else
            return false;
	}

}

