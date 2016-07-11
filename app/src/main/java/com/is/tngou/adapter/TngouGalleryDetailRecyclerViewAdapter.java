package com.is.tngou.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.is.tngou.R;
import com.is.tngou.entity.GalleryDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class TngouGalleryDetailRecyclerViewAdapter extends RecyclerView.Adapter<TngouGalleryDetailRecyclerViewAdapter.ViewHolder> {

    private List<GalleryDetail.GalleryList> galleries;

    public TngouGalleryDetailRecyclerViewAdapter(List<GalleryDetail.GalleryList> galleries) {
        this.galleries = galleries;
    }

    @Override
    public TngouGalleryDetailRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_detail_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TngouGalleryDetailRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.gallery=galleries.get(position);
        Log.e("img",holder.gallery.getSrc());
        Picasso.with(holder.mView.getContext()).load("http://tnfs.tngou.net/img"+holder.gallery.getSrc()).into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return galleries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ImageView photo;
        public GalleryDetail.GalleryList gallery;

        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            photo=(ImageView) mView.findViewById(R.id.photo2);
        }
    }
}
