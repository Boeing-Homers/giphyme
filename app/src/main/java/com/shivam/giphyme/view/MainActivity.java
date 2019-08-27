package com.shivam.giphyme.view;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.shivam.giphyme.R;
import com.shivam.giphyme.model.Data;
import com.shivam.giphyme.repository.GiphyRepository;
import com.shivam.giphyme.view.adaptor.GifAdaptor;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private GifAdaptor gifAdaptor;
    private String query = "dogs";

    @BindView(R.id.gif_recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.et_search)
    EditText searchEditText;

    @BindView(R.id.ib_search)
    ImageButton searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        setUpList();
        setUpClickListners();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Refresh results", Snackbar.LENGTH_LONG)
                        .setAction("Reload", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                setGif(query);
                            }
                        }).show();
            }
        });
    }

    private void setUpClickListners() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyBoard(searchEditText);
                performQuery();

            }
        });
    }

    private void performQuery() {
        String text = searchEditText.getText().toString();
        this.query = text;
        if (text.isEmpty()) {
            Toast.makeText(this, "Enter search query first", Toast.LENGTH_SHORT).show();
        } else {
            setGif(text);
        }
    }


    private void setGif(String query) {
        LiveData<List<Data>> listLiveData = GiphyRepository.getInstance().getGiphyData(query, new GiphyRepository.callback() {
            @Override
            public void onSucces(List<Data> data) {
                gifAdaptor = new GifAdaptor(data);
                recyclerView.setAdapter(gifAdaptor);
            }
        });

    }


    private void setUpList() {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        setGif(this.query);
    }

    private void hideKeyBoard(View view) {
        if(view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager) getSystemService((Context.INPUT_METHOD_SERVICE));
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
