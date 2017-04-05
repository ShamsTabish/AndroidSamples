package com.acadgild.extrasessionproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends AppCompatActivity {

    List<MyProduct> myProducts = new ArrayList<>();
    ListView customList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        customList = (ListView) findViewById(R.id.customList);
        myProducts.add(new MyProduct("IPhone 7", "Rs 58,000/-", R.mipmap.iphone));
        myProducts.add(new MyProduct("Nokia xyz", "52,000/-", R.mipmap.train));
        myProducts.add(new MyProduct("Sony X-Peria", "42,000/-", R.mipmap.ic_launcher));
        myProducts.add(new MyProduct("Dell Laptop", "Rs. 55,000/-", R.mipmap.ic_launcher));
        myProducts.add(new MyProduct("Apple TV", "42,000/-", R.mipmap.train));

        MyProductAdapter myProductAdapter = new MyProductAdapter();

        MyDB db = new MyDB(this, "DB.txt", null, 1);
        Cursor cr = db.getReadableDatabase().query("product", null, null, null, null, null, null, null);

//        cr.moveToFirst();
//        do{
//            Toast.makeText(this, "==> "+cr.getColumnCount()+"; "+cr.getString(0)+"  ;  "+cr.getString(1)+"  ; ", Toast.LENGTH_SHORT).show();
//        }while (cr.moveToNext());
//        customList.setAdapter(myProductAdapter);

        customList.setAdapter(new MyCursorAdapter(this, cr));

    }

    class MyDB extends SQLiteOpenHelper {


        public MyDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String table = "product";
            db.execSQL("create table " + table + "(_id integer(4),name varchar(30),price varchar(20));");
            ContentValues vals = new ContentValues();
            vals.put("_id", 1);
            vals.put("name", "IPad");
            vals.put("price", "Rs.52,000/-");
            db.insert(table, null, vals);

            vals.put("_id", 2);
            vals.put("name", "Raspberry Pi");
            vals.put("price", "5,000/-");
            db.insert(table, null, vals);

            vals.put("_id", 3);
            vals.put("name", "Arduino");
            vals.put("price", "3000/-");
            db.insert(table, null, vals);

            vals.put("_id", 4);
            vals.put("name", "Magic Box");
            vals.put("price", "23,000/-");
            db.insert(table, null, vals);

            vals.put("_id", 5);
            vals.put("name", "Dell Comp");
            vals.put("price", "45,000/-");
            db.insert(table, null, vals);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }


    }

    class MyCursorAdapter extends CursorAdapter {
        public MyCursorAdapter(Context context, Cursor c) {
            super(MyCustomAdapter.this, c, false);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.product_entry, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView title = (TextView) view.findViewById(R.id.productTitle);
            TextView price = (TextView) view.findViewById(R.id.productPrice);
            ImageView img = (ImageView) view.findViewById(R.id.productImage);
            img.setImageResource(R.mipmap.iphone);
            title.setText(cursor.getString(1));
            price.setText(cursor.getString(2));
//            title.setText("Tittle");
//            price.setText("10000.0/-");

        }
    }


    class MyProductAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myProducts.size();
        }

        @Override
        public Object getItem(int position) {
            return myProducts.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.product_entry, parent, false);
                TextView titleView = (TextView) convertView.findViewById(R.id.productTitle);
                TextView priceView = (TextView) convertView.findViewById(R.id.productPrice);

                titleView.setText(myProducts.get(position).name);
                priceView.setText(myProducts.get(position).price);

                ImageView productImage = (ImageView) convertView.findViewById(R.id.productImage);

                productImage.setImageResource(myProducts.get(position).icon);

                productImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MyCustomAdapter.this, "Image is clicked for " + myProducts.get(position).name, Toast.LENGTH_SHORT).show();
                    }
                });
            }
            return convertView;
        }
    }


    class MyProduct {
        String name, price;
        int icon;

        public MyProduct(String name, String price, int icon) {
            this.price = price;
            this.name = name;
            this.icon = icon;
        }
    }
}
