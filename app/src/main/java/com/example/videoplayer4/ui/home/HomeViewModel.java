package com.example.videoplayer4.ui.home;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private static Context mcontext;
    private final MutableLiveData<String> mText;

    public HomeViewModel(Context context) {
        this.mcontext = context;
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public static void showToast(){
        Toast.makeText(mcontext, "Show toast in Home View model ...", Toast.LENGTH_SHORT).show();

    }

    public LiveData<String> getText() {
        return mText;
    }
}