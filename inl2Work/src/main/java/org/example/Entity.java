package org.example;

public class Entity {

        private int id;
        protected String name;

        public String GetDescription() {

            return "This entity has id "+id+" and it's name is "+name;
        }

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
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
}
