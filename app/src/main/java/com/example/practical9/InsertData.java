package com.example.practical9;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import android.os.Bundle;

public class InsertData extends AppCompatActivity {
    DatabaseReference reff;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final EditText editText1=(EditText)findViewById(R.id.editTextTextPersonName);
        final EditText editText2=(EditText)findViewById(R.id.editTextTextPersonName2);
        Button button=(Button)findViewById(R.id.button);
        Students stu=new Students();
        reff= FirebaseDatabase.getInstance().getReference().child("Students");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxid=(snapshot.getChildrenCount());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stu.setName(editText1.getText().toString());
                stu.setEnrollmentNumber(editText2.getText().toString());
                reff.child(String.valueOf(maxid+1)).setValue(stu);
                Toast.makeText(InsertData.this, "Data inserted succesfully", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
