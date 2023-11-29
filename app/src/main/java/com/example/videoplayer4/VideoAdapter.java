package com.example.videoplayer4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private List<Video> videoList;
    private final Context context;
    private final LayoutInflater layoutInflater;

//    public VideoAdapter(List<Video> videoList, Context context, LayoutInflater layoutInflater){
//        this.videoList = videoList;
//        this.context = context;
//        this.layoutInflater = layoutInflater;
//    }

    public VideoAdapter(Context context, List<Video> videoList) {
        this.videoList = videoList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout videoView;
        TextView linkOfTheVideo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView=itemView.findViewById(R.id.videoInPlaylist);
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
        Video item=videoList.get(position);
        viewHolder.videoView.setTag(item);
        viewHolder.linkOfTheVideo.setText(item.getLinkOfTheVideo());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }


}
