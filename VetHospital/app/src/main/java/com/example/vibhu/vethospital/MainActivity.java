package com.example.vibhu.vethospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bookAppointment(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.intro);
        startActivity(intent);
    }
}
