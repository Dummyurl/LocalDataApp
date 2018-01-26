package app.zingo.com.localdataapp.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.processbutton.FlatButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import app.zingo.com.localdataapp.R;

public class ActivityThirdForm extends AppCompatActivity {

    FlatButton mContinue;
    EditText mCome,mGroup,mAdultDP,mAdultSP,mChildDP,mChildSP;
    TextView mFrom,mTo;
    Spinner mDuration;
    private int mYear,mMonth,mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_form);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Activity Details");

        mContinue = (FlatButton) findViewById(R.id.submit_td3);
        mDuration = (Spinner)findViewById(R.id.activity_duration);
        mFrom = (TextView)findViewById(R.id.activity_start_date);
        mTo = (TextView)findViewById(R.id.activity_end_date);
        mCome = (EditText)findViewById(R.id.activity_come);
        mGroup = (EditText)findViewById(R.id.activity_group_size);
        mAdultDP = (EditText)findViewById(R.id.activity_adult_price_display);
        mAdultSP = (EditText)findViewById(R.id.activity_adult_price_sell);
        mChildDP = (EditText)findViewById(R.id.activity_child_price_display);
        mChildSP = (EditText)findViewById(R.id.activity_child_price_sell);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate();
                Intent third = new Intent(ActivityThirdForm.this,ActivityFourthForm.class);
                startActivity(third);
            }
        });

        mFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker(mFrom);
            }
        });

        mTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker(mTo);
            }
        });
    }

    public void openDatePicker(final TextView tv) {
        // Get Current Date



        final Calendar c = Calendar.getInstance();
        mYear  = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay   = c.get(Calendar.DAY_OF_MONTH);
        //launch datepicker modal
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String from,to;
                        Log.d("Date", "DATE SELECTED "+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year,monthOfYear,dayOfMonth);


                        String date1 = (monthOfYear + 1)  + "/" + dayOfMonth + "/" + year;
                        String date2 = (monthOfYear + 1)  + "/" + (dayOfMonth+1) + "/" + year;

                       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");


                        if (tv.equals(mFrom)){

                            try {
                                Date fdate = simpleDateFormat.parse(date1);
                                Date tdate = simpleDateFormat.parse(date2);

                                from = simpleDateFormat.format(fdate);
                                to = simpleDateFormat.format(tdate);

                                System.out.println("To = "+from);
                                tv.setText(from);
                                mTo.setText(to);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            //


                        }else {
                            //to = date1;
                            try {
                                Date tdate = simpleDateFormat.parse(date1);
                                to = simpleDateFormat.format(tdate);
                                System.out.println("To = "+to);
                                tv.setText(to);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }



                    }
                }, mYear, mMonth, mDay);


        datePickerDialog.show();

    }

    public void validate(){
        String come = mCome.getText().toString();
        String group = mGroup.getText().toString();
        String adultDP = mAdultDP.getText().toString();
        String adultSP = mAdultSP.getText().toString();
        String childDP = mChildDP.getText().toString();
        String childSP = mChildSP.getText().toString();
        String from = mFrom.getText().toString();
        String to = mTo.getText().toString();

        if(come == null || come.isEmpty()){
            mCome.setError("Please fill the field");
            mCome.requestFocus();
        }else if(group == null || group.isEmpty()){
            mGroup.setError("Please fill the field");
            mGroup.requestFocus();
        }else if(adultDP == null || adultDP.isEmpty()){
            mAdultDP.setError("Please fill the field");
            mAdultDP.requestFocus();
        }else if(adultSP == null || adultSP.isEmpty()){
            mAdultSP.setError("Please fill the field");
            mAdultSP.requestFocus();
        }else if(childDP == null || childDP.isEmpty()){
            mChildDP.setError("Please fill the field");
            mChildDP.requestFocus();
        }else if(childSP == null || childSP.isEmpty()){
            mChildSP.setError("Please fill the field");
            mChildSP.requestFocus();
        }else if(from == null || from.isEmpty()){
            mFrom.setError("Please fill the field");
            mFrom.requestFocus();
        }else if(to == null || to.isEmpty()){
            mTo.setError("Please fill the field");
            mTo.requestFocus();
        }else{
            Intent third = new Intent(ActivityThirdForm.this,ActivityFourthForm.class);
            startActivity(third);
        }
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
