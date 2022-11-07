package com.example.practical9;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class ListAdapter extends ArrayAdapter {
    private Activity mcontext;
    List<Students> studentsList;
    public ListAdapter(Activity mcontext,List<Students> studentsList){
        super(mcontext,R.layout.activity_list_items,studentsList);
        this.mcontext=mcontext;
        this.studentsList=studentsList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=mcontext.getLayoutInflater();
        View listItemView =inflater.inflate(R.layout.activity_list_items,null,true);
        TextView tvName=listItemView.findViewById(R.id.tvn);
        TextView tvBranch=listItemView.findViewById(R.id.tvbr);
        Students students=studentsList.get(position);
        tvName.setText(students.getName());
        tvBranch.setText(students.getEnrollmentNumber());
        return listItemView;
    }
}
