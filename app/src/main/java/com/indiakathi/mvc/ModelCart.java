package com.indiakathi.mvc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mohit on 04-04-2016.
 */
public class ModelCart{

    private ArrayList<ModelProducts> cartProducts = new ArrayList<ModelProducts>();


    public ModelProducts getProducts(int pPosition) {

        return cartProducts.get(pPosition);
    }

    public void setProducts(ModelProducts Products) {

        cartProducts.add(Products);

    }

    public int getCartSize() {

        return cartProducts.size();

    }

    public boolean checkProductInCart(ModelProducts aProduct) {

        return cartProducts.contains(aProduct);

    }

    public void removeProduct(ModelProducts modelProducts){
        cartProducts.remove(modelProducts);
    }

    public ArrayList<ModelProducts> getCartProducts(){return cartProducts;}

}