package com.zulfi.sema.ui.home;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.zulfi.sema.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private Switch switchMode;
    private View content_manual;
    private View content_auto;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        switchMode = view.findViewById(R.id.switch_mode);

        content_manual = view.findViewById(R.id.content_manual);
        content_auto = view.findViewById(R.id.content_auto);

        switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                configureContentMode(isChecked);
            }
        });

//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
////        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
////                textView.setText(s);
//            }
//        });


        // harusnya ini dieksekusi setelah mendapatkan data dari firebase

        this.configureContentMode(switchMode.isChecked());
        return view;
    }

    private void configureContentMode(Boolean isChecked) {
        if (isChecked) {
            content_auto.setVisibility(View.VISIBLE);
            content_manual.setVisibility(View.GONE);
        } else {
            content_auto.setVisibility(View.GONE);
            content_manual.setVisibility(View.VISIBLE);
        }
    }



}