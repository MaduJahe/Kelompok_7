package com.example.kelompok_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    private TextView textHome;
    private TextView textAway;

    private TextView scoreHome;
    private TextView scoreaway;

    private ImageView homeLogo;
    private ImageView awayLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        textHome = findViewById(R.id.txt_home);
        textAway = findViewById(R.id.txt_away);

        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);

        scoreHome = findViewById(R.id.score_home);
        scoreaway = findViewById(R.id.score_away);

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"

        Intent intent = getIntent();
        String home = intent.getStringExtra("home_team");
        textHome.setText(home);
        String  away = intent.getStringExtra("away_team");
        textAway.setText(away);

        Bitmap imgHome = (Bitmap) intent.getParcelableExtra("image_home_bitmap");
        homeLogo.setImageBitmap(imgHome);
        Bitmap imgAway = (Bitmap) intent.getParcelableExtra("image_away_bitmap");
        awayLogo.setImageBitmap(imgAway);

    }
    public void CekHasil(View view) {
        int lastScore = Integer.parseInt(scoreHome.getText().toString());
        int lastScore1 = Integer.parseInt(scoreaway.getText().toString());


        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("home_team", "Ubahlah text ini sesuai input home");
            // past image home to next activity
        if (lastScore >= lastScore1){
            intent.putExtra("home_team", "");

        }

        startActivity(intent);
    }

    public void handlerAddHome(View view) {
        int lastScore = Integer.parseInt(scoreHome.getText().toString());
        String score = String.valueOf(lastScore + 1);
        scoreHome.setText(score);
    }

    public void handlerAddAway(View view) {
        int lastScore = Integer.parseInt(scoreaway.getText().toString());
        String score = String.valueOf(lastScore + 1);
        scoreaway.setText(score);
    }
}