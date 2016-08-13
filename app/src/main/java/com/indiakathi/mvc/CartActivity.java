package com.indiakathi.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity  {

    Controller aController ;
    //ArrayList<ModelProducts> cartProductList = aController.getCart().getCartProducts();
    ListView cListView;
    TextView tottalPrice = (TextView)findViewById(R.id.totalAmount);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

       aController = (Controller) getApplicationContext();
        cListView  = (ListView) findViewById(R.id.cartLv);
        ArrayList<ModelProducts> cartProductList = aController.getCart().getCartProducts();
        final CartListAdapter cartListAdapter = new CartListAdapter(this,R.layout.cart_item,cartProductList,aController);
        cListView.setAdapter(cartListAdapter);


        inflateTotalAmount(cartProductList);
    }

    private void inflateTotalAmount(ArrayList<ModelProducts> productList) {
        int numberProducts = productList.size();
        for (int i = 0; i < numberProducts; i++){
            int pQuantity =   productList.get(i).getProductQuantity();
            int pPrice = productList.get(i).getProductPrice();
            int pAmountI = pPrice*pQuantity;


        }
    }


}
