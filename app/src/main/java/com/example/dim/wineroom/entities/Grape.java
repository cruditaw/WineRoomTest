package com.example.dim.wineroom.entities;

public class Grape {

    private Integer id;
    private String grape_label;

    public Grape() {
    }

    public Grape(String grape_label) {
        this.grape_label = grape_label;
    }

    public Grape(Integer id, String grape_label) {
        this.id = id;
        this.grape_label = grape_label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrape_label() {
        return grape_label;
    }

    public void setGrape_label(String grape_label) {
        this.grape_label = grape_label;
    }

    @Override
    public String toString() {
        return "Grape{" +
                "id=" + id +
                ", grape_label='" + grape_label + '\'' +
                '}';
    }
}
