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

public class ActivityFourthForm extends AppCompatActivity {
    FlatButton mContinue;
    EditText mGuestReq,mID,mServiceDesc,mServiceAvail,mPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_form);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Activity Details");

        mContinue = (FlatButton) findViewById(R.id.submit_td4);
        mGuestReq = (EditText)findViewById(R.id.activity_guest_req);
        mID = (EditText)findViewById(R.id.activity_id_proof);
        mServiceDesc = (EditText)findViewById(R.id.activity_service_desc);
        mServiceAvail = (EditText)findViewById(R.id.activity_service_avail);
        mPolicy = (EditText)findViewById(R.id.activity_policy);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate();
                Intent fourth = new Intent(getApplicationContext(),ActivityImageList.class);
                startActivity(fourth);
            }
        });
    }

    public void validate(){
        String guest = mGuestReq.getText().toString();
        String id = mID.getText().toString();
        String serviceDesc = mServiceDesc.getText().toString();
        String serviceavail = mServiceAvail.getText().toString();
        String policy = mPolicy.getText().toString();

        if(guest == null || guest.isEmpty()){
            mGuestReq.setError("Please fill the field");
            mGuestReq.requestFocus();
        }else if(id == null || id.isEmpty()){
            mID.setError("Please fill the field");
            mID.requestFocus();
        }else if(serviceDesc == null || serviceDesc.isEmpty()){
            mServiceDesc.setError("Please fill the field");
            mServiceDesc.requestFocus();
        }else if(serviceavail == null || serviceavail.isEmpty()){
            mServiceAvail.setError("Please fill the field");
            mServiceAvail.requestFocus();
        }else if(policy == null || policy.isEmpty()){
            mPolicy.setError("Please fill the field");
            mPolicy.requestFocus();
        }else {
            Intent fourth = new Intent(getApplicationContext(),ActivityImageList.class);
            startActivity(fourth);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case android.R.id.home:
                ActivityFourthForm.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
