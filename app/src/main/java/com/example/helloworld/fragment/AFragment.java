package com.example.helloworld.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.helloworld.R;

public class AFragment extends Fragment {

    private TextView mtvTitle;
    private Activity mActivity;

    public static AFragment newInstance(String title){
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);//将title的内容传到key = title中
        fragment.setArguments(bundle);//*****即便被回收  也会赋值，重要
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mtvTitle = view.findViewById(R.id.tv_title);
        if(getArguments() != null){
            mtvTitle.setText(getArguments().getString("title"));
        }


        if(getActivity() != null){//推荐这样的判断
            // TODO: 2020/1/5

        }else{

        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;//不推荐  可能会内存泄露
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
