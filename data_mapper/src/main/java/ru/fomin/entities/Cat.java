package ru.fomin.entities;

public class Cat {

    private Long id;
    private String name;
    private Integer weight;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("id: %d, name %s, weight: %d\n", id, name, weight);
    }
}
