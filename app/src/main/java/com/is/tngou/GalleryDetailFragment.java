package com.is.tngou;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.is.tngou.adapter.TngouGalleryDetailRecyclerViewAdapter;
import com.is.tngou.base.BaseFragment;
import com.is.tngou.entity.Gallery;
import com.is.tngou.entity.GalleryDetail;
import com.is.tngou.mvp.presenter.GalleryDetailPresenterImpl;
import com.is.tngou.mvp.view.GalleryDetailView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link GalleryActivity}
 * in two-pane mode (on tablets) or a {@link GalleryDetailActivity}
 * on handsets.
 */
public class GalleryDetailFragment extends BaseFragment implements GalleryDetailView {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Gallery mItem;

    private GalleryDetailPresenterImpl galleryDetailPresenter;
    private RecyclerView recyclerView;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GalleryDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        galleryDetailPresenter=new GalleryDetailPresenterImpl(this);
        JSONObject json=new JSONObject();
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = (Gallery)getArguments().getSerializable(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getTitle());
            }
            try {
                json.put("id",mItem.getId());
            }catch (JSONException j){

            }
            galleryDetailPresenter.getGalleryDetail(json);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gallery_detail, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.item_detail);
        assert recyclerView != null;
        // Show the dummy content as text in a TextView.
/*        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.getTitle());
        }*/

        return rootView;
    }

    @Override
    public void onGalleryDetail(List<GalleryDetail.GalleryList> galleryLists) {
        recyclerView.setAdapter(new TngouGalleryDetailRecyclerViewAdapter(galleryLists));
    }
}
