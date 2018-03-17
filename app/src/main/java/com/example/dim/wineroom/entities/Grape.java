package com.example.dim.wineroom.entities;

import java.io.Serializable;

public class Grape implements Serializable, Cloneable {

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


    @Override
    @SuppressWarnings("CloneDoesntCallSuperClone")
    public Grape clone() throws CloneNotSupportedException {
        Grape cl = new Grape();
        cl.setId(id);
        cl.setGrape_label(grape_label);
        return cl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grape grape = (Grape) o;

        if (id != null ? !id.equals(grape.id) : grape.id != null) return false;
        return grape_label.equals(grape.grape_label);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + grape_label.hashCode();
        return result;
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
