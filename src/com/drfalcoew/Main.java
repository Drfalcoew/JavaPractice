package com.drfalcoew;

import java.util.Scanner;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!\n");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        float interest = scanner.nextFloat();
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();

        double mortgage = getMortgage(principal, interest, years);

        System.out.println(formatNumber(mortgage));


    }

    private static double getMortgage(int principal, float interest, byte years) {
        float monthlyInterest = interest / 100 / 12;
        double top = monthlyInterest * Math.pow(1+monthlyInterest, years*12);
        double bottom = Math.pow(1+monthlyInterest, years*12) - 1;
        double mortgage = principal * (top/bottom);
        return mortgage;
    }

    private static String formatNumber(double number) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(number);
        return result;
    }
}
