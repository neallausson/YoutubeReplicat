package com.example.neall.youtubeapplicatoin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by neall on 23/02/2018.
 */

public class YoutubeVideoViewHolder  extends RecyclerView.ViewHolder{

    public TextView title;
    public TextView description;
    public ImageView miniature;
    public RelativeLayout space;



    public YoutubeVideoViewHolder(final View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.titleTextView);
        description = itemView.findViewById(R.id.descriptionTextView);
        miniature = itemView.findViewById(R.id.miniatureImageView);
        space = itemView.findViewById(R.id.layout);




    }


    //public void Bind(Result result)
    //{
    //    title.setText(result.snippet.title.toString());
    //    description.setText(result.snippet.description.toString());
    //}
}
