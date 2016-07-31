package com.indiakathi.mvc;

import android.content.Context;
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
        AdapterTry.ViewHolder mainViewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout,parent,false);
            final CartViewHolder viewHolder = new CartViewHolder();
            viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.item_image);

            viewHolder.title = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.price = (TextView) convertView.findViewById(R.id.item_price1);
            viewHolder.title.setText(getItem(position).getProductName());
            viewHolder.thumbnail.setImageResource(R.mipmap.ic_launcher);
            viewHolder.addBtn = (ImageView)convertView.findViewById(R.id.addBtn);
            viewHolder.reduceBtn = (ImageView) convertView.findViewById(R.id.reduceBtn);
            viewHolder.quantity = (TextView) convertView.findViewById(R.id.tvQuantityCart);
            viewHolder.deleteFromCartIv = (ImageView) convertView.findViewById(R.id.deleteCartIv);
            viewHolder.price.setText(Integer.toString(getItem(position).getProductPrice()));
            viewHolder.quantity.setText(Integer.toString(getItem(position).getProductQuantity()));

            viewHolder.addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String StringQuantity = viewHolder.quantity.getText().toString();
                    int quantity = Integer.parseInt(StringQuantity);
                    int newQuant = quantity+1;
                    productList.get(position).setProductQuantity(newQuant);
                    viewHolder.quantity.setText(Integer.toString(newQuant));
                    //if(quantity == 0){ controller.getCart().setProducts(productList.get(position));}

                }
            });
            viewHolder.reduceBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String StringQuantity = viewHolder.quantity.getText().toString();
                    int quantity = Integer.parseInt(StringQuantity);
                    if (quantity>0){
                        int newQuant = quantity-1;
                        if(newQuant == 0){controller.getCart().removeProduct(productList.get(position));}
                        productList.get(position).setProductQuantity(newQuant);
                        viewHolder.quantity.setText(Integer.toString(newQuant));
                    }

                }
            });

            convertView.setTag(viewHolder);

            viewHolder.deleteFromCartIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    controller.getCart().removeProduct(productList.get(position));
                }

            });
        }
        else {}
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
