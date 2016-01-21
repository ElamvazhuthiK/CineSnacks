package com.cinesnacks.photo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cinesnacks.base.BaseFragment;
import com.example.elamvazhuthik.cinesnacks.R;

/**
 * Created by ElamvazhuthiK on 6/7/15.
 */
public class GalleryFragment extends BaseFragment implements PhotoModelListener {
    View rootView;
    ProgressDialog pDialog;
    int postID;
    private PhotoModel photoModel = new PhotoModel();

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        this.postID = args.getInt("postID");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.photogallery_layout, container, false);
        pDialog = new ProgressDialog(container.getContext());
        pDialog.setMessage("Loading Gallery ....");
        pDialog.show();
        String url = "http://clapboard.co.in/?json=get_post&post_id="+ postID +"&exclude=thumbnail,custom_fields,tags,categories,excerpt,title_plain,status,url,slug,type,author,comments,comment_count,comment_status,previous_url,content";
        photoModel.sendGalleryRequest(container.getContext(), url, this);
        return rootView;
    }
    @Override
    public void response(Object response) {
        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);
        GalleryAdapter galleryAdapter = new GalleryAdapter(getActivity().getBaseContext(), photoModel.getAttachments());
        gridView.setAdapter(galleryAdapter);
        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position,
                                            long id) {
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        ShowPhotoPager showPhotoPager = new ShowPhotoPager();
                        showPhotoPager.setArguments(photoModel.getAttachments(), position);
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, showPhotoPager)
                                .addToBackStack("GalleryFragment")
                                .commit();
                    }
                }
        );
        pDialog.dismiss();
    }

    @Override
    public void error(String error) {
        super.error(error);
        pDialog.dismiss();
    }
}
