package com.example.nt.bai3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static com.example.nt.bai3.R.id.editCannang;
import static com.example.nt.bai3.R.id.editChieucao;


public class ChisoBMI extends AppCompatActivity

    implements OnClickListener{


        TextView txtbmila, txtchuandoanla;
        Button btchuandoan;
        EditText editcannang, editchieucao, editten;


        @Override
        protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
            btchuandoan = (Button) findViewById(R.id.button);
            btchuandoan.setOnClickListener(this);
        txtbmila = (TextView) findViewById(R.id.txtIBM);
        txtchuandoanla = (TextView) findViewById(R.id.txtChuandoan);
        editcannang = (EditText) findViewById(editCannang);
        editchieucao = (EditText) findViewById(editChieucao);
        editten = (EditText) findViewById(R.id.editTen);


    }
        @Override
        public void onClick(View v) {
            try {
                double H = Double.parseDouble(editchieucao.getText() + "");
                double W = Double.parseDouble(editcannang.getText() + "");
                double BMI = (float) (W / Math.pow(H, 2));
                String chandoan = "";
                if (BMI < 18) {
                    chandoan = "Bạn gầy";
                } else if (BMI <= 24.9) {
                    chandoan = "Bạn bình thường";
                } else if (BMI <= 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI <= 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat(".00");
                txtbmila.setText(dcf.format(BMI));
                txtchuandoanla.setText(chandoan);
            }finally

            {
                final AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Lỗi");
                final AlertDialog.Builder dong = builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        String loi = "nhập sư liệu không hợp lệ";
                        builder.setMessage(loi);//thiết lập nội dung
                        builder.create().show();//hiển thị Dialog

                    }
                });
            }
        }private void arg() {
    }
    }





