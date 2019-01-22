package com.example.myjsontolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    Context context;
    ArrayList<Student> list;
    LayoutInflater inflater;

    public ItemAdapter(Context context, ArrayList<Student> list) {
        super();
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemHandler handler = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.itemlayout,null);
            handler=new ItemHandler();
            handler.name=(TextView)convertView.findViewById(R.id.textView1);
            handler.course=(TextView)convertView.findViewById(R.id.textView2);
            handler.idno=(TextView)convertView.findViewById(R.id.textView3);
            convertView.setTag(handler);
        }
        else handler=(ItemHandler)convertView.getTag();

        handler.name.setText(list.get(position).getLastname()+", "+list.get(position).getFirstname());
        handler.course.setText(list.get(position).getCourse()+" - "+list.get(position).getLevel());
        handler.idno.setText(list.get(position).getIdno());

        return convertView;
    }

    static class ItemHandler{
        TextView name, course, idno;

    }
}
