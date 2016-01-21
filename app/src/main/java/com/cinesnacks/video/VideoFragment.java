package com.cinesnacks.video;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cinesnacks.base.BaseFragment;
import com.cinesnacks.video.models.Post;
import com.example.elamvazhuthik.cinesnacks.R;

/**
 * Created by ElamvazhuthiK on 6/9/15.
 */
public class VideoFragment  extends BaseFragment implements VideoModelListener {
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
        videoModel.sendVideoRequest(container.getContext(), "http://clapboard.co.in/?json=get_posts&cat=5&exclude=attachments,url,tags,categories,excerpt,title_plain,status,slug,type,author,comments,comment_count,comment_status,previous_url,custom_fields", this);
        return rootView;
    }
    @Override
    public void response(Object response) {
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        VideoAdapter videoAdapter = new VideoAdapter(getActivity().getBaseContext(), videoModel.getPosts());
        listView.setAdapter(videoAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Post post = videoModel.getPosts().get(position);
                        int start = post.getContent().indexOf("<iframe");
                        int end = post.getContent().indexOf("iframe>");
                        String subStr = post.getContent().substring(start, end);
                        start = subStr.indexOf("https:");
                        end = subStr.indexOf("?");
                        subStr = subStr.substring(start, end);
                        try{
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(subStr));
                            getActivity().startActivity(intent);
                        }catch (ActivityNotFoundException ex){
                            Intent intent=new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(subStr));
                            getActivity().startActivity(intent);
                        }
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
