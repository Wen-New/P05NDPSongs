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

public class ModifySongActivity extends AppCompatActivity {

    TextView tvID;
    EditText etTitle, etSinger, etYear;
    Button btnUpdate, btnDelete, btnCancel;
    Songs data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        tvID = (TextView) findViewById(R.id.tvID2);
        etTitle = (EditText) findViewById(R.id.etSongTitle2);
        etSinger = (EditText) findViewById(R.id.etSingers2);
        etYear = (EditText) findViewById(R.id.etYear2);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        Intent i = getIntent();
        data = (Songs) i.getSerializableExtra("data");

        tvID.setText("ID: " + data.getId());
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSinger());
        etYear.setText(data.getYear());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroupStars);
                int selectedRB = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selectedRB);
                DBHelper db = new DBHelper(ModifySongActivity.this);
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
                Toast.makeText(ModifySongActivity.this ,"Inserted", Toast.LENGTH_SHORT).show();
                db.close();
                setResult(RESULT_OK);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(ModifySongActivity.this);
                db.deleteSong(data.getId());
                db.close();
                setResult(RESULT_OK);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
