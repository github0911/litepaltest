package com.example.litepaltest;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litepaltest.base.BasicActivity;
import com.example.litepaltest.bean.Book;
import com.google.gson.Gson;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

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
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.create_database)
    Button createData;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.query)
    Button query;
    @BindView(R.id.queryAll)
    Button queryAll;

    Gson gson;
    @BindView(R.id.delete_id)
    EditText deleteId;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.delete_all)
    Button deleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
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

    @OnClick(R.id.query)
    public void query() {
        Book book = DataSupport.findFirst(Book.class);
        result.setText(gson.toJson(book));
    }

    @OnClick(R.id.queryAll)
    protected void queryAll() {
        List<Book> allBooks = DataSupport.findAll(Book.class);
        result.setText(gson.toJson(allBooks));
    }

    @OnClick(R.id.delete)
    public void delete(){
        if (TextUtils.isEmpty(deleteId.getText().toString())) {
            Toast.makeText(this, "deleteId is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        int count = DataSupport.deleteAll(Book.class, "id = ?", deleteId.getText().toString());
        if (count > 0) {
            Toast.makeText(this, "delete success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "delete failed", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.delete_all)
    public void deleteAll(){
        int count = DataSupport.deleteAll(Book.class);
        if (count > 0) {
            Toast.makeText(this, "delete success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "delete failed", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.update)
    public void update(){
        Book book = new Book();
        book.setAuthor(author.getText().toString());
        book.setName(name.getText().toString());
        book.setPrice(Double.valueOf(price.getText().toString()));
        int count = book.update(15);

        if (count > 0) {
            Toast.makeText(this, "update success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "update failed", Toast.LENGTH_SHORT).show();
        }
    }
}
