package com.indiakathi.mvc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by mohit on 21-06-2016.
 */
public class AdapterTry extends ArrayAdapter<ModelProducts> {

    private int layout;
    private List<ModelProducts> productList;

    public AdapterTry(Context context, int resource, List<ModelProducts> productList){
        super(context,resource,productList);
        this.productList = productList;
        this.layout = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mainViewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout,parent,false);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.item_image);

            viewHolder.title = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.price = (TextView) convertView.findViewById(R.id.item_price1);
            viewHolder.button = (Button) convertView.findViewById(R.id.addToCart);
            viewHolder.title.setText(getItem(position).getProductName());
            viewHolder.thumbnail.setImageResource(R.mipmap.ic_launcher);
            viewHolder.addBtn = (ImageView)convertView.findViewById(R.id.addBtn);
            viewHolder.reduceBtn = (ImageView) convertView.findViewById(R.id.reduceBtn);
            viewHolder.quantity = (TextView) convertView.findViewById(R.id.tvQuantity);
            //viewHolder.quantity.setText(0);
            viewHolder.price.setText(Integer.toString(getItem(position).getProductPrice()));
            viewHolder.addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String StringQuantity = viewHolder.quantity.getText().toString();
                    int quantity = Integer.parseInt(StringQuantity);
                    int newQuant = quantity+1;
                    viewHolder.quantity.setText(Integer.toString(newQuant));
                }
            });
            viewHolder.reduceBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String StringQuantity = viewHolder.quantity.getText().toString();
                    int quantity = Integer.parseInt(StringQuantity);
                    if (quantity>0){
                    int newQuant = quantity-1;
                    viewHolder.quantity.setText(Integer.toString(newQuant));}
                }
            });
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"button was clicked"+ productList.get(position).getProductName(),Toast.LENGTH_LONG).show();
                }
            });
            convertView.setTag(viewHolder);
        }
        else {
            mainViewHolder = (ViewHolder) convertView.getTag();
            //mainViewHolder.price.setText(Integer.toString(28));
            //mainViewHolder.title.setText(getItem(position).getProductName());
            //mainViewHolder.price.setText(getItem(position).getProductPrice());
        }

        return convertView;
    }

    public class ViewHolder {
        ImageView thumbnail;
        Button button;
        TextView title;
        TextView price;
        ImageView addBtn;
        ImageView reduceBtn;
        TextView quantity;
    }
}
