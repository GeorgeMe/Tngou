package com.is.tngou;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.is.tngou.adapter.TngouRecyclerViewAdapter;
import com.is.tngou.base.BaseActivity;
import com.is.tngou.entity.Gallery;
import com.is.tngou.mvp.presenter.GalleryPresenterImpl;
import com.is.tngou.mvp.view.GalleryView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link GalleryDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class GalleryActivity extends BaseActivity implements GalleryView {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private GalleryPresenterImpl galleryPresenter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        galleryPresenter=new GalleryPresenterImpl(this);
        JSONObject json =new JSONObject();
        try {
            json.put("id",1);
            json.put("page",1);
            json.put("rows",30);
        }catch (JSONException j){

        }
        galleryPresenter.getGalleryPhotoList(1,json);
         recyclerView = (RecyclerView)findViewById(R.id.item_list);
        assert recyclerView != null;

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    @Override
    public void onGalleryPhotoList(List<Gallery> data) {
        recyclerView.setAdapter(new TngouRecyclerViewAdapter(data,mTwoPane,getSupportFragmentManager()));
    }

}
