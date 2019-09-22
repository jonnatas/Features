package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        adapter.AddFragment(new CallFragment(), "");
        adapter.AddFragment(new ContactFragment(), "");
        adapter.AddFragment(new FavFragment(), "");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_call_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_contact_phone);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_favorite);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
