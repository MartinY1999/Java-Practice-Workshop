package com.company;

import java.util.Scanner;
import java.util.function.Consumer;

public class ComputeByMenu {
    private double x;
    private Scanner reader = new Scanner(System.in);

    public ComputeByMenu(){
        setX(0);
    }

    public ComputeByMenu(double x){
        setX(x);
    }

    public double getX(){
        return this.x;
    }

    public void setX(double x){
        this.x = x;
    }

    public void displayMenu(){
        StringBuilder builder = new StringBuilder();

        builder.append("\n");
        builder.append("\n");
        builder.append("1. Update the floating point number \n");
        builder.append("2. Compute and display exp(x) \n");
        builder.append("3. Compute and display sin(x) \n");
        builder.append("4. Compute and display floor(x) \n");
        builder.append("5. Exit");
        builder.append("\n");
        builder.append("\n");

        System.out.println(builder.toString());
    }

    public void getUserChoice(){
        displayMenu();
        int option = receiveValidOption();
        doSelection(option);
    }

    private int receiveValidOption(){
        boolean validOption = false;
        int option = -1;
        while (!validOption){
            option = reader.nextInt();
            if (option >= 1 && option <= 5)
                validOption = true;
            else
                System.out.println("Invalid command! Try again.");
        }

        return option;
    }

    public void doSelection(int option){
        if (option == 5)
            exitProgram();
        else {
            if (option == 1)
                updateX();
            if (option == 2)
                computeAndDisplayExp();
            if (option == 3)
                computeAndDisplaySin();
            if (option == 4)
                computeAndDisplayFloor();

            getUserChoice();
        }
    }

    private void updateX(){
        double newValue = reader.nextDouble();
        setX(newValue);
    }

    private void computeAndDisplayExp(){
        double expResult = Math.exp(getX());
        System.out.printf("Result of exp(x) is: %f", expResult);
    }

    private void computeAndDisplaySin(){
        double sinResult = Math.sin(getX());
        System.out.printf("Result of sin(x) is: %f", sinResult);
    }

    private void computeAndDisplayFloor(){
        double floorResult = Math.floor(getX());
        System.out.printf("Result of floor(x) is: %f", floorResult);
    }

    private void exitProgram(){
        System.out.print("App is closing!");
    }

}
