package com.olegis.p0541_customadapter;

public class Product {
    String name;
    int price;
    int image;
    boolean box;

    public Product(String _describe, int _price, int _image, boolean _box) {
        this.name = _describe;
        this.price = _price;
        this.image = _image;
        this.box = _box;
    }
}
