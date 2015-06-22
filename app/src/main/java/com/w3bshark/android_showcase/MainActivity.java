package com.w3bshark.android_showcase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Application> applications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        applications = new ArrayList<>();
        applications.add(new Application(getString(R.string.app_spotify_streamer), getString(R.string.descr_spotify_streamer), R.drawable.spotify));
        applications.add(new Application(getString(R.string.app_scores), getString(R.string.descr_scores), R.drawable.ic_assessment_black_48dp));
        applications.add(new Application(getString(R.string.app_library), getString(R.string.descr_library), R.drawable.ic_book_black_48dp));
        applications.add(new Application(getString(R.string.app_build_it_bigger), getString(R.string.descr_build_it_bigger), R.drawable.ic_cloud_black_48dp));
        applications.add(new Application(getString(R.string.app_xyz_reader), getString(R.string.descr_xyz_reader), R.drawable.ic_chrome_reader_mode_black_48dp));
        applications.add(new Application(getString(R.string.app_capstone), getString(R.string.descr_capstone), R.drawable.ic_android_black_48dp));
    }

    private void initializeAdapter(){
        RecyclerAdapter adapter = new RecyclerAdapter(applications);
        mRecyclerView.setAdapter(adapter);
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
