import java.util.Scanner;

public class NumberOfBirthDay {

    private int day;
    private int month;
    private int year;
    private int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private char[] dateChars = new char[10];

    NumberOfBirthDay() {
        setBirthDay();
    }

    public void setBirthDay() {

        System.out.println("Введите дату рождения. (Например: 01.01.2000)");
        Scanner scanner = new Scanner(System.in);
        String strDate = scanner.nextLine();
        char[] chrDate = strDate.toCharArray();
        this.dateChars = chrDate;

        String date = new String(chrDate, 0, 2);
        setDay(Integer.parseInt(date));

        date = new String(chrDate, 3, 2);
        setMonth(Integer.parseInt(date));

        date = new String(chrDate, 6, 4);
        setYear(Integer.parseInt(date));
    }

    public int numberOfPerson() {

        int number = 0;

        for (int i = 0; i < dateChars.length; i++) {
            if (dateChars[i] != '.') {
                number = number + Character.getNumericValue(dateChars[i]);
            }
        }

        while (number > 9) {
            String str = Integer.toString(number);
            char[] chr = str.toCharArray();
            number = 0;
            for (int i = 0; i < chr.length; i++) {
                number = number + Character.getNumericValue(chr[i]);
            }
        }

        return number;
    }

    public void setDay(int day) {

        if (day > 0 && day < 31) {
            this.day = day;
        }
    }

    public void setMonth(int month) {

        if (month > 0 && month < 13) {
            this.month = month;
        } else {
            System.out.println("Неправильный месяц!");
        }
    }

    public void setYear(int year) {

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            months[2] = 29;
        } else {
            months[2] = 28;
        }

        if (month == 2 && day <= months[2] && day > 0 || day < 32 && day > 0 && month != 2) {
            this.year = year;
        } else {
            System.out.println("Не правильная дата рождения.");
        }
    }

    public int numberOfDay() {

        int number = this.day;

        while (number > 9) {

            String str = Integer.toString(number);
            char[] chr = str.toCharArray();
            number = 0;

            for (int i = 0; i < chr.length; i++) {
                number = number + Character.getNumericValue(chr[i]);
            }
        }

        return number;
    }

    public int numberOfMonth() {
        int number = this.month;

        while (number > 9) {

            String str = Integer.toString(number);
            char[] chr = str.toCharArray();
            number = 0;

            for (int i = 0; i < chr.length; i++) {
                number = number + Character.getNumericValue(chr[i]);
            }
        }

        return number;
    }

    public int numberOfYear() {

        int number = this.year;

        while (number > 9) {

            String str = Integer.toString(number);
            char[] chr = str.toCharArray();
            number = 0;

            for (int i = 0; i < chr.length; i++) {
                number = number + Character.getNumericValue(chr[i]);
            }
        }

        return number;
    }
}