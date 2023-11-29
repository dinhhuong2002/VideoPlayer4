package com.example.videoplayer4.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import com.example.videoplayer4.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private PlayerView playerView;
    private ExoPlayer player;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        EditText enterlink=binding.enterLink;
        Button btnStream=binding.btnStream;
        PlayerView exoPlayer= binding.include.playerView;

        enterlink.setText("https://file-examples.com/storage/fe19e15eac6560f8c936c41/2017/04/file_example_MP4_640_3MG.mp4");
        enterlink.setEnabled(false); //cant edit link in textView
        String uri = enterlink.getText().toString();

        ExoPlayer player = new ExoPlayer.Builder(getContext()).build();
        exoPlayer.setPlayer(player);

        // Build the media item.
        MediaItem mediaItem = MediaItem.fromUri(uri);
        // Set the media item to be played.
        player.setMediaItem(mediaItem);
        player.prepare();
//        player.addListener();//
        btnStream.setOnClickListener(view -> {
            // Prepare the player.
            // Start the playback.
            player.play();
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}