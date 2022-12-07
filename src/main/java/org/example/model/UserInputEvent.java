package org.example.model;

import java.util.Scanner;

public class UserInputEvent {
        int day, month;

        public void takeInput() {
            Scanner userInputDay=new Scanner(System.in);
            System.out.println("Please type what day is today");
            day = userInputDay.nextInt();
            Scanner userInputMonth = new Scanner(System.in);
            System.out.println("Please type what month is today");
            month = userInputMonth.nextInt();
        }

    }

