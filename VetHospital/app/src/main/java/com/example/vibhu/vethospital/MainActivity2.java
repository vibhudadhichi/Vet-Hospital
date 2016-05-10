package com.example.vibhu.vethospital;

import android.content.Intent;
import android.net.Uri;
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
        EditText txtname = (EditText)findViewById(R.id.name1);
        String name = "Full Name: " + txtname.getText().toString() + "\n";
        EditText txtname1 = (EditText)findViewById(R.id.name2);
        name = name + "Pet: " + txtname1.getText().toString() + "\n";
        EditText txtname2 = (EditText)findViewById(R.id.name21);
        name = name + "Sex: " + txtname2.getText().toString() + "\n";
        EditText txtname3 = (EditText)findViewById(R.id.name3);
        name = name + "Age: " + txtname3.getText().toString() + "\n";
        EditText txtname4 = (EditText)findViewById(R.id.name4);
        name = name + "Booking Date and Time: " + txtname4.getText().toString() + "\n";
        Intent gmail = new Intent(Intent.ACTION_VIEW);
        gmail.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
        gmail.putExtra(Intent.EXTRA_EMAIL, new String[] { "vet-hospital@gmail.com" });
        gmail.setData(Uri.parse("vet-hospital@gmail.com"));
        gmail.putExtra(Intent.EXTRA_SUBJECT, "Booking Confirmation");
        gmail.setType("plain/text");
        gmail.putExtra(Intent.EXTRA_TEXT, "Hi Doctor,\n\nPlease see the below mentioned details :\n" + name);
        startActivity(gmail);
    }
}
