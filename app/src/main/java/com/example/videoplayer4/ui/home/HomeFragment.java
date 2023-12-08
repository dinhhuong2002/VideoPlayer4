package com.example.videoplayer4.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import com.example.videoplayer4.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
//    private ExoPlayer player;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        EditText enterlink=binding.enterLink;
        Button btnStream=binding.btnStream;
        //create a playerView
        PlayerView exoPlayer= binding.include.playerView;

        enterlink.setText("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
//        enterlink.setText("https://file-examples.com/storage/fe19e15eac6560f8c936c41/2017/04/file_example_MP4_1280_10MG.mp4");
        enterlink.setEnabled(false); //cant edit link in textView
        String uri = enterlink.getText().toString();
        Log.d("URI: ",uri);

        ExoPlayer player = new ExoPlayer.Builder(getContext()).build();
        exoPlayer.setPlayer(player);

        // Build the media item.
        MediaItem mediaItem = MediaItem.fromUri(uri);
        // Set the media item to be played.
        player.setMediaItem(mediaItem);
        player.prepare();
        btnStream.setOnClickListener(view -> {
            if(URLUtil.isValidUrl(uri)){
                // Start the playback.
                player.play();
            }else{
                Toast.makeText(getContext(),"link video is error",Toast.LENGTH_LONG).show();
                Log.d("Link","is not valid");
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}