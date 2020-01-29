package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static Button button;
    public static EditText text;
    public static int count = 0;
    public static String key = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.searchButton);
        text = (EditText) findViewById(R.id.searchText);
    }

    public void searchinlink(View view) {
        count++;
        if(count%2==0)
        {
            text.setText("");
            text.setHint("Enter the search Key");
            button.setText("Search");
        }
        else
        {
            key = text.getText().toString();
            fetchData fetch = new fetchData();
            fetch.execute();
        }

    }
}
