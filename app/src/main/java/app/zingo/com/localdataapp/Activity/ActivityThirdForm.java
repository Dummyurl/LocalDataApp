package app.zingo.com.localdataapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import app.zingo.com.localdataapp.R;

public class ActivityThirdForm extends AppCompatActivity {

    Button mContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_form);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Activity Details");

        mContinue = (Button) findViewById(R.id.submit_td3);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent third = new Intent(ActivityThirdForm.this,ActivityFourthForm.class);
                startActivity(third);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case android.R.id.home:
                ActivityThirdForm.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
