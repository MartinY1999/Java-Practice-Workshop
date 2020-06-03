package com.rational;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational(){

    }

    public Rational(int numerator, int denominator){
        if (denominator < 0){
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        fixNumbers();
    }

    public Rational(Rational other){
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    private void fixNumbers(){
        int gcd = findGCD(this.numerator, this.denominator);
        this.denominator /= gcd;
        this.numerator /= gcd;
    }

    private static int findGCD(int number1, int number2) {
        if(number2 == 0)
            return number1;

        return findGCD(number2, number1%number2);
    }

    private static int findLCM(int a, int b)
    {
        return (a * b)/findGCD(a, b);
    }

    public void adding(Rational other){
        int denominatorLCM = findLCM(this.denominator, other.denominator);
        int numerator = this.numerator * (denominatorLCM / this.denominator) +
                other.numerator * (denominatorLCM / other.denominator);

        this.numerator = numerator;
        this.denominator = denominatorLCM;
    }

    public void subtract(Rational other){
        int denominatorLCM = findLCM(this.denominator, other.denominator);
        int numerator = this.numerator * (denominatorLCM / this.denominator) -
                other.numerator * (denominatorLCM / other.denominator);

        this.numerator = numerator;
        this.denominator = denominatorLCM;
    }

    public void multiply(Rational other){
        int denominatorLCM = findLCM(this.denominator, other.denominator);
        int numerator = this.numerator * (denominatorLCM / this.denominator) *
                other.numerator * (denominatorLCM / other.denominator);

        this.numerator = numerator;
        this.denominator = denominatorLCM;
    }

    public void divide(Rational other){
        int denominatorLCM = findLCM(this.denominator, other.denominator);
        int numerator = this.numerator * (denominatorLCM / this.denominator) /
                other.numerator * (denominatorLCM / other.denominator);

        this.numerator = numerator;
        this.denominator = denominatorLCM;
    }

    @Override
    public String toString() {
        fixNumbers();
        return this.numerator +
                " / " + this.denominator;
    }
}
