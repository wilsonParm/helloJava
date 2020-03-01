package com.example.helloworld.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.helloworld.R;

public class AFragment extends Fragment {

    private TextView mtvTitle;
    private Activity mActivity;
    private Button mBtnChange, mBtnReset,mBtnMsg;
    private BFragment bFragment;
    private IOnMessageClick listener;

    public static AFragment newInstance(String title){
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);//将title的内容传到key = title中
        fragment.setArguments(bundle);//*****即便被回收  也会赋值，重要
        return fragment;
    }

    public interface IOnMessageClick{
        void onclick(String text);
    }

    public void onAttach(Context context){
        Log.v("onAttch","asdaskdasdasdasd");
        super.onAttach(context);
        try {
            listener = (IOnMessageClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity必须实现IOnMessageClick接口");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("AFragment","----onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mtvTitle = (TextView) view.findViewById(R.id.tv_title);
        mBtnChange = (Button) view.findViewById(R.id.btn_change);
        mBtnReset = view.<Button>findViewById(R.id.btn_reset);
        mBtnMsg = view.findViewById(R.id.btn_msg);
        mBtnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity)getActivity()).setData("你好");
                listener.onclick("你好");
            }
        });
        mBtnChange.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        }));
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mtvTitle.setText("new title");
            }
        });
        if(getArguments() != null){
            mtvTitle.setText(getArguments().getString("title"));
        }


        if(getActivity() != null){//推荐这样的判断
            // TODO: 2020/1/5

        }else{

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
