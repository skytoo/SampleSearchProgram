package com.law.samplesearchprogram;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchActivity extends Activity {

    //List view
    private ListView lv;

    //list view adapter
    ArrayAdapter<String> adapter;

    EditText inputSearch;

    ArrayList<HashMap<String, String>> stuffs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        //movies that will be added to the list
        String[] movies = {"The Shawshank Redemption","The Godfather",
                "The GodFather: Part II","Pulp Fiction","The Good, the Bad and the Ugly",
                "The Dark Knight","12 Angry Men","The Conjuring","Despicable Me 2","Turbo",
                "Grown Ups 2","Red 2"};

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        //adding items to the list view
        adapter = new ArrayAdapter<String>(this,R.layout.listitem_layout,R.id.productsName,movies);
        lv.setAdapter(adapter);

        //enabling the search functionality
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SearchActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    
}
