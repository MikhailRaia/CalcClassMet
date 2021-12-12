import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {

        CalculatorMath calk = new CalculatorMath();
        //calk.showChar();
        if (calk.findSign(calk.inputStr)[1]==0) {
            System.out.print("Отсутствует мат. знак + - / * ");
        }
        RimArab rimArab = new RimArab();
        rimArab.showChar();


    }

}

class CalculatorMath {

        Scanner sc = new Scanner(System.in);

        String inputStr = sc.nextLine();

        char [] inputChar = new char[inputStr.length()];
        //String [] inputChar = new String[inputStr.length()];

    // Перевод строки в char возврат массива Char
     public char [] convertToChar (String inputString) {

        for (int i = 0; i < inputStr.length(); i++) {
           //inputChar = inputStr.split("");
            inputChar [i] = inputStr.charAt(i);
        }
        return inputChar;
    }


    // Поиск знака и возврат его положения и факт знака
    public int[] findSign (String inputString) {
            int [] sign = new int[2];
            char[] znak = {'+','-','/','*'};
            for (int i = 0; i < znak.length; i++) {
                for (int j = 1; j < convertToChar(inputStr).length; j++) {
                    if (znak [i] == convertToChar(inputStr)[j]) {
                        sign [0] = i; // z - сам знак +-/*
                        sign [1] = j; // l - порядок знака
                    }
                }
            }
    return sign;
    }
    // Возврат подстрок
    public String [] substrings (String inputString) {
        String [] subString = new String[2];
         subString [0] = inputStr.substring(0,findSign(inputString)[1]);
         subString [1] = inputStr.substring((findSign(inputString)[1]+1), inputString.length());
        return subString;
    }

     /*public void showChar () {
        for (int i =0; i<substrings(inputStr).length; i++) {
            System.out.println(substrings(inputStr)[i]);
        }
    }*/
}

// проверить класс тк возвращает неправильные значения
class RimArab {


    String rimskie1 ="I,II,III,IV,V,VI,VII,VIII,IX,X";
    String [] rimskie1Split = rimskie1.split(",");


    public int [] rimskie ( String [] substrings) {

        int rimsk [] = new int[2];

        CalculatorMath calc = new CalculatorMath();
        String s1 = calc.substrings(calc.inputStr)[0];
        String s2 = calc.substrings(calc.inputStr)[1];
        //String rimskie2 ="X,XX,XXX,XL,L,LX,LXX,LXXX,XC,C";
        //String [] rimskie2Split = rimskie2.split(",");

        for (int i = 0; i < rimskie1Split.length; i++) {
            for (int j = 0; j < rimskie1Split.length; j++) {
                if ((s1.equals(rimskie1Split[i])) & (s2.equals(rimskie1Split[i]))) {
                    rimsk [0]= i;
                    rimsk [1] = j;
                }
            }
        }
        return rimsk;

    }
         public void showChar () {
             CalculatorMath cal = new CalculatorMath();

            for (int i =0; i<rimskie(cal.substrings(cal.inputStr)).length; i++) {
                System.out.println(rimskie(cal.substrings(cal.inputStr))[i]);
            }
        }
}
