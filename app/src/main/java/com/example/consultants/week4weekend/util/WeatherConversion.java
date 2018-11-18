package com.example.consultants.week4weekend.util;

public class WeatherConversion {

    public static double kelvinToF(double k) {
        //converts kelvin temperature to fahrenheit
        return (k - 273.15) * (9/5) + 32;
    }

    public static double kelvinToC(double k) {
        //converts kelvin temperature to celsius
        return (k - 273.15);
    }
}
