package com.example.knight.lab33;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Knight on 2018. 4. 20..
 */

// First fragment1
public class Fragment1 extends Fragment {

    @Nullable
    @Override
    //    When onCreateView callback method is called by the android system
    //    Inflate xml layout resource which name is fragment1
    //    Return inflated view object
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment1, container, false);
        return root;
    }
}
