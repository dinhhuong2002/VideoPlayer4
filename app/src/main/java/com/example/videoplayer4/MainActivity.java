package com.example.videoplayer4;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.videoplayer4.ui.home.HomeFragment;
import com.example.videoplayer4.ui.notifications.NotificationsFragment;
import com.example.videoplayer4.ui.playlist.DashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.videoplayer4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    String TAG="VideoPlayer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.navView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                replaceFragment(new HomeFragment());
                Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.navigation_dashboard) {
                replaceFragment(new DashboardFragment());
                Toast.makeText(getApplicationContext(),"Playlist",Toast.LENGTH_SHORT).show();
                Log.d(TAG,"PlaylistFragment");
            } else if(itemId == R.id.navigation_notifications){
                replaceFragment(new NotificationsFragment());
                Toast.makeText(getApplicationContext(),"Notifications",Toast.LENGTH_SHORT).show();
            }
            return false;
        });

    }

    //   switch fragment
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_activity_main,fragment);
        fragmentTransaction.commit();
    }

}