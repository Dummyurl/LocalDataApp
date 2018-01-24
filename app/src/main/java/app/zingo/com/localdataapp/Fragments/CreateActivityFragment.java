package app.zingo.com.localdataapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import app.zingo.com.localdataapp.Activity.ActivityFirstForm;
import app.zingo.com.localdataapp.Adapter.CategorySpinnerAdapter;
import app.zingo.com.localdataapp.R;



/**
 * Created by CSC on 1/23/2018.
 */

public class CreateActivityFragment extends Fragment {

    private Spinner mCategory,mSubCategory;
    public LinearLayout mSubLayout;
    String[] categoryArray;
    Button mCreate;



    public CreateActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create_activity, container, false);

        mSubLayout = (LinearLayout) v.findViewById(R.id.sub_layout);
        mCategory = (Spinner) v.findViewById(R.id.category_title);
        mSubCategory = (Spinner) v.findViewById(R.id.category_sub_title);
        mCreate = (Button) v.findViewById(R.id.create_button);

        categoryArray = getResources().getStringArray(R.array.category_arrays);

        CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),categoryArray);
        mCategory.setAdapter(spinneradapter);

        mCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(categoryArray[position].equals("Sports"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Sports_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }
                else if(categoryArray[position].equals("Nightlife"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Nightlife_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }
                else if(categoryArray[position].equals("Eat & Drink"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Eat_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }
                else if(categoryArray[position].equals("Family Fun"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Family_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }
                else if(categoryArray[position].equals("Adventure"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Adventure_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }
                else if(categoryArray[position].equals("Arts & Culture"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Arts_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }
                else if(categoryArray[position].equals("Nature"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Nature_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }
                else if(categoryArray[position].equals("Health & Wellness"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Health_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }
                else if(categoryArray[position].equals("Classes & Workshops"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Classes_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }
                else if(categoryArray[position].equals("Outdoor Activities"))
                {
                    mSubLayout.setVisibility(View.VISIBLE);
                    String[] subCategoryArray = getResources().getStringArray(R.array.Outdoor_item);

                    CategorySpinnerAdapter spinneradapter = new CategorySpinnerAdapter(getActivity(),subCategoryArray);
                    mSubCategory.setAdapter(spinneradapter);
                }else{
                    mSubLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(getActivity(), ActivityFirstForm.class);
                startActivity(create);
            }
        });
        return  v;
    }


}
