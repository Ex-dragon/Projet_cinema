package com.premieressai.cyrille.projetcinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by Cyrille on 14/03/2016.
 */
public class GaleriePhotoAdapter extends ArrayAdapter<Photo> {

    public GaleriePhotoAdapter(Context context, ArrayList<Photo> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.photo, parent, false);
        }

        Photo item = getItem(position);

        ImageLoader mImageLoader;
        mImageLoader = Singleton.getInstance(this.getContext()).getImageLoader();

        NetworkImageView imageView = (NetworkImageView) convertView.findViewById(R.id.photo);
        imageView.setImageUrl(item.getUrl(), mImageLoader);

        return convertView;
    }
}
