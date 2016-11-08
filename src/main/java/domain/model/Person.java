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
            StringBuilder yearOfBirth = new StringBuilder();
            String sYear = yearOfBirth.append("2" + "0" + getPesel().charAt(0) + getPesel().charAt(1)).toString();


            StringBuilder monthOfBirth = new StringBuilder();
            String sMonth = monthOfBirth.append("" + Character.getNumericValue(getPesel().charAt(2)-2) + getPesel().charAt(3)).toString();



            return new GregorianCalendar(Integer.valueOf(sYear),Integer.valueOf(sMonth), dayOfBirth());

        }
        else if (Character.getNumericValue(getPesel().charAt(2)) <= 1)
        {
            StringBuilder yearOfBirth = new StringBuilder();
            String sYear = yearOfBirth.append("1" + "9" + getPesel().charAt(0) + getPesel().charAt(1)).toString();

            StringBuilder monthOfBirth = new StringBuilder();
            String sMonth = monthOfBirth.append("" + getPesel().charAt(2) +  getPesel().charAt(3)).toString();




            return new GregorianCalendar(Integer.valueOf(sYear),Integer.valueOf(sMonth),dayOfBirth());
        }

        return null;

    }

    private int dayOfBirth(){
        StringBuilder dayOfBirth = new StringBuilder();
        String sDay = dayOfBirth.append("" + getPesel().charAt(4) + getPesel().charAt(5)).toString();
        return  Integer.valueOf(sDay);
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

