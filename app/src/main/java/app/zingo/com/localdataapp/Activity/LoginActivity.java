package app.zingo.com.localdataapp.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import app.zingo.com.localdataapp.MainActivity;
import app.zingo.com.localdataapp.R;




public class LoginActivity extends AppCompatActivity {

    private EditText mLoginUserName,mLoginPassword;
    private TextView mLoginBtn;
    //private FlatButton ok_signup;
    private ProgressDialog progressDialog;
    //HotelDetails details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN|
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        getSupportActionBar().setTitle("Login");

        mLoginUserName = (EditText) findViewById(R.id.login_email_or_user_id);
        mLoginPassword = (EditText) findViewById(R.id.login_password);
        mLoginBtn = (TextView)findViewById(R.id.login_btn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(LoginWithActivity.this, EnterProfileActivity.class);
//                startActivity(i);
//                finish();
                String loginEmail = mLoginUserName.getText().toString().trim();
                String loginPassword = mLoginPassword.getText().toString().trim();

                if(loginEmail == null || loginEmail.isEmpty())
                {
                    mLoginUserName.setError("Enter valid email/user name");
                    mLoginUserName.requestFocus();
                }
                /*else if(Patterns.EMAIL_ADDRESS.matcher(loginEmail).matches())
                {
                    mLoginUserName.setError("Enter valid email");
                    mLoginUserName.requestFocus();
                }*/
                else if(loginPassword == null || loginPassword.isEmpty())
                {
                    mLoginPassword.setError("Enter valid password");
                    mLoginPassword.requestFocus();
                }
                else
                {
                    //login(loginEmail,loginPassword);
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    LoginActivity.this.finish();
                }




            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    /*private void login( final String username, final String password){

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("please wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();
        final Profile1 p = new Profile1();
        p.setUserName(username);
        p.setPassword(password);

        new ThreadExecuter().execute(new Runnable() {
            @Override
            public void run() {


                IRegistrasionService apiService =
                        Util.getClient().create(IRegistrasionService.class);


                Call<ArrayList<Profile1>> call = apiService.loginApiByUsernamePassword(p);

                call.enqueue(new Callback<ArrayList<Profile1>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Profile1>> call, Response<ArrayList<Profile1>> response) {
//                List<RouteDTO.Routes> list = new ArrayList<RouteDTO.Routes>();
                        int statusCode = response.code();
                        *//*if (progressDialog != null)
                            progressDialog.dismiss();*//*
                        if (statusCode == 200 || statusCode == 201) {

                            ArrayList<Profile1> dto1 = response.body();//-------------------should not be list------------
                            if (dto1!=null && dto1.size()!=0) {
                                Profile1 dto = dto1.get(0);


                                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                                SharedPreferences.Editor spe = sp.edit();
                                spe.putInt(Constants.USER_ID, dto.getProfileId());
                                PreferenceHandler.getInstance(LoginActivity.this).setUserId(dto.getProfileId());
                                PreferenceHandler.getInstance(LoginActivity.this).setUserName(dto.getUserName());
                                PreferenceHandler.getInstance(LoginActivity.this).setUserFullName(dto.getFirstName());
                                spe.putString("FirstName", dto.getFirstName());
                                spe.putString("MiddleName", dto.getMiddleName());
                                spe.putString("LastName", dto.getLastName());
                                spe.putString("UserName", dto.getUserName());
                                spe.putString("Password", dto.getPassword());
                                spe.putString("UniqueId", dto.getUniqueId());
                                spe.putInt("CityId", dto.getCityId());
                                spe.putString("PlaceName", dto.getPlaceName());
                                spe.putString("Email", dto.getEmail());
                                spe.putString("PhoneNumber", dto.getPhoneNumber());
                                spe.putString("Address", dto.getAddress());
                                spe.putString("PinCode", dto.getPinCode());
                                spe.putInt("UserRoleId", dto.getUserRoleId());
                                spe.apply();

                                getHotels(dto.getProfileId(),progressDialog);
                                //PreferenceHandler.getInstance(LoginActivity.this).setUserRoleUniqueID("Luci-FrontOffice");
//                            String status = dto.getAddress();
                                //getUserRole(dto.getUserRoleId());
                                UserRole userRole = dto.get_userRole();
                                if(userRole != null)
                                {
                                    *//*System.out.println("Unique id = "+userRole.getUserRoleUniqueId());*//*
                                    PreferenceHandler.getInstance(LoginActivity.this).setUserRoleUniqueID(userRole.getUserRoleUniqueId());
                                }


                            }else{
//                                startProfileActivity(isFb,fname,mname,lName,email,id);
                                *//*if (progressDialog != null)
                                    progressDialog.dismiss();*//*
                                Toast.makeText(LoginActivity.this, "Login credentials are wrong..", Toast.LENGTH_SHORT).show();

                            }
                        }else {
                            if (progressDialog!=null)
                                progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Login failed due to status code:"+statusCode, Toast.LENGTH_SHORT).show();
                        }
//                callGetStartEnd();
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Profile1>> call, Throwable t) {
                        // Log error here since request failed
                        if (progressDialog!=null)
                            progressDialog.dismiss();
                        Log.e("TAG", t.toString());
                    }
                });
            }
        });
    }

    private void getHotels(final int userId, final ProgressDialog dialog) {

        *//*final ProgressDialog dialog = new ProgressDialog(LoginActivity.this);
        dialog.setMessage(getResources().getString(R.string.loader_message));
        dialog.setCancelable(false);
        dialog.show();*//*
        new ThreadExecuter().execute(new Runnable() {
            @Override
            public void run() {
                HotelOperations hotelOperation = Util.getClient().create(HotelOperations.class);
                Call<ArrayList<HotelDetails>> response = hotelOperation.getHotelByProfileId(userId);

                response.enqueue(new Callback<ArrayList<HotelDetails>>() {
                    @Override
                    public void onResponse(Call<ArrayList<HotelDetails>> call, Response<ArrayList<HotelDetails>> response) {
                        System.out.println("GetHotelByProfileId = "+response.code());
                        ArrayList<HotelDetails> hotelDetailseResponse = response.body();
                        if(dialog != null && dialog.isShowing())
                        {
                            dialog.dismiss();
                        }
                        if(response.code() == 200)
                        {

                            //getRooms();
                            if(hotelDetailseResponse != null && hotelDetailseResponse.size() != 0)
                            {
                                details = hotelDetailseResponse.get(0);
                                PreferenceHandler.getInstance(LoginActivity.this).setHotelId(details.getHotelId());
                                PreferenceHandler.getInstance(LoginActivity.this).setHotelName(details.getHotelName());


                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(i);
                                LoginActivity.this.finish();

                                // getRooms();

                              *//*  if(PreferenceHandler.getInstance(getActivity()).getHotelApproved())
                                {*//*
                                //setUpGridview(details.getApproved());
                                *//*if(details.getApproved())
                                {
                                    System.out.println("Hotel id"+details.getHotelId());
                                    PreferenceHandler.getInstance(LoginActivity.this).setHotelApproved(details.getApproved());
                                   // getRooms();
                                }
                                else
                                {
                                    Toast.makeText(LoginActivity.this,"Your hotel is not approved yet",Toast.LENGTH_SHORT).show();
                                }*//*
                                //}
                                *//*details = hotelDetailseResponse.get(0);
                                *//*//**//*System.out.println("Hotel name = "+details.getHotelName());
                                System.out.println("Hotel id = "+details.getHotelId());*//*//**//*
                                System.out.println("Hotel id = "+details.getHotelId());
                                mHotelName.setText(details.getHotelName());
                                mHotelDisplayName.setText(details.getHotelDisplayName());
                                for (int i=0;i<hotelTypes.length;i++)
                                {
                                    if(hotelTypes[i].equals(details.getHotelType()))
                                    {
                                        mHotelTypeSpinner.setSelection(i);
                                        break;
                                    }
                                }
                                if(chainsList != null)
                                {
                                    for (int i=0;i<chainsList.size();i++)
                                    {
                                        if(chainsList.get(i).getChainName().equals(details.getChainName()))
                                        {
                                            mChainNameSpinner.setSelection(i);
                                            break;
                                        }
                                    }
                                }
                                mStarRating.setText(details.getStarRating());
                                mBuiltYear.setText(details.getHotelBuiltYear());
                                mNOofRestuarents.setText(details.getNoofRestuarentsInHotel());
                                mNoOfRooms.setText(details.getNoOfRoomsInHotel());
                                mNoofFloors.setText(details.getNoOfFloorsInHotel());
                                mCurrency.setText(details.getCurrencyAccepted());
                                mVccCurrency.setText(details.getVccCurrencyAccepted());
                                mTimeZone.setText(details.getHotelTimeZone());
                                mStreetAddress.setText(details.getHotelStreetAddress());
                                mCheckInTime.setText(details.getStandardCheckInTime());
                                mCheckOutTime.setText(details.getStandardCheckOutTime());
                                //mState.setText(details.get());
                                m24HrCheckIn.setChecked(details.getIs24HoursCheckIn());*//*
                                *//*mBuiltYear.setText(details.getHotelBuiltYear());
                                mBuiltYear.setText(details.getHotelBuiltYear());
                                mBuiltYear.setText(details.getHotelBuiltYear());
                                mBuiltYear.setText(details.getHotelBuiltYear());
                                mBuiltYear.setText(details.getHotelBuiltYear());
                                mBuiltYear.setText(details.getHotelBuiltYear());*//*
                                *//*mHotelPlace.setText(details.getHotelStreetAddress());
                                hotelOverviewlayout.setVisibility(View.VISIBLE);*//*
                                *//*PreferenceHandler.getInstance(getActivity()).setHotelId(details.getHotelId());
                                PreferenceHandler.getInstance(getActivity()).setHotelName(details.getHotelName());
                                mAddHotelBtn.setVisibility(View.GONE);*//*
                            }

                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this,"Check your internet connection or please try after some time",
                                    Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<ArrayList<HotelDetails>> call, Throwable t) {
                        System.out.println("Failed");

                        if(dialog != null && dialog.isShowing())
                        {
                            dialog.dismiss();
                        }
                        Toast.makeText(LoginActivity.this,"Check your internet connection or please try after some time",
                                Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }*/
    /*private void getUserRole(int userRoleId) {

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("please wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();


        new ThreadExecuter().execute(new Runnable() {
            @Override
            public void run() {


                UserRoleApi apiService =
                        Util.getClient().create(UserRoleApi.class);


                Call<ArrayList<Profile1>> call = apiService.apiGetRolesByUniqueId(p);

                call.enqueue(new Callback<ArrayList<Profile1>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Profile1>> call, Response<ArrayList<Profile1>> response) {
//                List<RouteDTO.Routes> list = new ArrayList<RouteDTO.Routes>();
                        int statusCode = response.code();
                        if (progressDialog != null)
                            progressDialog.dismiss();
                        if (statusCode == 200 || statusCode == 201) {



                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(i);
                                finish();
                            }else{
//                                startProfileActivity(isFb,fname,mname,lName,email,id);
                                *//*if (progressDialog != null)
                                    progressDialog.dismiss();*//*
                                Toast.makeText(LoginActivity.this, "Login credentials are wrong..", Toast.LENGTH_SHORT).show();

                            }
                        }else {
                            if (progressDialog!=null)
                                progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Login failed due to status code:"+statusCode, Toast.LENGTH_SHORT).show();
                        }
//                callGetStartEnd();
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Profile1>> call, Throwable t) {
                        // Log error here since request failed
                        if (progressDialog!=null)
                            progressDialog.dismiss();
                        Log.e("TAG", t.toString());
                    }
                });
            }
        });
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case android.R.id.home:
                this.finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
