package app.zingo.com.localdataapp.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import app.zingo.com.localdataapp.R;

public class ActivityImageList extends AppCompatActivity {

    private FloatingActionButton add_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Activity Images");

        add_image = (FloatingActionButton)findViewById(R.id.add_images);
        add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent image = new Intent(ActivityImageList.this,ActivityImageUpload.class);
                startActivity(image);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case android.R.id.home:
                ActivityImageList.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
