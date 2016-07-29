import java.util.Scanner;

public class NumberOfFullName {

    private String name;
    private String middleName;
    private String family;
    private final static String alphabet = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщъЫыьЭэЮюЯя -";

    NumberOfFullName() {

        System.out.println();
        setFullName();
    }

    public int calculatingNumberOfWord(final String word) {

        int number = 0;
        String one = "АаИиСсъ";
        String two = "БбЙйТтЫы";
        String three = "ВвКкУуь";
        String four = "ГгЛлФфЭэ";
        String five = "МмДдХхЮю";
        String six = "ЕеНнЦцЯя";
        String seven = "ЁёОоЧч";
        String eight = "ЖжПпШш";
        String nine = "ЗзРрЩщ";

        char[] chr = word.toCharArray();

        for (char a : chr) {
            String c = "" + a;
            if (one.contains(c)) {
                number++;
            } else if (two.contains(c)) {
                number = number + 2;
            } else if (three.contains(c)) {
                number = number + 3;
            } else if (four.contains(c)) {
                number = number + 4;
            } else if (five.contains(c)) {
                number = number + 5;
            } else if (six.contains(c)) {
                number = number + 6;
            } else if (seven.contains(c)) {
                number = number + 7;
            } else if (eight.contains(c)) {
                number = number + 8;
            } else if (nine.contains(c)) {
                number = number + 9;
            }
        }

        return number;
    }

    public void setFullName() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО: (Например: Иванов Иван Иванович)");
        boolean isNameIsTrue = false;

        do {
            String fullName = scanner.nextLine();

            if (checkFullName(fullName)) {
                isNameIsTrue = true;
                String family = "";
                String name = "";
                char[] fullNameChar = fullName.toCharArray();

                for (char i : fullNameChar) {
                    if (i != ' ') {
                        family = family + i;
                    } else {
                        this.family = family;
                        break;
                    }
                }

                StringBuffer buffer = new StringBuffer(fullName);
                buffer.delete(0, family.length() + 1);
                fullName = buffer.toString();
                fullNameChar = fullName.toCharArray();

                for (char i : fullNameChar) {
                    if (i != ' ') {
                        name = name + i;
                    } else {
                        this.name = name;
                        break;
                    }
                }

                buffer.delete(0, name.length() + 1);
                this.middleName = buffer.toString();
            } else {
                System.out.println("ФИО введены неправильно! Попробуйте ещё раз.");
            }
        } while (!isNameIsTrue);
    }

    public boolean checkFullName(final String fullName) {

        char[] fullNameChars = fullName.toCharArray();

        for (char i : fullNameChars) {
            String s = String.valueOf(i);
            if (!alphabet.contains(s)) {
                return false;
            }
        }

        return true;
    }

    public int numberOfFullName() {

        int number = calculatingNumberOfWord(name) + calculatingNumberOfWord(family) + calculatingNumberOfWord(middleName);

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

    public int numberOfName() {

        int number = calculatingNumberOfWord(name);

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

    public int numberOfMiddleName() {

        int number = calculatingNumberOfWord(middleName);

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

    public int numberOfFamily() {

        int number = calculatingNumberOfWord(family);

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