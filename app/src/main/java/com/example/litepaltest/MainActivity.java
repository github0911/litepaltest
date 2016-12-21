package com.example.litepaltest;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.litepaltest.base.BasicActivity;
import com.example.litepaltest.bean.Book;

import org.litepal.tablemanager.Connector;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BasicActivity {

    private static final String TAG = "Litepal";

    @BindView(R.id.author)
    EditText author;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.price)
    EditText price;
    @BindView(R.id.save)
    Button save;
    @BindView(R.id.create_database)
    Button createData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.create_database)
    public void createDB() {
        Log.i(TAG, "createDB");
        Connector.getDatabase();
    }

    @OnClick(R.id.save)
    public void save() {
        Log.i(TAG, "save");
        Book book = new Book();
        book.setAuthor(TextUtils.isEmpty(author.getText().toString()) ? "" : author.getText().toString());
        book.setName(TextUtils.isEmpty(name.getText().toString()) ? "" : name.getText().toString());
        book.setPrice(TextUtils.isEmpty(price.getText().toString()) ? 0 : Double.valueOf(price.getText().toString()));
        if (book.save()) {
            Toast.makeText(this, "save success", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "save: success");
        } else {
            Toast.makeText(this, "save failed", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "save: success");
        }
    }
}
