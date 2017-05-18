package com.example.nt.bai2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class doi_lich extends AppCompatActivity {

    EditText txtnamduonglich ;
    TextView txtnamamlich;
    Button btchuyendoi;
    String kq=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_lich);
        txtnamduonglich = (EditText) findViewById(R.id.txtnamduong);
        txtnamamlich = (TextView) findViewById(R.id.txtnamam);
        btchuyendoi = (Button) findViewById(R.id.btchuyen);

         final Integer[] can = new Integer[1];// namduong=0 ;
        final Integer[] chi = new Integer[1];
        final ArrayList <String> mangcan = new ArrayList<String>();

        mangcan.add("Kỵ");
        mangcan.add("Canh");
        mangcan.add("Tân");
        mangcan.add("Quý");
        mangcan.add("Giáp");
        mangcan.add("Ất");
        mangcan.add("Bính");
        mangcan.add("Đinh");
        mangcan.add("Mậu");



         final ArrayList <String> mangchi = new ArrayList<String>();
        mangchi.add("Thân");
        mangchi.add("Dậu");
        mangchi.add("tuất");
        mangchi.add("Hợi");
        mangchi.add("Tý");
        mangchi.add("Sửu");
        mangchi.add("Dần");
        mangchi.add("Mẹo");
        mangchi.add("Thìn");
        mangchi.add("Tỵ");
        mangchi.add("Ngọ");
        mangchi.add("Mùi");



        btchuyendoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nam = txtnamduonglich.getText().toString();
                Integer namduong = Integer.parseInt(nam);

                can[0] = namduong % 10;
                chi[0] = namduong % 12;

                kq=  mangcan.get(can[0]) + " " + mangchi.get(chi[0]);

                txtnamamlich.setText(kq);
            }
        });

    }
}
