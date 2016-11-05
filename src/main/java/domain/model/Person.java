package domain.model;


import java.util.*;

public class Person {

	private String pesel;
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

	public GregorianCalendar getDayOfBirth(){


        if(Character.getNumericValue(getPesel().charAt(2)) > 1  && Character.getNumericValue(getPesel().charAt(2)) < 5 ) {
            StringBuilder yearOfBirth = new StringBuilder();
            yearOfBirth.append("2" + "0" + getPesel().charAt(0) + getPesel().charAt(1));
            String sYear = yearOfBirth.toString();
            Integer birthYear = Integer.valueOf(sYear);

            StringBuilder monthOfBirth = new StringBuilder();
            monthOfBirth.append("" + Character.getNumericValue(getPesel().charAt(2)-2) + getPesel().charAt(3));
            String sMonth = monthOfBirth.toString();
            Integer birthMonth = Integer.valueOf(sMonth);

            int birthDay = dayOfBirth();


            return new GregorianCalendar(birthYear,birthMonth, birthDay);

        }
        else if (Character.getNumericValue(getPesel().charAt(2)) <= 1)
        {
            StringBuilder yearOfBirth = new StringBuilder();
            yearOfBirth.append("1" + "9" + getPesel().charAt(0) + getPesel().charAt(1));
            String sYear = yearOfBirth.toString();
            Integer birthYear = Integer.valueOf(sYear);

            StringBuilder monthOfBirth = new StringBuilder();
            monthOfBirth.append("" + getPesel().charAt(2) +  getPesel().charAt(3));
            String sMonth = monthOfBirth.toString();
            Integer birthMonth = Integer.valueOf(sMonth);

            int birthDay = dayOfBirth();

            return new GregorianCalendar(birthYear,birthMonth,birthDay);
        }

        return null;

    }

    public int dayOfBirth(){
        StringBuilder dayOfBirth = new StringBuilder();
        dayOfBirth.append("" + getPesel().charAt(4) + getPesel().charAt(5));
        String sDay = dayOfBirth.toString();
        Integer birthDay = Integer.valueOf(sDay);

        return birthDay;
    }

	public int getAge(){
        Calendar now = new GregorianCalendar();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        GregorianCalendar BirthYear = getDayOfBirth();
        int birthYear = BirthYear.get(Calendar.YEAR);

        int birthMonth= BirthYear.get(Calendar.MONTH);


            if (birthMonth > month) {
                return (year - birthYear)-1;
            }
            else {
                return year - birthYear;
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

    public int validatePesel(){
        List<Integer> peselValidator = new ArrayList();
        peselValidator.add(1);
        peselValidator.add(3);
        peselValidator.add(7);
        peselValidator.add(9);

        int verify = 0;

        for (int k = 0; k <= 9; k++) {
            verify = (verify + Character.getNumericValue(getPesel().charAt(k)) * peselValidator.get(k % 4)) % 10;
        }

        int check = (10-verify) % 10;
        return check;
    }
	public boolean checkPesel(){
        if(getPesel().length() == 11 &&  Character.getNumericValue(getPesel().charAt(10)) == validatePesel()   ){
            return true;
        }
        else
            return false;
	}

}

