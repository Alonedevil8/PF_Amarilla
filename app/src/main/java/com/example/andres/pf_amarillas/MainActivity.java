package com.example.andres.pf_amarillas;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private String nombre1;
    Bundle bundle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        nombre1 = getIntent().getStringExtra("nombre1");



        bundle = new Bundle();
        bundle.putString("nombre1", nombre1);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());}

            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}

            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}

        };


        ActionBar .Tab tab = actionBar.newTab().setText("Buscar").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Categorias").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Perfil").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Acerca de...").setTabListener(tabListener);
        actionBar.addTab(tab);

        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            public void onPageSelect (int position) {
                getSupportActionBar().setSelectedNavigationItem(position);

            }}
        );
    }


    public  class PagerAdapter extends FragmentPagerAdapter{
        public PagerAdapter ( FragmentManager fm){
            super(fm); }

        public Fragment getItem(int position) {

                switch (position){
                case 0:  return new Fragment1();
                case 1:  return new Fragment2();
                case 2:  Fragment3 fragobj = new Fragment3();
                         fragobj.setArguments(bundle);
                         return fragobj;
                case 3:  return new Fragment4();
                default: return null;}
        }

        public int getCount() {
            return 4;}
    }
}



