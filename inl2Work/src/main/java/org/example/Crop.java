package org.example;

public class Crop extends Entity{

    private String cropType;
    private int quantity;

    @Override
    public String GetDescription() {

        return getId()+","+name+","+cropType+","+quantity;
    }

    public Crop(int id, String name, String cropType, int quantity) {
        super(id, name);
        this.cropType = cropType;
        this.quantity = quantity;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
