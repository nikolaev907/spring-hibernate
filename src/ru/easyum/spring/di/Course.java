package ru.easyum.spring.di;

public class Course {

    private String name;
    private int duration;

    public Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return name;
    }
}
