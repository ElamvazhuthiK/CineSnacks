package com.example.elamvazhuthik.cinesnacks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ElamvazhuthiK on 14/04/15.
 */
public class TestFragment extends Fragment {
    @Nullable
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.test_layout, container, false);
        return rootView;
    }
}
