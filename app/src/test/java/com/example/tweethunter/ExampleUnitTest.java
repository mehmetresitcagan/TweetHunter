package com.example.tweethunter;

import org.junit.Test;

import static org.junit.Assert.*;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    FirebaseFirestore db= FirebaseFirestore.getInstance();
    CollectionReference colRef = db.collection("test");

    @Test
    public void testAddTweet() {
        Map<String, String> data = new HashMap<>();
        data.put("test","test1");
        colRef.add(data);
        db.collection("test").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful())
                {
                    int result = 0;
                    for(QueryDocumentSnapshot document:task.getResult())
                    {
                        result++;
                    }
                    assertTrue(result > 0);
                }
            }
        });
    }
}