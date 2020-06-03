package com.savings;

import java.util.Random;

public class SavingsAccount {
    private static double mAnnualInterestRate;
    private double mSavingsBalance;
    private final String mNumber;
    private static int count = 0;

    private double interestRate;

    public SavingsAccount(){
        mAnnualInterestRate = 0;
        mNumber = generateUniqueNumber();
    }

    public SavingsAccount(double savingsBalance, double AIR){
        mSavingsBalance = savingsBalance;
        mAnnualInterestRate = AIR;
        mNumber = generateUniqueNumber();
        this.count++;
    }

    public SavingsAccount(SavingsAccount other){
        this.mSavingsBalance = other.mSavingsBalance;
        this.mNumber = other.mNumber;
    }

    public double getMSavingsBalance() {
        return mSavingsBalance;
    }

    public double getMAnnualInterestRate() {
        return mAnnualInterestRate;
    }

    public String getMNumber() {
        return mNumber;
    }

    public static int getCount() {
        return count;
    }

    public void setMSavingsBalance(double mSavingsBalance) {
        this.mSavingsBalance = mSavingsBalance;
    }

    private String generateUniqueNumber(){
        Random generator = new Random();

        return "#" + String.valueOf(generator.nextInt());
    }

    public void calculateMonthlyInterest(){
        this.interestRate = this.mSavingsBalance * this.mAnnualInterestRate / 12;
        this.mSavingsBalance += this.interestRate;
    }

    public void modifyInterestRate(double newAnnualInterestRate){
        this.mAnnualInterestRate = newAnnualInterestRate;
    }

    public boolean isGreater(SavingsAccount other){
        return this.mSavingsBalance > other.mSavingsBalance;
    }


    protected void finalize(){
        this.count--;
    }

    @Override
    public String toString() {
        return String.format("Balance: %f, InterestRate: %f",
                this.mSavingsBalance, this.interestRate);
    }
}
