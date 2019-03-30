package com.codingbydumbbell.implementlistenerinfragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

public class MyFragment extends Fragment {

    private static MyFragment instance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false); // 建造 View
        SeekBar bar = view.findViewById(R.id.seekBar);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // SeekBar 的傾聽器
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myInterface.onSeekBarChanged(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return view;
    }

    // Singleton 的設計
    public static MyFragment getInstance() {
        if (instance == null) instance = new MyFragment();
        return instance;
    }

    // 設計 CallBack 所需的 interface
    public interface MyFragmentInterface {
        void onSeekBarChanged(int progress);
    }

    // 宣告
    MyFragmentInterface myInterface;

    // 將它與 Fragment 連結
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myInterface = (MyFragmentInterface) context;
    }
}
