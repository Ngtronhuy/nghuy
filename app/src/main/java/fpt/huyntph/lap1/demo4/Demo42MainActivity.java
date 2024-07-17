package fpt.huyntph.lap1.demo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import fpt.huyntph.lap1.R;

public class Demo42MainActivity extends AppCompatActivity {
    Button btnAn,btnHien;
    BlankFragment41 frg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo42_main);
        btnAn=findViewById(R.id.demo42BtnAn);
        btnHien=findViewById(R.id.demo42BtnHien);
        btnAn.setOnClickListener(v->{
            //tao doi tuong quan ly fragment
            FragmentManager fragmentManager=getSupportFragmentManager();
            //anh xa fragment
            frg=(BlankFragment41) fragmentManager.findFragmentById(R.id.demo42Fr1);
            //an
            fragmentManager.beginTransaction()
                    .hide(frg)
                    .commit();
        });
        btnHien.setOnClickListener(v->{
            //tao doi tuong quan ly fragment
            FragmentManager fragmentManager=getSupportFragmentManager();
            //anh xa fragment
            frg=(BlankFragment41) fragmentManager.findFragmentById(R.id.demo42Fr1);
            //an
            fragmentManager.beginTransaction()
                    .show(frg)
                    .commit();
        });
    }
}