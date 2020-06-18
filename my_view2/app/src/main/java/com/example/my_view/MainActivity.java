package com.example.my_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private LinearLayout lin_layout;
    private LayoutInflater layoutInflater;
    private ListView listView;
    public static ArrayList<Good> arr_goods=new ArrayList<Good>();
    private final int SIZE_OF_ARR=25;
    private GoodsAdapter goodsAdapter;
    private View view_header, view_footer;
    private TextView tv_count;
    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        fillData();

        setContentView(R.layout.layout);

        listView = (ListView) findViewById(R.id.list_view);

        configureListView();
    }

    private void configureListView() {
        View headerView = createHeader();
        View footerView = createFooter();

        listView.addHeaderView(view_header);
        listView.addFooterView(view_footer);

        goodsAdapter = new GoodsAdapter(this, arr_goods);
        listView.setAdapter(goodsAdapter);
    }

    private View createFooter() {
        view_footer=layoutInflater.inflate(R.layout.footer_mygoods,null);
        btnShow=(Button) view_footer.findViewById(R.id.show_btn);
        btnShow.setOnClickListener(this);
        tv_count=(TextView) view_footer.findViewById(R.id.tv_count);

        return view_footer;
    }

    private View createHeader() {
        layoutInflater=LayoutInflater.from(this.getApplicationContext());
        view_header=layoutInflater.inflate(R.layout.header_mygoods,null);

        return view_header;
    }

    private void fillData() {
        for (int i = 0; i < SIZE_OF_ARR; i++) {
            arr_goods.add(new Good(i," "+"My good №" + i, false,
                    i % 3 == 0
                            ? 100 + i * 2
                            : i % 2 == 0
                                ? 100 - i * 2
                                : 90 + i * 4));
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    public void updateFooter() {
        TextView textView = (TextView) view_footer.findViewById(R.id.footerTitle);

        int counter = 0;
        for (int i = 0; i < SIZE_OF_ARR; i++) {
            if (arr_goods.get(i).isCheck()) {
                counter++;
            }
        }

        textView.setText(String.valueOf(counter));
    }
}
