package com.example.videoplayer4;

import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.media3.ui.PlayerView;

public class Video {
    FrameLayout video;
    String linkOfTheVideo;
    public Video(String linkOfTheVideo){
        this.linkOfTheVideo=linkOfTheVideo;
    }

    public FrameLayout getVideo() {
        return video;
    }

    public void setVideo(FrameLayout video) {
        this.video=video;
    }

    public String getLinkOfTheVideo() {
        return linkOfTheVideo;
    }

    public void setLinkOfTheVideo(String linkOfTheVideo) {
        this.linkOfTheVideo = linkOfTheVideo;
    }
}
