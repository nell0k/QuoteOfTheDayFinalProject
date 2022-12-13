package org.example.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputEvent {
    int day, month;

    public void takeInput(IntegerAsker asker)  {
        //Scanner userInputDay=new Scanner(System.in);
        System.out.println("Please type what day is today");
        day = asker.ask("type number between 1 to 31");
        if (day>31 || day <1 ) throw  new InputMismatchException();
        Scanner userInputMonth = new Scanner(System.in);
        System.out.println("Please type what month is today");
        month = asker.ask("type number between 1 to 12");
        if (month>12 || month <1 ) throw  new InputMismatchException();

    }

}

