package com.eugenealvizo.samplegson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by eugene on 5/18/17.
 */

public class WatchAdapter extends BaseAdapter {

    Context context;
    List<Watch> dataList;

    private View vi;
    private ViewHolder viewHolder;
    private static LayoutInflater inflater = null;


    public WatchAdapter(Context context, List<Watch> dataList){
        this.context = context;
        this.dataList = dataList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        vi = view;
        //Populate the Listview
        final int pos = position;
        Watch watch = dataList.get(pos);
        if(vi == null) {
            vi = inflater.inflate(R.layout.listitem_watch, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) vi.findViewById(R.id.watchnameTxt);
            viewHolder.price = (TextView) vi.findViewById(R.id.watchpriceTxt);
            vi.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) view.getTag();

        viewHolder.name.setText(watch.getName());
        viewHolder.price.setText(watch.getPrice());

        return vi;
    }

    public class ViewHolder{
        TextView name;
        TextView price;
    }

}
