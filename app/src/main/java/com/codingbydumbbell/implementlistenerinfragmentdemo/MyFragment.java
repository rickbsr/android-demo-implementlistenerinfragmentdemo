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

/**
 * @author Rick
 * @create 2019/3/30
 * @className MyFragment
 * @description - TODO
 */
public class MyFragment extends Fragment {

    private static MyFragment instance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        SeekBar bar = view.findViewById(R.id.seekBar);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

    public static MyFragment getInstance() {
        if (instance == null) instance = new MyFragment();
        return instance;
    }

    public interface MyFragmentInterface {
        void onSeekBarChanged(int progress);
    }

    MyFragmentInterface myInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myInterface = (MyFragmentInterface) context;
    }
}
