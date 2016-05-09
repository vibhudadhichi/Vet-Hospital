package com.example.vibhu.vethospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

    public void thanks(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.secondpage);
        startActivity(intent);
    }
}
