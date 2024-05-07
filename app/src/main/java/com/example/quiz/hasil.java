package com.example.quiz;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class hasil extends AppCompatActivity {

    private TextView cartype, chooseoutsidecity, jmlhari, totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        cartype = findViewById(R.id.cartype);
        chooseoutsidecity = findViewById(R.id.outsidecity);
        jmlhari = findViewById(R.id.jmlhari);
        totalTextView = findViewById(R.id.totalTextView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String cartype = extras.getString("cartype");
            String outsidecity = extras.getString("outsidecity");
            String totaldayrent = extras.getString("totaldayrent");
            int totalHarga = extras.getInt("totalHarga");


            this.cartype.setText("Menu : " + cartype);
            chooseoutsidecity.setText("Minuman : " + outsidecity);
            jmlhari.setText("Jumlah hari rental : " + totaldayrent);
            totalTextView.setText("Total : "+"Rp." + totalHarga );
        }
    }
}
