package org.example;

public class Animal extends Entity{

    private String species;

    @Override
    public String GetDescription() {

        return getId()+","+name+","+species;
    }


    public Animal(int id, String name, String species) {
        super(id, name);
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
