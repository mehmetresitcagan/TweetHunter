package com.example.tweethunter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AddTweetFragment extends Fragment {
    private EditText textEditText;
    private Button submitButton;
    private List<String> tweets=new ArrayList<String>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRefer = database.getReference("tweets");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_tweet, container, false);
        textEditText = view.findViewById(R.id.text_edit_text);
        submitButton = view.findViewById(R.id.submit_button);
        FirebaseFirestore db= FirebaseFirestore.getInstance();
        CollectionReference colRef = db.collection("tweets");
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> data = new HashMap<>();
                data.put("tweet",textEditText.getText().toString());
                colRef.add(data);
                db.collection("tweets").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful())
                        {
                          for(QueryDocumentSnapshot document:task.getResult())
                          {
                              ;
                              Log.d(getTag(),document.getId()+"=>"+document.getData());
                              tweets.add(String.valueOf(document.getData()));
                              System.out.println(tweets);
                              System.out.println(textEditText.getText().toString());
                          }
                            String text = textEditText.getText().toString();
                            HomeFragment homeFragment = HomeFragment.newInstance(String.valueOf(tweets));
                            getFragmentManager().beginTransaction()
                                    .replace(R.id.fragment_container, homeFragment)
                                    .addToBackStack(null)
                                    .commit();
                        }

                    }
                });

            }
        });


        return view;
    }
}