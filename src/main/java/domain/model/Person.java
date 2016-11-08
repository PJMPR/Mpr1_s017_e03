package domain.model;


import java.util.*;

public class Person {

	private String pesel;
	public enum Gender{
		Male, Female
	}

    public Person(){

    }

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public GregorianCalendar getDayOfBirth(){


        if(Character.getNumericValue(getPesel().charAt(2)) > 1  && Character.getNumericValue(getPesel().charAt(2)) < 5 ) {
            String yearOfBirth = ("2" + "0" + getPesel().charAt(0) + getPesel().charAt(1));

            String monthOfBirth = ("" + Character.getNumericValue(getPesel().charAt(2)-2) + getPesel().charAt(3));



            return new GregorianCalendar(Integer.valueOf(yearOfBirth),Integer.valueOf(monthOfBirth),dayOfBirth());

        }
        else if (Character.getNumericValue(getPesel().charAt(2)) <= 1)
        {
            String yearOfBirth = ("1" + "9" + getPesel().charAt(0) + getPesel().charAt(1));

            String monthOfBirth = ("" + getPesel().charAt(2) +  getPesel().charAt(3));



            return new GregorianCalendar(Integer.valueOf(yearOfBirth),Integer.valueOf(monthOfBirth),dayOfBirth());
        }

        return null;

    }

    private int dayOfBirth(){
        String dayOfBirth =("" + getPesel().charAt(4) + getPesel().charAt(5));
        return  Integer.valueOf(dayOfBirth);
    }

	public int getAge(){
        Calendar now = new GregorianCalendar();
        int currentYear = now.get(Calendar.YEAR);
        int currentMonth = now.get(Calendar.MONTH);
        GregorianCalendar BirthYear = getDayOfBirth();
        int birthYear = BirthYear.get(Calendar.YEAR);
        int birthMonth= BirthYear.get(Calendar.MONTH);


            if (birthMonth > currentMonth) {
                return (currentYear - birthYear)-1;
            }
            else {
                return currentYear - birthYear;
            }

        }


	public Gender getGender(){
        if (Character.getNumericValue(getPesel().charAt(9))%2 == 1 ){
            return Gender.Male;
        }
        else {
            return Gender.Female;
        }
	}

    private int validatePesel(){
        List<Integer> peselValidator = new ArrayList<Integer>();
        peselValidator.add(1);
        peselValidator.add(3);
        peselValidator.add(7);
        peselValidator.add(9);

        int verify = 0;

        for (int k = 0; k <= 9; k++) {
            verify = (verify + Character.getNumericValue(getPesel().charAt(k)) * peselValidator.get(k % 4)) % 10;
        }

        return  (10-verify) % 10;

    }
	public boolean checkPesel() {
        return (getPesel().length() == 11 && Character.getNumericValue(getPesel().charAt(10)) == validatePesel());
    }


}

