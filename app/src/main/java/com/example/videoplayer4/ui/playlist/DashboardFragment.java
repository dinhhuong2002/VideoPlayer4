package com.example.videoplayer4.ui.playlist;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoplayer4.PlayerViewLayout;
import com.example.videoplayer4.R;
import com.example.videoplayer4.VideoAdapter;
import com.example.videoplayer4.databinding.FragmentDashboardBinding;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    private List<String> videoArrayList = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    private PlayerView playerView;
    private ExoPlayer player;
    private RecyclerView recyclerView;
    private PlayerViewLayout frameLayout;
    String TAG = "PLAYLIST";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        videoArrayList = getListVideo();
        recyclerView = binding.recyclerView;

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }


            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                Log.d(TAG, "onScrollStateChanged: called.");

                int visibleItemCount = layoutManager.getChildCount();
                Log.d(TAG, "visibleItemCount " + String.valueOf(visibleItemCount));
                int totalItemCount = layoutManager.getItemCount();
                Log.d(TAG, "totalItemCount " + String.valueOf(totalItemCount));
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                Log.d(TAG, "firstVisibleItemPosition " + String.valueOf(firstVisibleItemPosition));
                if (firstVisibleItemPosition > -1) {
                    View v = layoutManager.findViewByPosition(firstVisibleItemPosition);
                    //do something
//                    v.setBackgroundColor(Color.parseColor("#777777"));

//                    String link=v.findViewById(R.id.linkOfTheVideo).toString();
                    String link = "http://techslides.com/demos/sample-videos/small.mp4";
                    playerView = v.findViewById(R.id.videoInPlaylist);
//                    playerView=new PlayerView(getContext());
                    player = new ExoPlayer.Builder(getContext()).build();
                    playerView.setPlayer(player);
                    MediaItem mediaItem = MediaItem.fromUri(link);
                    player.setMediaItem(mediaItem);
//                    throw() ;
                    player.prepare();
                    player.play();
                }

            }
        });


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new VideoAdapter(getContext(), videoArrayList));
        return root;
    }


    private List<String> getListVideo() {
        List<String> videoList = new ArrayList<String>();
        videoList.add("https://file-examples.com/storage/fe19e15eac6560f8c93");
        videoList.add("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"); //Making my way
        videoList.add("http://techslides.com/demos/sample-videos/small.mp4"); //Give it to me
        videoList.add("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/30/WomanWalking-1609303462769.mp4"); //Noi nay co anh
        videoList.add("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/2/918127046-1606890428689386032470.mp4"); //Run now
        videoList.add("https://file-examples.com/storage/fe19e15eac6560f8c93");
        videoList.add("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"); //Making my way
        videoList.add("http://techslides.com/demos/sample-videos/small.mp4"); //Give it to me
        videoList.add("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/30/WomanWalking-1609303462769.mp4"); //Noi nay co anh
        videoList.add("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/2/918127046-1606890428689386032470.mp4"); //Run now
        videoList.add("https://file-examples.com/storage/fe19e15eac6560f8c93");
        videoList.add("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"); //Making my way
        videoList.add("http://techslides.com/demos/sample-videos/small.mp4"); //Give it to me
        videoList.add("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/30/WomanWalking-1609303462769.mp4"); //Noi nay co anh
        videoList.add("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/2/918127046-1606890428689386032470.mp4"); //Run now
        videoList.add("https://file-examples.com/storage/fe19e15eac6560f8c93");
        videoList.add("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"); //Making my way
        videoList.add("http://techslides.com/demos/sample-videos/small.mp4"); //Give it to me
        videoList.add("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/30/WomanWalking-1609303462769.mp4"); //Noi nay co anh
        videoList.add("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/2/918127046-1606890428689386032470.mp4"); //Run now
        return videoList;
    }


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

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}