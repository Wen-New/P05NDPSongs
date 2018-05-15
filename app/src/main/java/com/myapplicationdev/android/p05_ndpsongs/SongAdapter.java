package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Songs> {
    Context context;
    ArrayList<Songs> songs;
    int resource;
    TextView tvYear, tvTitle, tvSinger;
    ImageView iv1, iv2, iv3, iv4, iv5;

    public SongAdapter(Context context, int resource, ArrayList<Songs> songs) {
        super(context, resource, songs);
        this.context = context;
        this.songs = songs;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        //Match the UI components with Java variables
        tvYear = (TextView)rowView.findViewById(R.id.tvYear);
        tvTitle = (TextView)rowView.findViewById(R.id.tvTitle);
        tvSinger = (TextView)rowView.findViewById(R.id.tvSinger);
        iv1 = (ImageView)rowView.findViewById(R.id.imageView1star);
        iv2 = (ImageView)rowView.findViewById(R.id.imageView2star);
        iv3 = (ImageView)rowView.findViewById(R.id.imageView3star);
        iv4 = (ImageView)rowView.findViewById(R.id.imageView4star);
        iv5 = (ImageView)rowView.findViewById(R.id.imageView5star);

        Songs song= songs.get(position);

        tvYear.setText(song.getYear());
        tvYear.setText(song.getYear());
        tvYear.setText(song.getYear());
        int stars = song.getStar();
        //Check if the property for starts >= 5, if so, "light" up the stars
        if (stars >= 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars >= 4) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars >= 3) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars >= 2) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars >= 1) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_off);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }



}
