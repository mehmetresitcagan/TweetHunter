package com.example.tweethunter;

import static android.content.ContentValues.TAG;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.annotation.Native;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private List<String> tweets=new ArrayList<String>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //========Deniz Seçmen======
        Thread gettweets = new Thread(new Runnable() {
            @Override
            public void run() {
                FirebaseFirestore db= FirebaseFirestore.getInstance();
                CollectionReference colRef = db.collection("tweets");
                db.collection("tweets").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful())
                        {
                            for(QueryDocumentSnapshot document:task.getResult())
                            {

                                Log.d(TAG,document.getId()+"=>"+document.getData());
                                tweets.add(String.valueOf(document.getData()));
                            }
                        }

                    }
                });
            }
        });
        gettweets.start();
        //==========================
        Button btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });
    }
}