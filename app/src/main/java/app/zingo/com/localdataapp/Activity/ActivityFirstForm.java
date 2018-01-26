package app.zingo.com.localdataapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dd.processbutton.FlatButton;

import app.zingo.com.localdataapp.R;

public class ActivityFirstForm extends AppCompatActivity {

    FlatButton mContinue;
    EditText mCategory,mTitle,mDesc,mInterest,mHighlight,mAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_form);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Activity Details");

        mContinue = (FlatButton)findViewById(R.id.submit_td);
        mCategory = (EditText)findViewById(R.id.activity_category);
        mTitle = (EditText)findViewById(R.id.activity_title);
        mDesc = (EditText)findViewById(R.id.activity_desc);
        mInterest = (EditText)findViewById(R.id.activity_interest);
        mHighlight = (EditText)findViewById(R.id.activity_highlight);
        mAbout = (EditText)findViewById(R.id.activity_about);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first = new Intent(ActivityFirstForm.this,ActivitySecondForm.class);
                startActivity(first);
            }
        });
    }

    public void validate(){
        String category = mCategory.getText().toString();
        String title = mTitle.getText().toString();
        String desc = mDesc.getText().toString();
        String interest = mInterest.getText().toString();
        String highlights = mHighlight.getText().toString();
        String about = mAbout.getText().toString();

        if(category == null || category.isEmpty()){
            mCategory.setError("Please fill the field");
            mCategory.requestFocus();
        }else if(title == null || title.isEmpty()){
            mTitle.setError("Please fill the field");
            mTitle.requestFocus();
        }else if(desc == null || desc.isEmpty()){
            mDesc.setError("Please fill the field");
            mDesc.requestFocus();
        }else if(interest == null || interest.isEmpty()){
            mInterest.setError("Please fill the field");
            mInterest.requestFocus();
        }else if(highlights == null || highlights.isEmpty()){
            mHighlight.setError("Please fill the field");
            mHighlight.requestFocus();
        }else if(about == null || about.isEmpty()){
            mAbout.setError("Please fill the field");
            mAbout.requestFocus();
        }else{
            Intent first = new Intent(ActivityFirstForm.this,ActivitySecondForm.class);
            startActivity(first);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case android.R.id.home:
                ActivityFirstForm.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
