package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    Button btn5Star;
    ArrayList<Songs> alSongs;
    ArrayAdapter<Songs> aaSongs;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        btn5Star = (Button)findViewById(R.id.btnShow5Stars);
        lv = (ListView)findViewById(R.id.lv);

        Intent i = getIntent();
        DBHelper db = new DBHelper(SongListActivity.this);

        // Insert a task
        ArrayList<String> data = db.getAllSongs();
        db.close();

        DBHelper db2 = new DBHelper(SongListActivity.this);
        alSongs = db2.getAllSong();
        db2.close();

        btn5Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db3 = new DBHelper(SongListActivity.this);
                alSongs = db3.getAllSongs(5);
                db3.close();
            }
        });

        aaSongs = new SongAdapter(SongListActivity.this, R.layout.song_row, alSongs);
        lv.setAdapter(aaSongs);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Intent i = new Intent(SongListActivity.this,
                        ModifySongActivity.class);
                Songs data = alSongs.get(position);
                String id = data.getId()+"";
                String title = data.getTitle();
                String singer = data.getSinger();
                String year = data.getYear()+"";
                String star = data.getStar()+"";

                Songs target = new Songs(Integer.parseInt(id), title, singer, Integer.parseInt(year), Integer.parseInt(star));
                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            aaSongs.notifyDataSetChanged();
            lv.setAdapter(aaSongs);
        }
    }
}
