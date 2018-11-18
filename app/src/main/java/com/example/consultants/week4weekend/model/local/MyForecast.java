package com.example.consultants.week4weekend.model.local;

public class MyForecast {
    private String day;
    private String tenCond;
    private String tenTemp;
    private String oneCond;
    private String oneTemp;
    private String fourCond;
    private String fourTemp;
    private String sevenCond;
    private String sevenTemp;

    public MyForecast(String day, String tenCond, String tenTemp, String oneCond, String oneTemp,
                      String fourCond, String fourTemp, String sevenCond, String sevenTemp) {
        this.day = day;
        this.tenCond = tenCond;
        this.tenTemp = tenTemp;
        this.oneCond = oneCond;
        this.oneTemp = oneTemp;
        this.fourCond = fourCond;
        this.fourTemp = fourTemp;
        this.sevenCond = sevenCond;
        this.sevenTemp = sevenTemp;
    }

    public String getDay() {
        return day;
    }

    public String getTenCond() {
        return tenCond;
    }

    public String getTenTemp() {
        return tenTemp;
    }

    public String getOneCond() {
        return oneCond;
    }

    public String getOneTemp() {
        return oneTemp;
    }

    public String getFourCond() {
        return fourCond;
    }

    public String getFourTemp() {
        return fourTemp;
    }

    public String getSevenCond() {
        return sevenCond;
    }

    public String getSevenTemp() {
        return sevenTemp;
    }

    @Override
    public String toString() {
        return "MyForecast{" +
                "day='" + day + '\'' +
                ", tenCond='" + tenCond + '\'' +
                ", tenTemp='" + tenTemp + '\'' +
                ", oneCond='" + oneCond + '\'' +
                ", oneTemp='" + oneTemp + '\'' +
                ", fourCond='" + fourCond + '\'' +
                ", fourTemp='" + fourTemp + '\'' +
                ", sevenCond='" + sevenCond + '\'' +
                ", sevenTemp='" + sevenTemp + '\'' +
                '}';
    }
}
