package com.cinesnacks.video;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.elamvazhuthik.cinesnacks.R;

/**
 * Created by ElamvazhuthiK on 6/9/15.
 */
public class VideoFragment  extends Fragment {
    private View rootView;
    ProgressDialog pDialog;
    private VideoModel videoModel = new VideoModel();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.list_layout, container, false);
        pDialog = new ProgressDialog(container.getContext());
        pDialog.setMessage("Loading Videos ....");
        pDialog.show();
        videoModel.sendVideoRequest(container.getContext(), "http://clapboard.co.in/?json=get_posts&cat=5&exclude=attachments,thumbnail,url,tags,categories,excerpt,title_plain,status,slug,type,author,comments,comment_count,comment_status,previous_url,custom_fields",
                new VideoModelListener() {
                    @Override
                    public void response(Object response) {
                        ListView listView = (ListView) rootView.findViewById(R.id.listView);

                        VideoAdapter videoAdapter = new VideoAdapter(getActivity().getBaseContext(), videoModel.getPosts());
                        listView.setAdapter(videoAdapter);
//                        listView.setOnItemClickListener(
//                                new AdapterView.OnItemClickListener() {
//                                    @Override
//                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                                        GalleryViewPager galleryViewPager = new GalleryViewPager();
//                                        galleryViewPager.setArguments(videoModel.getPost());
//                                        fragmentManager.beginTransaction()
//                                                .replace(R.id.container, galleryViewPager)
//                                                .addToBackStack("GalleryViewPager")
//                                                .commit();
//                                    }
//                                }
//                        );

                        pDialog.dismiss();
                    }
                    @Override
                    public void error(String error) {
                        pDialog.dismiss();
                    }
                });

        return rootView;
    }
}
