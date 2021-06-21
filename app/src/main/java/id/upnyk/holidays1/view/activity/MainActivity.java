package id.upnyk.holidays1.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import id.upnyk.holidays1.R;
import id.upnyk.holidays1.view.fragment.HolidayList;
import id.upnyk.holidays1.view.fragment.MemoList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedfragment = new HolidayList();
    private BottomNavigationView bottomNavigationView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nb_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedfragment);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        switch (item.getItemId()){
            case R.id.date:
                selectedfragment = new HolidayList();
                loadFragment(selectedfragment);
                break;

            case R.id.note:
                selectedfragment = new MemoList();
                loadFragment(selectedfragment);
                break;
        }
        return loadFragment(selectedfragment);
    }

    private boolean loadFragment(Fragment selectedfragment) {
        if(selectedfragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_main_activity,selectedfragment)
                    .commit();
            return true;
        }
        return false;
    }
}