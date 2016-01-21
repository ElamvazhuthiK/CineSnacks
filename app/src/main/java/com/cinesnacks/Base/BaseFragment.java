package com.cinesnacks.base;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.elamvazhuthik.cinesnacks.R;

/**
 * Created by ElamvazhuthiK on 6/17/15.
 */
public class BaseFragment extends Fragment implements BaseModelListener {
//    public void loadData(@Nullable ViewGroup container)
//    {
//
//    }
    public void response(Object response)
    {

    }
    public void error(String error)
    {
        Context context = getActivity().getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, R.string.network_error, duration);
        toast.show();
    }
}
