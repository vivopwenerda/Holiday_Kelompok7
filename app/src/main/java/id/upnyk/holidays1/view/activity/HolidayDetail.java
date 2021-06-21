package id.upnyk.holidays1.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import id.upnyk.holidays1.R;

public class HolidayDetail extends AppCompatActivity {

    TextView detailTgl, detailHariBesar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_detail);

        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.arrow_back);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        detailTgl = findViewById(R.id.tvTanggal);
        detailHariBesar = findViewById(R.id.tvHoliday);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String getDate = bundle.getString("hdDay");
            String getName = bundle.getString("hdName");

            detailTgl.setText(getDate);
            detailHariBesar.setText(getName);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}