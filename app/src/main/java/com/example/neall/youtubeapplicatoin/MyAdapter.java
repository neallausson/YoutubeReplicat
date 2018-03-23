package com.example.neall.youtubeapplicatoin;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mukesh.tinydb.TinyDB;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by neall on 23/02/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<YoutubeVideoViewHolder> {
    private final List<Result> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Result> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public YoutubeVideoViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        YoutubeVideoViewHolder vh = new YoutubeVideoViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(YoutubeVideoViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Result result = this.mDataset.get(position);
        holder.title.setText(result.snippet.title.toString());
        holder.description.setText(result.snippet.description.toString());
        Picasso.get().load(result.snippet.thumbnails.get("medium").url).into(holder.miniature);
        //holder.Bind(result);
        holder.space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("debug","je clique");
                Intent intent = new Intent(v.getContext(), VideoActivity.class);
                TinyDB tinyDB = new TinyDB(v.getContext());
                //intent.putExtra("IS_SHOW",isShow);
                String id = result.Id();
                tinyDB.putString("videoid",id);
                //intent.putExtra("idvideo", id);
                tinyDB.putString("videodescription",result.snippet.description);
                v.getContext().startActivity(intent);
                Log.e("debug",id);
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }
}