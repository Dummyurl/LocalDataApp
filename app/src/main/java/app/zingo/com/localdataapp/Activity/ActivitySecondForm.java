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

public class ActivitySecondForm extends AppCompatActivity {

    FlatButton mContinue;
    EditText mAddress,mLocation,mMeet,mLanguage,mNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_form);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Activity Details");

        mAddress = (EditText)findViewById(R.id.activity_address);
        mLocation = (EditText)findViewById(R.id.activity_location_desc);
        mMeet = (EditText)findViewById(R.id.activity_meet);
        mLanguage = (EditText)findViewById(R.id.activity_language);
        mNotes = (EditText)findViewById(R.id.activity_notes);
        mContinue = (FlatButton)findViewById(R.id.submit_td2);


        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate();
                Intent second = new Intent(ActivitySecondForm.this,ActivityThirdForm.class);
                startActivity(second);
            }
        });
    }

    public void validate(){
        String address = mAddress.getText().toString();
        String location = mLocation.getText().toString();
        String meet = mMeet.getText().toString();
        String language = mLanguage.getText().toString();
        String notes = mNotes.getText().toString();

        if(address == null || address.isEmpty()){
            mAddress.setError("Please fill the field");
            mAddress.requestFocus();
        }else if(location == null || location.isEmpty()){
            mLocation.setError("Please fill the field");
            mLocation.requestFocus();
        }else if(meet == null || meet.isEmpty()){
            mMeet.setError("Please fill the field");
            mMeet.requestFocus();
        }else if(language == null || language.isEmpty()){
            mLanguage.setError("Please fill the field");
            mLanguage.requestFocus();
        }else if(notes == null || notes.isEmpty()){
            mNotes.setError("Please fill the field");
            mNotes.requestFocus();
        }else{
            Intent second = new Intent(ActivitySecondForm.this,ActivityThirdForm.class);
            startActivity(second);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case android.R.id.home:
                ActivitySecondForm.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
