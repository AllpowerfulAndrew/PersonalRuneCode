public class PersonalRuneCounting {

    final String[][] runes = {{"Fehu (Феу)", "Uruz (Уруз)", "Turisaz (Турисаз)", "Ansuz (Ансуз)", "Raidu (Райдо)", "Kauna (Кано)", "Gebu (Гебо)", "Wunju (Вуньо)"},
            {"Hagalaz (Хагалаз)", "Naudiz (Наутиз)", "Isaz (Иса)", "Jara (Йер)", "Iwaz (Эйваз)", "Pertu (Перт)", "Algiz (Альгиз)", "Sowilu (Соулу)"},
            {"Tiwaz (Тейваз)", "Berkana (Беркана)", "Ehwaz (Эваз)", "Mannaz (Манназ)", "Laguz (Лагуз)", "Inwaz (Ингуз)", "Otila (Отал)", "Dagaz (Дагаз)"}};

    NumberOfBirthDay numberOfBirthDay = new NumberOfBirthDay();
    NumberOfFullName numberOfFullName = new NumberOfFullName();

    public void calculating() {

        String natureRune = natureRuneCounting();
        String personRune = personsRuneCounting();
        String goldRune = goldRuneCounting();
        System.out.println();
        System.out.println("Ваши руны:");
        System.out.println("=============================");

        if (natureRune != null) {
            System.out.println("Руна Сущности: " + natureRune);
        } else {
            System.out.println("Руна Сущности: отсутствует");
        }

        if (personRune != null) {
            System.out.println("Руна Личности: " + personRune);
        } else {
            System.out.println("Руна Личности: отсутствует");
        }

        if (goldRune != null) {
            System.out.println("Золотая Руна: " + goldRune);
        } else {
            System.out.println("Золотая Руна: отсутствует");
        }
    }

    public String natureRuneCounting() {

        int numberOfRuneGroup = numberOfBirthDay.numberOfPerson();
        int numberOfRuneAtt = att(numberOfBirthDay.numberOfDay(), numberOfBirthDay.numberOfMonth(), numberOfBirthDay.numberOfYear(), numberOfRuneGroup);
        String natureRune = null;

        if (numberOfRuneGroup < 9) {
            natureRune = runes[numberOfRuneAtt - 1][numberOfRuneGroup - 1];
        }

        return natureRune;
    }

    public String personsRuneCounting() {

        int numberOfRuneGroup = numberOfFullName.numberOfFullName();
        int numberOfRuneAtt = att(numberOfFullName.numberOfFamily(), numberOfFullName.numberOfName(), numberOfFullName.numberOfMiddleName(), numberOfRuneGroup);
        String personRune = null;

        if (numberOfRuneGroup < 9) {
            personRune = runes[numberOfRuneAtt - 1][numberOfRuneGroup - 1];
        }

        return personRune;
    }

    public String goldRuneCounting() {

        int numberOfRuneGroup = numberOfBirthDay.numberOfPerson() + numberOfFullName.numberOfFullName();

        while (numberOfRuneGroup > 9) {
            String str = Integer.toString(numberOfRuneGroup);
            char[] chr = str.toCharArray();
            numberOfRuneGroup = 0;
            for (char aChr : chr) {
                numberOfRuneGroup = numberOfRuneGroup + Character.getNumericValue(aChr);
            }
        }

        int numberOfRuneAtt = att((numberOfFullName.numberOfName()+ numberOfBirthDay.numberOfDay()), (numberOfFullName.numberOfMiddleName()+ numberOfBirthDay.numberOfMonth()), (numberOfFullName.numberOfFamily()+ numberOfBirthDay.numberOfYear()), numberOfRuneGroup);
        String goldRune = null;

        if (numberOfRuneGroup < 9) {
            goldRune = runes[numberOfRuneAtt - 1][numberOfRuneGroup - 1];
        }

        return goldRune;
    }

    public int att(final int firstNum, final int secondNum, final int thirdNum, final int lastNum) {

        int att;
        int[] number = {firstNum, secondNum, thirdNum, lastNum};

        for (int i = 0; i < number.length; i++) {
            int n = number[i];
            while (n > 9) {
                String str = Integer.toString(n);
                char[] chr = str.toCharArray();
                n = 0;

                for (char aChr : chr) {
                    n = n + Character.getNumericValue(aChr);
                }

                number[i] = n;
            }
        }

        for (int n=0; n < number.length; n++) {
            if (number[n] == 1 || number[n] == 4 || number[n] == 7) {
                number[n] = 1;
            } else if (number[n] == 2 || number[n] == 5 || number[n] == 8) {
                number[n] = 2;
            } else if (number[n] == 3 || number[n] == 6 || number[n] == 9) {
                number[n] = 3;
            }
        }

        if (number[0] != number[1] && number[1] != number[2] && number[2] != number[0]){
            att = number[3];
        } else if (number[0] == number[1] || number[0] == number[2]) {
            att = number[0];
        } else if (number[1] == number[0] || number[1] == number[2]) {
            att = number[1];
        } else {
            att = number[2];
        }

        return att;
    }
}
