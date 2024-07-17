package fpt.huyntph.lap1.demo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import fpt.huyntph.lap1.R;

public class Demo43MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo43_main);
        viewPager=findViewById(R.id.demo43ViewPager);
        tabLayout=findViewById(R.id.demo43Tablyout);
        addTabLayout(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
    //viet ham addTabLayout
    public void addTabLayout(ViewPager viewPager){
        //Tao moi adapter
        Demo43Adapter adapter=new Demo43Adapter(getSupportFragmentManager());
        //them fragmemt vao adapter
        adapter.addFrag(new BlankFragment41(),"ONE");
        adapter.addFrag(new BlankFragment42(),"TWO");
        adapter.addFrag(new BlankFragment43(),"THREE");
        //dua adapter vao viewpager
        viewPager.setAdapter(adapter);
    }
}