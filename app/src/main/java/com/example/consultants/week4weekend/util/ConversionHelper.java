package com.example.consultants.week4weekend.util;

import com.example.consultants.week4weekend.model.forecastdata.ForecastResponse;
import com.example.consultants.week4weekend.model.local.MyForecast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConversionHelper {

    public static double kelvinToF(double k) {
        //converts kelvin temperature to fahrenheit
        return (k - 273.15) * (9 / 5) + 32;
    }

    public static double kelvinToC(double k) {
        //converts kelvin temperature to celsius
        return (k - 273.15);
    }

    private static int getHour(int dateUnix) {
        Date date = new Date(dateUnix * 1000L);
        SimpleDateFormat hourF = new SimpleDateFormat("H");
        return Integer.parseInt(hourF.format(date));
    }

    private static String getDay(int dateUnix) {
        Date date = new Date(dateUnix * 1000L);
        SimpleDateFormat dayF = new SimpleDateFormat("EEEE, MMMM d");
        return dayF.format(date);
    }

    public static ArrayList<MyForecast> parseData(ForecastResponse fResponse) {
        ArrayList<MyForecast> forecastList = new ArrayList<>();

        String currDay = "";
        String tenCond = "";
        String tenTemp = "";
        String oneCond = "";
        String oneTemp = "";
        String fourCond = "";
        String fourTemp = "";
        String sevenCond = "";
        String sevenTemp = "";

        for (int i = 0; i < fResponse.getList().size(); i++) {

            //api gives date as unix timestamp
            int unixTime = fResponse.getList().get(i).getDt();

            //get day
            if (i == 0) { //set curr day when starting
                currDay = getDay(unixTime);
            } else if (!getDay(unixTime).equals(currDay)) {//if day changes
                //need to save record
                MyForecast myForecast = new MyForecast(currDay, tenCond, tenTemp,
                        oneCond, oneTemp, fourCond, fourTemp, sevenCond, sevenTemp);
                forecastList.add(myForecast);

                currDay = getDay(unixTime);
            }

            //set temp based on F or C preferences
            double tempDbl = kelvinToF(fResponse.getList().get(i).getMain().getTemp());
            int temp = (int) Math.round(tempDbl);

            //sorting info into 4 periods of time per day, to show in recyclerview
            switch (getHour(unixTime)) {
                case 10: //10AM
                    tenCond = fResponse.getList().get(i).getWeather().get(0).getMain();
                    tenTemp = Integer.toString(temp) + "°";
                    break;
                case 13: //1PM
                    oneCond = fResponse.getList().get(i).getWeather().get(0).getMain();
                    oneTemp = Integer.toString(temp) + "°";
                    break;
                case 16: //4PM
                    fourCond = fResponse.getList().get(i).getWeather().get(0).getMain();
                    fourTemp = Integer.toString(temp) + "°";
                    break;
                case 19: //7PM
                    sevenCond = fResponse.getList().get(i).getWeather().get(0).getMain();
                    sevenTemp = Integer.toString(temp) + "°";
                    break;
            }
        }
        //save in last record once loop is done
        MyForecast myForecast = new MyForecast(currDay, tenCond, tenTemp,
                oneCond, oneTemp, fourCond, fourTemp, sevenCond, sevenTemp);
        forecastList.add(myForecast);

        return forecastList;
    }
}
