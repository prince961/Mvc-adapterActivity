package com.indiakathi.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity  {

    Controller aController ;
    //ArrayList<ModelProducts> cartProductList = aController.getCart().getCartProducts();
    ListView cListView;
    TextView totalPrice ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

       aController = (Controller) getApplicationContext();
        cListView  = (ListView) findViewById(R.id.cartLv);
        totalPrice = (TextView) findViewById(R.id.totalAmount);
        ArrayList<ModelProducts> cartProductList = aController.getCart().getCartProducts();
        final CartListAdapter cartListAdapter = new CartListAdapter(this,R.layout.cart_item,cartProductList,aController,totalPrice);
        cListView.setAdapter(cartListAdapter);


        inflateTotalAmount(cartProductList);
    }

    private void inflateTotalAmount(ArrayList<ModelProducts> productList) {
        //ArrayList<Double> priceList = new ArrayList<Double>();
        Double totalAmount = 0.0;
        int numberProducts = productList.size();
        for (int i = 0; i < numberProducts; i++){
            int pQuantity =   productList.get(i).getProductQuantity();
            int pPrice = productList.get(i).getProductPrice();
            double pAmountI = pPrice*pQuantity;
            //priceList.add(pAmountI);
            totalAmount = totalAmount + pAmountI;
        }
        totalPrice.setText(Double.toString(totalAmount));
    }

   /* private void sendDataToServerTry(){
        String trialJson ="'{\n" +
                "  \"payment_method\": \"bacs\",\n" +
                "  \"payment_method_title\": \"Direct Bank Transfer\",\n" +
                "  \"set_paid\": true,\n" +
                "  \"billing\": {\n" +
                "    \"first_name\": \"John\",\n" +
                "    \"last_name\": \"Doe\",\n" +
                "    \"address_1\": \"969 Market\",\n" +
                "    \"address_2\": \"\",\n" +
                "    \"city\": \"San Francisco\",\n" +
                "    \"state\": \"CA\",\n" +
                "    \"postcode\": \"94103\",\n" +
                "    \"country\": \"US\",\n" +
                "    \"email\": \"john.doe@example.com\",\n" +
                "    \"phone\": \"(555) 555-5555\"\n" +
                "  },\n" +
                "  \"shipping\": {\n" +
                "    \"first_name\": \"John\",\n" +
                "    \"last_name\": \"Doe\",\n" +
                "    \"address_1\": \"969 Market\",\n" +
                "    \"address_2\": \"\",\n" +
                "    \"city\": \"San Francisco\",\n" +
                "    \"state\": \"CA\",\n" +
                "    \"postcode\": \"94103\",\n" +
                "    \"country\": \"US\"\n" +
                "  },\n" +
                "  \"line_items\": [\n" +
                "    {\n" +
                "      \"product_id\": 100,\n" +
                "      \"quantity\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"product_id\": 98,\n" +
                "      \"quantity\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"shipping_lines\": [\n" +
                "    {\n" +
                "      \"method_id\": \"flat_rate\",\n" +
                "      \"method_title\": \"Flat Rate\",\n" +
                "      \"total\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}'" ;

        try {

            URL url = new URL("https://www.indiakathi.com/wc-api/v3/orders?&consumer_key=ck_28f853daf1e9200af47d5ce08f60a77df567b1a3&consumer_secret=cs_b9c783eb7f2f3462c63754e1b574906291f062e0");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
*/

}
