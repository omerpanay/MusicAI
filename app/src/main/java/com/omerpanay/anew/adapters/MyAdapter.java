package com.omerpanay.anew.adapters;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omerpanay.anew.fromAPI.Datum;
import com.omerpanay.anew.databinding.EachItemBinding;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Activity context;
    private final List<Datum> dataList;
    private MediaPlayer mediaPlayer;

    public MyAdapter(Activity context, List<Datum> dataList) {
        this.context = context;
        this.dataList = dataList;
        mediaPlayer = new MediaPlayer();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EachItemBinding binding = EachItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Datum data = dataList.get(position);

        holder.binding.musicTitle.setText(data.getTitle());
        Picasso.get().load(data.getAlbum().getCover()).into(holder.binding.musicImage);

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
                        mediaPlayer.setDataSource(context, Uri.parse(data.getPreview()));
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        EachItemBinding binding;

        public MyViewHolder(@NonNull EachItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
