package com.bohra.navigationdrawerandbottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private BottomNavigationView bottomNav;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        bottomNav = findViewById(R.id.bottomNav);

        navController = Navigation.findNavController(this,R.id.nav_host_fragment);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment,R.id.bookmarkFragment,R.id.aboutFragment)
                .setDrawerLayout(drawer)
                .build();

        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);


        NavigationUI.setupWithNavController(navigationView,navController);

        //Bottom navigation
        NavigationUI.setupWithNavController(bottomNav,navController);

    }

//    //for handeling back button click

    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

    // if navigation drawer then on pressing back it should close
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }
}
