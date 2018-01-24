package app.zingo.com.localdataapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import app.zingo.com.localdataapp.R;

/**
 * Created by ZingoHotels.com on 18-12-2017.
 */

public class CategorySpinnerAdapter extends BaseAdapter {

    private Context context;
    private String[] list;

    public CategorySpinnerAdapter(Context context, String[] list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int i) {
        return list[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.category_spinner_adapter,viewGroup,false);
        }

        TextView tabName = (TextView) view.findViewById(R.id.category_spinner_item);
        tabName.setText(list[i].toString());

        return view;
    }
}
