package org.example.creational_pattern.builder_pattern.demo;

public class Car {
    // Các thuộc tính
    private final String brand;      // bắt buộc
    private final String model;      // bắt buộc
    private final int seats;         // tùy chọn
    private final String color;      // tùy chọn
    private final boolean sunroof;   // tùy chọn

    // Constructor private, chỉ dùng cho Builder
    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.seats = builder.seats;
        this.color = builder.color;
        this.sunroof = builder.sunroof;
    }

    // Getter
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    public boolean hasSunroof() {
        return sunroof;
    }

    // Static inner class Builder
    public static class Builder {
        private final String brand;
        private final String model;
        private int seats = 4;           // default
        private String color = "Black";  // default
        private boolean sunroof = false; // default

        // Constructor bắt buộc thông tin tối thiểu
        public Builder(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public Builder seats(int seats) {
            this.seats = seats;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder sunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    // Hiển thị thông tin xe
    @Override
    public String toString() {
        return String.format("Car: %s %s, seats: %d, color: %s, sunroof: %b", brand, model, seats, color, sunroof);
    }
}