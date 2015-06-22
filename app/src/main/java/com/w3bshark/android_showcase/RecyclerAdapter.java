package com.w3bshark.android_showcase;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tmccraw on 6/21/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ApplicationViewHolder> {
    
    public static class ApplicationViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView appName;
        TextView appDescription;
        ImageView appPhoto;

        ApplicationViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            appName = (TextView)itemView.findViewById(R.id.app_name);
            appDescription = (TextView)itemView.findViewById(R.id.app_description);
            appPhoto = (ImageView)itemView.findViewById(R.id.app_photo);
        }
    }

    List<Application> applications;

    RecyclerAdapter(List<Application> applications){
        this.applications = applications;
    }

    @Override
    public ApplicationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        ApplicationViewHolder pvh = new ApplicationViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ApplicationViewHolder applicationViewHolder, int i) {
        applicationViewHolder.appName.setText(applications.get(i).name);
        applicationViewHolder.appDescription.setText(applications.get(i).description);
        applicationViewHolder.appPhoto.setImageResource(applications.get(i).photoId);
        applicationViewHolder.appPhoto.setContentDescription(applicationViewHolder.appDescription.getText());
    }

    @Override
    public int getItemCount() {
        return applications.size();
    }
}
