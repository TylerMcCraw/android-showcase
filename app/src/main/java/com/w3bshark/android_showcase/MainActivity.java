package com.w3bshark.android_showcase;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Application> applications;
    private View mCoordinatorLayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mCoordinatorLayoutView = findViewById(R.id.snackbarPosition);

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
        applications.add(new Application(0, getString(R.string.app_spotify_streamer), getString(R.string.descr_spotify_streamer), R.drawable.spotify));
        applications.add(new Application(1, getString(R.string.app_scores), getString(R.string.descr_scores), R.drawable.ic_assessment_black_48dp));
        applications.add(new Application(2, getString(R.string.app_library), getString(R.string.descr_library), R.drawable.ic_book_black_48dp));
        applications.add(new Application(3, getString(R.string.app_build_it_bigger), getString(R.string.descr_build_it_bigger), R.drawable.ic_cloud_black_48dp));
        applications.add(new Application(4, getString(R.string.app_xyz_reader), getString(R.string.descr_xyz_reader), R.drawable.ic_chrome_reader_mode_black_48dp));
        applications.add(new Application(5, getString(R.string.app_capstone), getString(R.string.descr_capstone), R.drawable.ic_android_black_48dp));
    }

    private void initializeAdapter(){
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snackMessage = "";
                if (v instanceof CardView)
                {
                    CardView cv = (CardView) v;
                    int cardViewID;
                    try
                    {
                        cardViewID = Integer.parseInt(cv.getTag().toString());
                    } catch(NumberFormatException nfe)
                    {
                        cardViewID = 0;
                    }
                    switch(cardViewID)
                    {
                        case 0:
                            snackMessage = getString(R.string.app_spotify_streamer);
                            break;
                        case 1:
                            snackMessage = getString(R.string.app_scores);
                            break;
                        case 2:
                            snackMessage = getString(R.string.app_library);
                            break;
                        case 3:
                            snackMessage = getString(R.string.app_build_it_bigger);
                            break;
                        case 4:
                            snackMessage = getString(R.string.app_xyz_reader);
                            break;
                        case 5:
                            snackMessage = getString(R.string.app_capstone);
                            break;
                        default:
                            snackMessage = getString(R.string.error);
                    }
                }
                Snackbar.make(mCoordinatorLayoutView, snackMessage, Snackbar.LENGTH_SHORT)
                        .show();
            }
        };

        RecyclerAdapter adapter = new RecyclerAdapter(applications, clickListener);
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
