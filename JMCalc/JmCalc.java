package JMCalc;

import java.util.Scanner;


public class JmCalc {


    public static int abc;
    int cba;

    public static void main(String[] args) {
        int value1 = 0;
        int value2 = 0;
        int result = 0; //переменная сумма для switch(или цикла)
        CalcType calcType = CalcType.NONE;

        String input;
        String operation;
        System.out.println("Input your numbers: ");
        Scanner scanner = new Scanner(System.in);

        input = scanner.next(); //начало программы, при вводе запускается сканер
        try                     // и пытается считывать число
        {
            value1 = parseArabic(input);

            calcType = CalcType.ARABIC;   //если это арабские цифры, ява запоминает их тип
        } catch (Exception ex) {
            try {
                value1 = parseRome(input);
                calcType = CalcType.ROME; // если римская, то запоминает что оно римское
            } catch (Exception ex2) {
                System.out.println("ERROR!");
                return;
            }
        }
//2+3
        operation = scanner.next();
        input = scanner.next();

        try {
            if (calcType == CalcType.ARABIC) value2 = parseArabic(input);//если запомнили что это арабское число,
            else value2 = parseRome(input); // и мы не смогли считать что это арабское число,т.е это может быть римское
        }    //соответсвенно для нас это ошибка, должно быть только арабское, если это не арабское число, то мы пытаемся
        // считать римское, число, значит арабское для нас неподходит.


        catch (Exception ex) {
            System.out.println("ERROR!"); // и если до этого  не найден тип пишем ошибку
            return; // и выходим
        }

        if (checkOutOfBounce(value1) || checkOutOfBounce(value2)){
            System.out.println("ERROR!");
            return;
        }

        switch (operation) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                result = value1 / value2;
                break;
            default:  // это обработка всех остальных случаев(здесь, как исключение)
                System.out.println("ERROR!");
                return;                           //останавливаем программу при ошибке
        }
        if (calcType == CalcType.ARABIC)
            System.out.println(result); //после того как мы вычислили значения и это было неошибка,
        else System.out.println(printRome(result)); // а этот вывод если это было не арабское, число,а римское
        //и  мы уже выводим результат
    }

    static int parseArabic(String val) {
        return Integer.parseInt(val);
    }

    static boolean checkOutOfBounce(int number) {
        return number <= 0 && number >= 10;
    }

    static int parseRome(String val) {
        return RomanConverter.romanToDecimal(val); //для инта возвращаем 0, поправилам //вкрутили метод из рим в арабик
    }

    static String printRome(int value) {
        return RomanConverter.IntegerToRomanNumeral(value);  //для римских чисел пустое поле
    }

    public enum CalcType {
        NONE, ARABIC, ROME //NONE -ЗНАЧЕНИЕ НЕ ОПРЕДЕЛНО
    }
}
