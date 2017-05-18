package com.example.nt.bai11;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ehoten, ecmnd, ettbs;
    Button btguithongtin;
    RadioButton rtc, rcd, rdh;
    CheckBox cdb, cds, cdc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ehoten = (EditText)findViewById(R.id.editten);
        ecmnd =(EditText)findViewById(R.id.editcmnd);
        ettbs =(EditText)findViewById(R.id.editttbs);
        rtc = (RadioButton)findViewById(R.id.radiontrungcap);
        rcd = (RadioButton)findViewById(R.id.radioncaodang);
        rdh =(RadioButton)findViewById(R.id.radiondaihoc);
        cdb= (CheckBox)findViewById(R.id.checkdb);
        cds= (CheckBox)findViewById(R.id.checkds);
        cdc= (CheckBox)findViewById(R.id.checkdc);
        btguithongtin= (Button)findViewById(R.id.button) ;

        btguithongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                hienthi();
            }
        });

    }
    public void hienthi()
    {
        // kiem tra ten hop le ( ir nhat co 3 ky tu )
        String ten =ehoten.getText()+"";
        ten= ten.trim();
        if(ten.length()<3 )
        {
            ehoten.requestFocus();
            ehoten.selectAll();
            Toast.makeText(this,"Tên phải >= 3 ký tự ",Toast.LENGTH_LONG).show();
            return;
        }
        // kiem tra chung minh nhan dan co hop le khong
        String cm=ecmnd.getText()+"";
        cm=cm.trim();
        if(cm.length()!=9)
        {
            ecmnd.requestFocus();
            ecmnd.selectAll();
            Toast.makeText(this,"Số chứng minh nhân dân = 9 ký tự ",Toast.LENGTH_LONG).show();
            return;
        }
        //kiểm tra bằng cấp
        String bang="";
        RadioGroup group=(RadioGroup)findViewById(R.id.radiogroup);
        int id =group.getCheckedRadioButtonId();
        if(id==-1)
        {
            Toast.makeText(this,"Phải chọn bằng cấp",Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad = (RadioButton)findViewById(id);
        bang=rad.getText()+"";
        //Kiểm tra sở thích
        String sothich="";
        if(cdb.isChecked())
            sothich+=cdb.getText()+"\n";
        if(cds.isChecked())
            sothich+=cds.getText()+"\n";
        if(cdc.isChecked())
            sothich+=cdc.getText()+"\n";
        String bosung=ettbs.getText()+"";
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                dialog.cancel();
            }
        });
//tạo nội dung
        String msg=ten+"\n";
        msg+= cm+"\n";
        msg+=bang+"\n";
        msg+=sothich;
        msg+="—————————– \n";
        msg+="Thông tin bổ sung: \n";
        msg+=bosung+ "\n";
        msg+="—————-————–";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }


}
