package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnShowList = (Button)findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroupStars);
                int selectedRB = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selectedRB);
                DBHelper db = new DBHelper(MainActivity.this);
                if (selectedRB == R.id.radio1) {
                    db.insertSong(etTitle.getText().toString(), etSinger.getText().toString(),Integer.parseInt(etYear.getText().toString()), 1);
                } else if (selectedRB == R.id.radio2) {
                    db.insertSong(etTitle.getText().toString(), etSinger.getText().toString(),Integer.parseInt(etYear.getText().toString()), 2);
                } else if (selectedRB == R.id.radio3) {
                    db.insertSong(etTitle.getText().toString(), etSinger.getText().toString(),Integer.parseInt(etYear.getText().toString()), 3);
                } else if (selectedRB == R.id.radio4) {
                    db.insertSong(etTitle.getText().toString(), etSinger.getText().toString(),Integer.parseInt(etYear.getText().toString()), 4);
                } else if (selectedRB == R.id.radio5) {
                    db.insertSong(etTitle.getText().toString(), etSinger.getText().toString(),Integer.parseInt(etYear.getText().toString()), 5);
                }
                Toast.makeText(MainActivity.this ,"Inserted", Toast.LENGTH_SHORT).show();
                db.close();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SongListActivity.class);
                startActivity(i);
            }
        });
    }
}
