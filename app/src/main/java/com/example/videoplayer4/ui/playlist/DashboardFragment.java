package com.example.videoplayer4.ui.playlist;

import android.graphics.Color;
import android.os.Bundle;
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

import com.example.videoplayer4.Video;
import com.example.videoplayer4.VideoAdapter;
import com.example.videoplayer4.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    private ExoPlayer player;
    private List<Video> videoArrayList = new ArrayList<>();
    private LinearLayoutManager layoutManager;
//    private VideoAdapter adapter=new VideoAdapter(getContext(),videoArrayList);
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        videoArrayList = getListVideo();
        recyclerView = binding.recyclerView;
        recyclerView.setAdapter(new VideoAdapter(getContext(),videoArrayList));
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visiblePosition = layoutManager.findFirstCompletelyVisibleItemPosition(); //find view completely visiable
                if(visiblePosition > -1) {
                    View v = layoutManager.findViewByPosition(visiblePosition);
                    String uri= videoArrayList.get(visiblePosition).getLinkOfTheVideo();
                    MediaItem mediaItem = MediaItem.fromUri(uri);
               // Set the media item to be played.
                player.setMediaItem(mediaItem);
                player.prepare();
                player.play();

                    v.setBackgroundColor(Color.parseColor("#777777"));
                }
            }
        });

        return root;
    }

    private List<Video> getListVideo() {
        List<Video> videoList = new ArrayList<Video>();
        videoList.add(new Video("https://file-examples.com/storage/fe19e15eac6560f8c936c41/2017/04/file_example_MP4_640_3MG.mp4")); //Noaaa
        videoList.add(new Video("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4")); //Making my way
        videoList.add(new Video("http://techslides.com/demos/sample-videos/small.mp4")); //Give it to me
        videoList.add(new Video("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/30/WomanWalking-1609303462769.mp4")); //Noi nay co anh
        videoList.add(new Video("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/2/918127046-1606890428689386032470.mp4")); //Run now
        videoList.add(new Video("https://file-examples.com/storage/fe19e15eac6560f8c936c41/2017/04/file_example_MP4_640_3MG.mp4")); //Noaaa
        videoList.add(new Video("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4")); //Making my way
        videoList.add(new Video("http://techslides.com/demos/sample-videos/small.mp4")); //Give it to me
        videoList.add(new Video("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/30/WomanWalking-1609303462769.mp4")); //Noi nay co anh
        videoList.add(new Video("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/2/918127046-1606890428689386032470.mp4")); //Run now
        videoList.add(new Video("https://file-examples.com/storage/fe19e15eac6560f8c936c41/2017/04/file_example_MP4_640_3MG.mp4")); //Noaaa
        videoList.add(new Video("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4")); //Making my way
        videoList.add(new Video("http://techslides.com/demos/sample-videos/small.mp4")); //Give it to me
        videoList.add(new Video("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/30/WomanWalking-1609303462769.mp4")); //Noi nay co anh
        videoList.add(new Video("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/2/918127046-1606890428689386032470.mp4")); //Run now
        videoList.add(new Video("https://file-examples.com/storage/fe19e15eac6560f8c936c41/2017/04/file_example_MP4_640_3MG.mp4")); //Noaaa
        videoList.add(new Video("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4")); //Making my way
        videoList.add(new Video("http://techslides.com/demos/sample-videos/small.mp4")); //Give it to me
        videoList.add(new Video("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/30/WomanWalking-1609303462769.mp4")); //Noi nay co anh
        videoList.add(new Video("https://43324700545123422b.lotuscdn.vn/201204812902309888/2020/12/2/918127046-1606890428689386032470.mp4"));
        return videoList;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}