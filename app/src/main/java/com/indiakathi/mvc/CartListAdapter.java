package com.indiakathi.mvc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mohit panwar on 26-07-2016.
 */
public class CartListAdapter  extends ArrayAdapter<ModelProducts>{

    private int layout;
    private List<ModelProducts> productList;
    private Controller controller;

    public CartListAdapter(Context context, int resource, List<ModelProducts> productList,Controller controller) {
        super(context, resource, productList);
        this.layout = resource;
        this.productList = productList;
        this.controller = controller;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
         CartViewHolder mainViewHolder = null;
        //final CartViewHolder viewHolder = new CartViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final ModelProducts modelProducts = productList.get(position);
        if(convertView == null){
            //LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout,parent,false);
            mainViewHolder = new CartViewHolder();
            mainViewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.item_image);

            mainViewHolder.title = (TextView) convertView.findViewById(R.id.item_title);
            mainViewHolder.price = (TextView) convertView.findViewById(R.id.item_price1);
            //viewHolder.title.setText(getItem(position).getProductName());
            //mainViewHolder.thumbnail.setImageResource(R.mipmap.ic_launcher);
            mainViewHolder.addBtn = (ImageView)convertView.findViewById(R.id.addBtn);
            mainViewHolder.reduceBtn = (ImageView) convertView.findViewById(R.id.reduceBtn);
            mainViewHolder.quantity = (TextView) convertView.findViewById(R.id.tvQuantityCart);
            mainViewHolder.deleteFromCartIv = (ImageView) convertView.findViewById(R.id.deleteCartIv);
            //mainViewHolder.price.setText(Integer.toString(getItem(position).getProductPrice()));
            //mainViewHolder.quantity.setText(Integer.toString(getItem(position).getProductQuantity()));
            //final ModelProducts modelProducts = productList.get(position);
/*
            mainViewHolder.addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //String StringQuantity = mainViewHolder.quantity.getText().toString();
                    int quantity = productList.get(position).getProductQuantity();
                    //int quantity = Integer.parseInt(StringQuantity);
                    int newQuant = quantity+1;
                    productList.get(position).setProductQuantity(newQuant);
                    mainViewHolder.quantity.setText(Integer.toString(newQuant));
                    //notifyDataSetChanged();
                    //if(quantity == 0){ controller.getCart().setProducts(productList.get(position));}

                }
            });
            mainViewHolder.reduceBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String StringQuantity = mainViewHolder.quantity.getText().toString();
                    int quantity = Integer.parseInt(StringQuantity);
                    if (quantity>0){
                        int newQuant = quantity-1;
                        //ModelProducts selectedProduct = productList.get(position);
                        if(newQuant == 0){controller.getCart().removeProduct(modelProducts);}
                        productList.get(position).setProductQuantity(newQuant);
                        mainViewHolder.quantity.setText(Integer.toString(newQuant));
                    }

                }
            }); */
            convertView.setTag(mainViewHolder);

        }
        else{
            mainViewHolder = (CartViewHolder) convertView.getTag();
        }

        final CartViewHolder finalMainViewHolder = mainViewHolder;
        mainViewHolder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String StringQuantity = mainViewHolder.quantity.getText().toString();
                int quantity = productList.get(position).getProductQuantity();
                //int quantity = Integer.parseInt(StringQuantity);
                int newQuant = quantity+1;
                productList.get(position).setProductQuantity(newQuant);
                finalMainViewHolder.quantity.setText(Integer.toString(newQuant));
                //notifyDataSetChanged();
                //if(quantity == 0){ controller.getCart().setProducts(productList.get(position));}

            }
        });

        mainViewHolder.deleteFromCartIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int position1 = position;
                //productList.remove(productList.get(position));
                //controller.getCart().removeProduct(tempProduct);
                productList.remove(productList.get(position));
                CartListAdapter.this.notifyDataSetChanged();
                //productList.clear();
                //productList.addAll(controller.getCart().getCartProducts());
                //notifyDataSetChanged();
            }
        });

        final CartViewHolder finalMainViewHolder1 = mainViewHolder;
        mainViewHolder.reduceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String StringQuantity = productList.get(position).getProductQuantity();
                int quantity = productList.get(position).getProductQuantity();
                if (quantity>0){
                    int newQuant = quantity-1;
                    //ModelProducts selectedProduct = productList.get(position);
                    if(newQuant == 0){controller.getCart().removeProduct(productList.get(position));}
                    productList.get(position).setProductQuantity(newQuant);
                    finalMainViewHolder1.quantity.setText(Integer.toString(newQuant));
                }

            }
        });
        //mainViewHolder.title.setText(getItem(position).getProductName());
        mainViewHolder.title.setText(productList.get(position).getProductName());
        mainViewHolder.thumbnail.setImageResource(R.mipmap.ic_launcher);
        mainViewHolder.price.setText(Integer.toString(getItem(position).getProductPrice()));
        mainViewHolder.quantity.setText(Integer.toString(getItem(position).getProductQuantity()));
        return convertView;
    }

    public class CartViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView price;
        ImageView addBtn;
        ImageView reduceBtn;
        TextView quantity;
        ImageView deleteFromCartIv;
    }
}
