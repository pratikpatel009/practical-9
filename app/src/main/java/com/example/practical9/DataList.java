package com.example.practical9;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataList extends AppCompatActivity {
    ListView listView;
    List<Students> studentsList;

    DatabaseReference lr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        listView=findViewById(R.id.lv1);
        studentsList=new ArrayList<>();

        lr=FirebaseDatabase.getInstance().getReference("Students");
        lr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                studentsList.clear();
                registerForContextMenu(listView);
                for(DataSnapshot studentsnapshot:snapshot.getChildren()){

                    Students students=studentsnapshot.getValue(Students.class);
                    studentsList.add(students);
                }
                ListAdapter adapter=new ListAdapter(DataList.this,studentsList);
                listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
            }
        });
    }
}
