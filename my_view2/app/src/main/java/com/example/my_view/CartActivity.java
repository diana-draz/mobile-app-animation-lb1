package com.example.my_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private TextView cartSizeTextView;

    public CartActivity() {
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartSizeTextView = findViewById(R.id.cart_size);

        // находим список
        ListView cartListView = (ListView) findViewById(R.id.сart_list_view);

        ArrayList<String>  cartItems = new ArrayList<String>();
        for (int i = 0; i < MainActivity.arr_goods.size(); i++) {
            if (MainActivity.arr_goods.get(i).isCheck()) {
                cartItems.add(MainActivity.arr_goods.get(i).toString());
            }
        }

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(), R.layout.cart_item, cartItems);

        // присваиваем адаптер списку
        cartListView.setAdapter(adapter);

        cartSizeTextView.setText("В корзине находится " + String.valueOf(cartItems.size())+ " товар(ов)");
    }
}
