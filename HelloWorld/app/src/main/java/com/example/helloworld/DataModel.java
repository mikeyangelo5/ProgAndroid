package com.example.helloworld;

public class DataModel {
    int Images;
    String Title, Year;

    public DataModel(int images, String title, String year) {
        this.Images = images;
        this.Title = title;
        this.Year = year;
    }

    public int getImages() {
        return Images;
    }

    public void setImages(int images) {
        this.Images = images;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        this.Year = year;
    }
}
