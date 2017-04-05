package com.acadgild.session13;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment{

    TextView myTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.my_fragment,container,false);
        myTextView=(TextView)v.findViewById(R.id.myFragmentText);
        String name=((InFragmentAccess)getActivity()).getName();
        myTextView.setText(myTextView.getText()+name);
        ((InFragmentAccess)getActivity()).setName("Gajendra...");


        return  v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
