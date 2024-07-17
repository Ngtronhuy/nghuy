package fpt.huyntph.lap1.demo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import fpt.huyntph.lap1.R;

public class Demo41MainActivity extends AppCompatActivity {
    Button btn;
    EditText txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo41_main);
        //anh xa
        btn=findViewById(R.id.demo41btn1);
        txt=findViewById(R.id.demo41txt1);
        //xu ly su kien
        btn.setOnClickListener(v->{
        //Doi tuong quan ly Fragment
       FragmentManager fragmentManager=getSupportFragmentManager();
        //anh xa fragment
            BlankFragment41 fragment41=(BlankFragment41) fragmentManager
                    .findFragmentById(R.id.Fg41);
        //truyen du lieu tu activity sang fragment
         fragment41.txt1.setText(txt.getText().toString());
    });
}
}