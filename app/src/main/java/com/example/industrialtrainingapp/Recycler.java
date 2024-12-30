package com.example.industrialtrainingapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Objects;
public class Recycler extends AppCompatActivity   {
    RecyclerView recyclerView;
    FirebaseFirestore firestore;
    ArrayList<itemlist> list;
    ArrayList<DocumentSnapshot> documents;
    recycleradapter adapter;
    SearchView searchView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView=findViewById(R.id.recycle);
        searchView=findViewById(R.id.searchview);
        searchView.clearFocus();

        firestore=FirebaseFirestore.getInstance();
        list=new ArrayList<>();
        adapter=new recycleradapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LoadData();

        // it means when we click on the search box it begin to start searching
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override

            // it means when we have written what we have to search and then click on the search part we will get that data
            // but right now we have make it false becz we dont want it
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            // it is used ,, when we right something in seach view it chnage acc to it immediately
            // means as we have written a in the search view it give the data acc to it instantly related to it
            @Override
            public boolean onQueryTextChange(String s) {

                // we have make the method filterlist that take the string as the parameter
                // and make it true so that it returns
                filterList(s);
                return true;
            }
        });

    }

    private void filterList(String text) {

        // we have pass the list of the data that we have shown in the recycler view it name and roll that is present in the
        // itemlist
        ArrayList<itemlist>filteredList=new ArrayList<>();
        String searchTextLower = text.toLowerCase();
        // datatype is itemlist  becz we have to fetch from it
        // list is the array
        for(itemlist item:list)
        {
            if (item.getName().toLowerCase().contains(searchTextLower) ||
                    item.getRoll().toLowerCase().contains(searchTextLower))
                filteredList.add(item);

        }
        if(filteredList.isEmpty()){
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
        else{
                adapter.setFilteredList(filteredList);
        }

    }
    private void LoadData() {
       list.clear();

            firestore.collection("users")
                    // here we can also use new event listener in the parameters becz there also we get the data from the
                    // value and the error from the error
        .addSnapshotListener((value, error) -> {
            if(error!=null){
                Log.e(TAG, "Failed to load data", error);
                Toast.makeText(this, "list loaded", Toast.LENGTH_SHORT).show();
                return;
            }
            for(DocumentChange dc : Objects.requireNonNull(value).getDocumentChanges()){
                if(dc.getType()==DocumentChange.Type.ADDED){
                    DocumentSnapshot documentSnapshot = dc.getDocument();
                    Log.d(TAG, "DocumentSnapshot: " + documentSnapshot.getData());
                    itemlist newItem = dc.getDocument().toObject(itemlist.class);
                    list.add(newItem);
                }
                adapter.notifyDataSetChanged();
                Log.d(TAG, "Data loaded successfully");
            }
        });

    }

}