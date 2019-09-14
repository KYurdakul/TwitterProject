package com.example.kerem.twitterproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.kerem.twitterproject.Contract.MainActivityContract;
import com.example.kerem.twitterproject.R;
import com.example.kerem.twitterproject.adapter.RecyclerViewAdapter;
import com.example.kerem.twitterproject.model.TwitterData;
import com.example.kerem.twitterproject.presenter.TwitterPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainActivityContract.View {

    TwitterPresenter twitterPresenter;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    EditText editQuery;
    Button searchButton;
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editQuery = findViewById(R.id.edit_query);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.bringToFront();
        searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(this);
        textView = findViewById(R.id.no_results_text);

        recyclerView = findViewById(R.id.recycler_layout);
        twitterPresenter = new TwitterPresenter(MainActivity.this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    public void onClick(View view){
        progressBar.setVisibility(View.VISIBLE);
        String searchedQuery = editQuery.getText().toString();
        twitterPresenter.getTwitter(searchedQuery);
    }


    @Override
    public void TwitterView(TwitterData twitter) {
        adapter = new RecyclerViewAdapter(twitter.getStatuses(), getApplicationContext());
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void TwitterAPIError(String errorMsg) {
        Toast.makeText(MainActivity.this,"API ERROR"+"\n"+errorMsg,Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void EmptyValues() {
        Toast.makeText(MainActivity.this,"Empty Values, Please Try Again",Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void UnknownValue() {
        Toast.makeText(MainActivity.this,"No Results Found",Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.INVISIBLE);
    }


}
