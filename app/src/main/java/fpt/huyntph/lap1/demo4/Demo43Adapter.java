package fpt.huyntph.lap1.demo4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Demo43Adapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList=new ArrayList<>();//list chua fragment
    private final List<String> fragmentTitle=new ArrayList<>();//list chua title
    public Demo43Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    //viet phuong thuc lay title
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
    //viet phuong thuc them fragment
    public void addFrag(Fragment fragment,String title){
        fragmentList.add(fragment);
        fragmentTitle.add(title);
    }
}
