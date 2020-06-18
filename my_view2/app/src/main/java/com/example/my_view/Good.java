package com.example.my_view;

class Good {
    private int id;
    private String name;
    private boolean isChecked;
    private int price;

    public Good(int id, String name, boolean isChecked, int price) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCheck() {
        return isChecked;
    }

    public int getPrice() { return price; }

    public void setCheck(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id) + " - " + this.name + " " + String.valueOf(this.price);
    }
}
