package com.ts.dagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ts.dagger.app.MyApp;
import com.ts.dagger.bean.A;
import com.ts.dagger.bean.B;
import com.ts.dagger.bean.C;
import com.ts.dagger.bean.DataManager;
import com.ts.dagger.bean.E;
import com.ts.dagger.bean.Manager;
import com.ts.dagger.debug.Debug;
import com.ts.dagger.di.component.DaggerMainComponent;
import com.ts.dagger.di.component.DaggerUserComponent;
import com.ts.dagger.di.module.MainModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /***
     * 第二步  使用Inject 注解，获取到A 对象的实例
     */
//    @Named("default")
//    @Inject
//    A a;
//
//    @Named("a")
//    @Inject
//    A a1;
//
//    @Inject
//    C c;

    @Inject
    B b;

    @Inject
    B b1;

    @Inject
    E e;

    @Inject
    Manager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .appComponent(((MyApp)getApplication()).getAppComponent())
                .build().inject(this);
//        c.print();
//        com.ts.dagger.debug.Debug.d("A",a+"");
//        com.ts.dagger.debug.Debug.d("A",a1+"");

        com.ts.dagger.debug.Debug.d("B",b+"");
        com.ts.dagger.debug.Debug.d("B",b1+"");
        com.ts.dagger.debug.Debug.d("E",e+"");
        Debug.d("datamanager" , dataManager+"");
        dataManager.manage();
        startLoginActivity();
    }

    void startLoginActivity(){
        Intent intent = new Intent();
        intent.setClass(this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
