package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "alien_table")
public class Alien {
    @Id
    private int id;
    @Column(name = "alien_name ")
    private String name;
    private int tech;

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name=" + name +
                ", tech=" + tech +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTech() {
        return tech;
    }

    public void setTech(int tech) {
        this.tech = tech;
    }
}
