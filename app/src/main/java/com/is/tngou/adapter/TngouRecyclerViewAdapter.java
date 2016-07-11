package com.is.tngou.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.is.tngou.GalleryDetailActivity;
import com.is.tngou.GalleryDetailFragment;
import com.is.tngou.R;
import com.is.tngou.entity.Gallery;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class TngouRecyclerViewAdapter extends RecyclerView.Adapter<TngouRecyclerViewAdapter.ViewHolder> {

    private List<Gallery> galleries;
    private boolean mTwoPane;
    private FragmentManager manager;

    public TngouRecyclerViewAdapter(List<Gallery> galleries, boolean mTwoPane, FragmentManager manager) {
        this.galleries = galleries;
        this.mTwoPane = mTwoPane;
        this.manager = manager;
    }

    @Override
    public TngouRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TngouRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.gallery=galleries.get(position);
        Log.e("img",holder.gallery.getImg());
        Picasso.with(holder.mView.getContext()).load("http://tnfs.tngou.net/img"+holder.gallery.getImg()).into(holder.photo);
        holder.photo_title.setText(holder.gallery.getTitle());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putSerializable(GalleryDetailFragment.ARG_ITEM_ID, holder.gallery);
                    GalleryDetailFragment fragment = new GalleryDetailFragment();
                    fragment.setArguments(arguments);
                    manager.beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, GalleryDetailActivity.class);
                    intent.putExtra(GalleryDetailFragment.ARG_ITEM_ID, holder.gallery);

                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return galleries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ImageView photo;
        public TextView photo_title;
        public Gallery gallery;

        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            photo=(ImageView) mView.findViewById(R.id.photo);
            photo_title=(TextView) mView.findViewById(R.id.photo_title);
        }
    }
}
