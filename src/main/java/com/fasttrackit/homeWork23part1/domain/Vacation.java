package com.fasttrackit.homeWork23part1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Vacation {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private  int id;
    private  String location;
    private  int price;
    private  int duration;


    public Vacation(){
    }
    public Vacation(String location, int price, int duration) {
        this.location = location;
        this.price = price;
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return id == vacation.id &&
                price == vacation.price &&
                duration == vacation.duration &&
                Objects.equals(location, vacation.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, price, duration);
    }
}


