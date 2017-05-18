package com.example.nt.bai13;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.nt.bai13.R.id.editTen;


public class MainActivity extends AppCompatActivity {

    TextView txtthanht, txttongkh, txttongv,txttongdt;
    Button bntTinhtien, bntTiep, bntThongke;
    EditText editten, editsoluong;
    ImageButton btthoat;
    CheckBox checkV;
    DanhSachKhachHang danhsach = new DanhSachKhachHang();


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        getControls();
        addEvents();
    }

    private void getControls() {
        txtthanht = (TextView) findViewById(R.id.txtThanhtien);
        editten = (EditText) findViewById(editTen);
        editsoluong = (EditText) findViewById(R.id.editSoluong);
        txttongkh = (TextView) findViewById(R.id.txtTongSoKH);
        txttongv = (TextView) findViewById(R.id.txtTongSoKHV);
        txttongdt=(TextView) findViewById(R.id.txtTongDT);
        bntTinhtien = (Button) findViewById(R.id.btTinhtien);
        bntTiep = (Button) findViewById(R.id.btTiep);
        bntThongke = (Button) findViewById(R.id.btThongke);
        checkV = (CheckBox) findViewById(R.id.checkKhach);
        btthoat=(ImageButton)findViewById(R.id.imageButton);
    }

    private void addEvents() {
        bntTinhtien.setOnClickListener(new ProcessMyEvent());
        bntThongke.setOnClickListener(new ProcessMyEvent());
        bntTiep.setOnClickListener(new ProcessMyEvent());
        btthoat.setOnClickListener(new ProcessMyEvent());
    }
    private void doTinhTien()

    {

        KhachHang kh=new KhachHang();

        kh.setTenKh(editten.getText()+"");

                kh.setSlmua(Integer.parseInt(editsoluong.getText()+""));

                        kh.setVip(checkV.isChecked());

        txtthanht.setText(kh.tinhThanhTien()+"");

                danhsach.addKhachHang(kh);

    }

    private void doTiep()

    {

        editten.setText("");

        editsoluong.setText("");

        txtthanht.setText("");

        txtthanht.requestFocus();

    }

    private void doThongKe()

    {

        txttongkh.setText(danhsach.tongKhachHang()+"");

                txttongv.setText(danhsach.tongKhachHangVip()+"");

                        txttongdt.setText(danhsach.tongDoanhThu()+"");

    }

    private void doThoat()

    {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("hỏi thoát chương trình");

        builder.setMessage("Muốn thoát chương trình này khong?");

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }

        });

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                finish();

            }

        });

        builder.create().show();

    }



    private class ProcessMyEvent implements View.OnClickListener

    {

        @Override

        public void onClick(View arg0) {

            switch (arg0.getId())

            {

                case R.id.btTinhtien:

                    doTinhTien();

                    break;

                case R.id.btTiep:

                    doTiep();

                    break;

                case R.id.btThongke:

                    doThongKe();

                    break;

                case R.id.imageButton:

                    doThoat();

                    break;

            }

        }

    }
}
