package com.indiakathi.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    Controller aController = null ;
    ListView cListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        aController = (Controller) getApplicationContext();
        cListView  = (ListView) findViewById(R.id.cartLv);
        ArrayList<ModelProducts> cartProductList = aController.getCart().getCartProducts();
        CartListAdapter cartListAdapter = new CartListAdapter(getBaseContext(),R.layout.cart_item,cartProductList,aController);
        cListView.setAdapter(cartListAdapter);
    }

}
