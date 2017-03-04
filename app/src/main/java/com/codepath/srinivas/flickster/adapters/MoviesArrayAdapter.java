package com.codepath.srinivas.flickster.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.srinivas.flickster.R;
import com.codepath.srinivas.flickster.models.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by srinivas on 3/3/17.
 */

public class MoviesArrayAdapter extends ArrayAdapter<Movies> {

    public MoviesArrayAdapter(Context context, List<Movies> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Movies movie = getItem(position);

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_movie_view, parent, false);
        }

        // find the image view
        ImageView ivMovieImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);
        //clear out the image from convertView
        ivMovieImage.setImageResource(0);
        TextView tvTitleText = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvDescriptionText = (TextView) convertView.findViewById(R.id.tvDescription);


        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivMovieImage);
        tvTitleText.setText(movie.getOriginalTitle());
        tvDescriptionText.setText(movie.getOverview());

        return convertView;
    }
}
