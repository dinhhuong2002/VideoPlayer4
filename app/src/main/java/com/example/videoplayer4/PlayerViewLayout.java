package com.example.videoplayer4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

public class PlayerViewLayout  extends FrameLayout {
    private ExoPlayer player;
    private PlayerView playerView;
    private FrameLayout frameLayout;
    private ProgressBar progressBar;//when dont use player native
    private String link;

    public PlayerViewLayout(Context context) {
        super(context);
        playerView=findViewById(R.id.playerView);
        frameLayout.addView(playerView);
    }

    public void playVideoByLink(String link){
        this.link=link;
        PlayerView playerView=new PlayerView(getContext());
        player = new ExoPlayer.Builder(getContext()).build();
        playerView.setPlayer(player);
        MediaItem mediaItem=MediaItem.fromUri(link);
        player.prepare();
        player.play();
    }
}
