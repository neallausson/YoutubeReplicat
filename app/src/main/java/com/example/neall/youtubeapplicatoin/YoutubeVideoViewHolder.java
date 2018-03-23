package com.example.neall.youtubeapplicatoin;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("debug","je clique");
                Intent intent = new Intent(v.getContext(), VideoActivity.class);
                //intent.putExtra("IS_SHOW",isShow);
                itemView.getContentDescription().startActivity(intent);
            }
        });


    }

    public void Bind(Result result)
    {
        title.setText(result.snippet.title.toString());
        description.setText(result.snippet.description.toString());
    }
}
