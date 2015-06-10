package com.cinesnacks.news;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.elamvazhuthik.cinesnacks.R;

/**
 * Created by ElamvazhuthiK on 15/04/15.
 */
public class NewsFragment extends Fragment {
    private View rootView;
    ProgressDialog pDialog;
    private NewsModel newsModel = new NewsModel();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.list_layout, container, false);

        pDialog = new ProgressDialog(container.getContext());
        pDialog.setMessage("Loading Recent ....");
        pDialog.show();
        newsModel.sendNewsRequest(container.getContext(), "http://clapboard.co.in/?json=get_recent_posts&exclude=content,thumbnail_images,thumbnail_size,custom_fields,attachments,tags,categories,excerpt,title_plain,status,url,slug,type,author,comments",
        new NewsModelListener() {
            @Override
            public void response(Object response) {
                ListView listView = (ListView)rootView.findViewById(R.id.listView);

                ListAdapter newsAdapter = new NewsAdapter(getActivity().getBaseContext(), newsModel.getPosts());
                listView.setAdapter(newsAdapter);
                listView.setOnItemClickListener(
                        new AdapterView.OnItemClickListener(){
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                NewsDescPager newsDescPager = new NewsDescPager();
                                newsDescPager.setArguments(newsModel.getPosts());
                                fragmentManager.beginTransaction()
                                        .replace(R.id.container, newsDescPager)
                                        .addToBackStack("NewsDescPager")
                                        .commit();
                            }
                        }
                );

                pDialog.dismiss();
            }

            @Override
            public void error(String error) {
                pDialog.dismiss();
            }
        } );

        return rootView;
    }

//    public void onBackPressed()
//    {
//        // Catch back action and pops from backstack
//        // (if you called previously to addToBackStack() in your transaction)
//        if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0){
//            getActivity().getSupportFragmentManager().popBackStack();
//        }
//        // Default action on back pressed
//        else super.getActivity().onBackPressed();
//    }
}
