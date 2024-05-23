package com.omerpanay.anew.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.omerpanay.anew.R;
import com.omerpanay.anew.models.HomeVerticalModel;

import java.util.ArrayList;
import java.util.List;


public class HomeVerticalAdapter extends RecyclerView.Adapter<HomeVerticalAdapter.ViewHolder> {
    Context context;
    ArrayList<HomeVerticalModel> list;

    public HomeVerticalAdapter(Context context,ArrayList<HomeVerticalModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,timing,artist,rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ver_img);
            name=itemView.findViewById(R.id.name);
            timing=itemView.findViewById(R.id.timing);
            rating=itemView.findViewById(R.id.rating);
            artist=itemView.findViewById(R.id.artist);

        }
    }
}
