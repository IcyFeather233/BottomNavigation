package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.bottomnavigation.Adapter.SectionsPagerAdapter;
import com.example.bottomnavigation.Fragments.Fragment_Find;
import com.example.bottomnavigation.Fragments.Fragment_Home;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout myTab;
    private ViewPager2 myPager2;

    List<String> titles = new ArrayList<>();
    List<Integer> icons = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        myTab = findViewById(R.id.tab);
        myPager2 = findViewById(R.id.viewpager2);

        titles.add("查询");
        titles.add("我的");
        icons.add(R.drawable.ic_baseline_find_in_page_24);
        icons.add(R.drawable.ic_baseline_home_24);

        fragments.add(new Fragment_Find());
        fragments.add(new Fragment_Home());
        myTab.setTabMode(TabLayout.MODE_FIXED);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), getLifecycle(), fragments);
        myPager2.setAdapter(sectionsPagerAdapter);

        new TabLayoutMediator(myTab, myPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
                tab.setIcon(icons.get(position));
            }
        }).attach();
    }
}