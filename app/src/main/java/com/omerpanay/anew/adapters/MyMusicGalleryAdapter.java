package com.omerpanay.anew.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omerpanay.anew.databinding.EachItemBinding;
import com.omerpanay.anew.models.MyMusicGallery;

import java.util.List;

public class MyMusicGalleryAdapter extends RecyclerView.Adapter<MyMusicGalleryAdapter.ViewHolder> {

    Context context;
    List<MyMusicGallery> list;
    private MediaPlayer mediaPlayer;

    public MyMusicGalleryAdapter(Context context, List<MyMusicGallery> list) {
        this.context = context;
        this.list = list;
        mediaPlayer = new MediaPlayer();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EachItemBinding binding = EachItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyMusicGallery item = list.get(position);

        holder.binding.musicTitle.setText(item.getDescription());
        holder.binding.musicImage.setImageResource(item.getImage());

        holder.binding.btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });

        holder.binding.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    try {
                        mediaPlayer.reset();
                        mediaPlayer = MediaPlayer.create(context, item.getResourceId());
                        mediaPlayer.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EachItemBinding binding;

        public ViewHolder(EachItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
