package com.example.my_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class GoodsAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {

    private MainActivity context;
    private ArrayList<Good> arr_goods_adapter;
    private LayoutInflater layoutInflater;

    public GoodsAdapter(MainActivity context, ArrayList<Good> arr_goods_adapter) {
        this.context=context;
        this.arr_goods_adapter=arr_goods_adapter;
        this.layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount(){
        return arr_goods_adapter.size();
    }
    @Override
    public Object getItem(int position){
        return arr_goods_adapter.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup viewGroup){
        View view=contentView;
        if (view==null){
            view= layoutInflater.inflate(R.layout.item_good,null,false);
        }
        Good good_temp=arr_goods_adapter.get(position);
        TextView tv_goodId=(TextView) view.findViewById(R.id.tv_goodId);
        tv_goodId.setText(Integer.toString(good_temp.getId()));

        TextView tv_goodName=(TextView) view.findViewById(R.id.tv_goodName);
        tv_goodName.setText(good_temp.getName());

        CheckBox cb_good=(CheckBox) view.findViewById(R.id.cb_good);

        TextView priceTextView = (TextView) view.findViewById(R.id.tv_price);
        priceTextView.setText(String.valueOf(good_temp.getPrice()));

        cb_good.setChecked(good_temp.isCheck());
        cb_good.setTag(position);
        cb_good.setOnCheckedChangeListener(this);

        return view;
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked){
        if (compoundButton.isShown()){
            int i=(int) compoundButton.getTag();
            arr_goods_adapter.get(i).setCheck(isChecked);
            context.updateFooter();
            notifyDataSetChanged();
        }
    }
}
