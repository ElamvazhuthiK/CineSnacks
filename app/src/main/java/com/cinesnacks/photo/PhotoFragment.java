package com.cinesnacks.photo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cinesnacks.base.BaseFragment;
import com.example.elamvazhuthik.cinesnacks.R;

/**
 * Created by ElamvazhuthiK on 4/24/15.
 */
public class PhotoFragment extends BaseFragment implements PhotoModelListener {
    private View rootView;
    ProgressDialog pDialog;
    private PhotoModel photoModel = new PhotoModel();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.list_layout, container, false);
        pDialog = new ProgressDialog(container.getContext());
        pDialog.setMessage("Loading Photos ....");
        pDialog.show();
        photoModel.sendPhotoRequest(container.getContext(), "http://clapboard.co.in/?json=get_posts&cat=6&exclude=attachments,url,tags,categories,excerpt,title_plain,status,slug,type,author,comments,comment_count,comment_status,previous_url,content,custom_fields", this);
        return rootView;
    }
    @Override
    public void response(Object response) {
        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        PhotoAdapter photoAdapter = new PhotoAdapter(getActivity().getBaseContext(), photoModel.getPosts());
        listView.setAdapter(photoAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        GalleryViewPager galleryViewPager = new GalleryViewPager();
                        galleryViewPager.setArguments(photoModel.getPosts(), position);
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, galleryViewPager)
                                .addToBackStack("MainViewPager")
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
