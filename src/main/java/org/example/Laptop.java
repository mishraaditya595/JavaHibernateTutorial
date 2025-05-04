package org.example;

import jakarta.persistence.Embeddable;

@Embeddable
/*
The class marked with @Embeddable doesn't get its own database table
Its fields are included in the table of the entity that embeds it. eg(Alien entity)
Alien table will look like this:
id | name | tech | brand | model | ram
 */
public class Laptop {
    private String brand;
    private String model;
    private int ram;

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
