package com.cinesnacks.news;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.elamvazhuthik.cinesnacks.R;


/**
 * Created by ElamvazhuthiK on 17/04/15.
 */
public final class NewsDescription extends Fragment {
    View rootView;
    String strNewsDesc;
    ProgressDialog pDialog;
    int postID;
    private NewsModel newsModel = new NewsModel();

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
        rootView = inflater.inflate(R.layout.newsdesc_layout, container, false);
        pDialog = new ProgressDialog(container.getContext());
        pDialog.setMessage("Loading Description ....");
        pDialog.show();
        String url = "http://clapboard.co.in/?json=get_post&post_id="+ postID +"&exclude=thumbnail,custom_fields,attachments,tags,categories,excerpt,title_plain,status,url,slug,type,author,comments,comment_count,comment_status,previous_url";
        newsModel.sendNewsDescRequest(container.getContext(), url,
                new NewsModelListener() {
                    @Override
                    public void response(Object response) {
                        TextView textViewNewsTitle = (TextView) rootView.findViewById(R.id.textViewNewsTitle);
                        textViewNewsTitle.setText(newsModel.getDescTitle());
                        WebView newsDesc = (WebView) rootView.findViewById(R.id.webViewNewsDesc);
                        newsDesc.loadData(newsModel.getDescContent(), "text/html; charset=utf-8", null);
//                        newsDesc.loadData(newsModel.getDescContent(), "text/html", null);
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
