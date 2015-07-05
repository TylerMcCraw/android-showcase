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
 * Created by w3bshark on 6/21/2015.
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
    View.OnClickListener clickListener;

    RecyclerAdapter(List<Application> applications, View.OnClickListener clickListener) {
        this.applications = applications;
        this.clickListener = clickListener;
    }

    @Override
    public ApplicationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new ApplicationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ApplicationViewHolder applicationViewHolder, int i) {
        applicationViewHolder.cv.setTag(applications.get(i).appId);
        applicationViewHolder.appName.setText(applications.get(i).name);
        applicationViewHolder.appDescription.setText(applications.get(i).description);
        applicationViewHolder.appPhoto.setImageResource(applications.get(i).photoId);
        applicationViewHolder.appPhoto.setContentDescription(applicationViewHolder.appDescription.getText());
        applicationViewHolder.cv.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return applications.size();
    }
}
