package com.example.videoplayer4;
//import
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private List<String> videoList;
    private final Context context;
    private final LayoutInflater layoutInflater;

    public VideoAdapter(Context context, List<String> videoList) {
        this.videoList = videoList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout rootLayoutView;
        PlayerView videoView;
//        FrameLayout frameLayout;//Framelayout chứa videoView in playlist
        TextView linkOfTheVideo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rootLayoutView = itemView.findViewById(R.id.rootLayout);
            videoView = itemView.findViewById(R.id.videoInPlaylist);
//            frameLayout.addView(videoView);
            linkOfTheVideo=itemView.findViewById(R.id.linkOfTheVideo);
            itemView.setOnClickListener(view -> {
                view.startAnimation(AnimationUtils.loadAnimation(context,androidx.appcompat.R.anim.abc_fade_in));
            });
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_items, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(VideoAdapter.ViewHolder viewHolder, int position) {
        String item=videoList.get(position);
        viewHolder.linkOfTheVideo.setText(item);
        viewHolder.videoView.buildLayer();
        viewHolder.videoView.setVisibility(View.VISIBLE);
//        viewHolder.videoView.playVideoByLink(item);
//        viewHolder.videoView.playVideoByLink(link);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }


}
