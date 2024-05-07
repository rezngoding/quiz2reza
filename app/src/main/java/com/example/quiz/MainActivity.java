package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup cartype, chooseoutsidecity;
    private TextView totaldayrent;
    private Button pesanButton;

    private final int PAJERO = 2400000;
    private final int ALPHARD = 1550000;
    private final int INOVA = 850000;
    private final int BRIO = 550000;

    private final int INSIDE_CITY = 135000;
    private final int OUTSIDE_CITY = 25000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cartype = findViewById(R.id.radioGroup);
        chooseoutsidecity = findViewById(R.id.radioGroup1);
        totaldayrent = findViewById(R.id.TOTALHARI);

        pesanButton = findViewById(R.id.pesanbtn);
        pesanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesan();
            }
        });
    }

    private void pesan() {
        RadioButton selectedcartypeRadioButton = findViewById(cartype.getCheckedRadioButtonId());
        RadioButton selectedchooseoutsidecityRadioButton = findViewById(chooseoutsidecity.getCheckedRadioButtonId());

        if (selectedcartypeRadioButton == null || selectedchooseoutsidecityRadioButton == null) {
            Toast.makeText(this, "PILIH JENIS MOBIL TERLEBIH DAHULU!", Toast.LENGTH_SHORT).show();
            return;
        }

        String cartype = selectedcartypeRadioButton.getText().toString();
        String outsidecity = selectedchooseoutsidecityRadioButton.getText().toString();
        String totaldayrent = this.totaldayrent.getText().toString();

        if (totaldayrent.isEmpty()) {
            Toast.makeText(this, "MASUKKAN JUMLAH HARI RENTAL", Toast.LENGTH_SHORT).show();
            return;
        }

        int jumlah = Integer.parseInt(totaldayrent);

        int hargacartype = getHargacartype(cartype);
        int outsidecity1 = getOUTSIDECITY(outsidecity);

        int totalHarga = (hargacartype + outsidecity1) * jumlah;

        // Diskon berdasarkan total harga
        double diskon = 0.0;
        if (totalHarga > 10000000) {
            diskon = 0.10; // 10% diskon
        } else if (totalHarga > 5000000) {
            diskon = 0.05; // 5% diskon
        }

        // Hitung total harga setelah diskon
        double totalHargaSetelahDiskon = totalHarga - (totalHarga * diskon);

        Intent intent = new Intent(MainActivity.this, hasil.class);
        intent.putExtra("cartype", cartype);
        intent.putExtra("outsidecity", outsidecity);
        intent.putExtra("totaldayrent", totaldayrent);
        intent.putExtra("totalHarga", totalHargaSetelahDiskon);
        startActivity(intent);
    }

    private int getHargacartype(String cartype) {
        switch (cartype) {
            case "PAJERO":
                return PAJERO;
            case "ALPHARD":
                return ALPHARD;
            case "INOVA":
                return INOVA;
            case "BRIO":
                return BRIO;
            default:
                return 0;
        }
    }

    private int getOUTSIDECITY(String outsidecity) {
        switch (outsidecity) {
            case "INSIDE CITY":
                return INSIDE_CITY;
            case "OUTSIDE CITY":
                return OUTSIDE_CITY;
            default:
                return 0;
        }
    }
}
