package com.example.bookapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button go_to_page = (Button)findViewById(R.id.go_to_page);
    }

    public void goToPage(View v) {
        Intent intent = new Intent(MainActivity.this, PageActivity.class);
        startActivity(intent);

        intent.putExtra("page_number", "1");
        //intent.putExtra("back", "new_pallette");
    }
}