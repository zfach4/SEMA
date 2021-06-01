package com.zulfi.sema.ui.smart_light;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SmartLightViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SmartLightViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}