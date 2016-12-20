package com.example.litepaltest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.litepaltest.base.BasicActivity;

import org.litepal.tablemanager.Connector;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BasicActivity {

    @BindView(R.id.create_database)
    Button createDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDB();
    }

    @OnClick(R.id.create_database)
    public void createDB(){
        Connector.getDatabase();
    }

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_main);
    }
}
