package com.omerpanay.anew.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.omerpanay.anew.R;
import com.omerpanay.anew.models.HomeHorizontalModel;
import com.omerpanay.anew.models.HomeVerticalModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorizontalAdapter extends RecyclerView.Adapter<HomeHorizontalAdapter.ViewHolder> {
    Activity activity;
    ArrayList<HomeHorizontalModel> list;
    UpdateVerticalRecycler updateVerticalRecycler;
    int row_index = -1;
    ArrayList<HomeVerticalModel> homeVerticalModels; // homeVerticalModels'i burada tanımlıyoruz

    public HomeHorizontalAdapter(UpdateVerticalRecycler updateVerticalRecycler, Activity activity, ArrayList<HomeHorizontalModel> list) {
        this.activity = activity;
        this.list = list;
        this.updateVerticalRecycler = updateVerticalRecycler;
        homeVerticalModels = new ArrayList<>();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();


                homeVerticalModels.clear();
                if (position == 0) {
                    // Yeni verileri ekle
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.workout_music, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.mustafayildiz, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.ronnie, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.kevin2jpg, "5.00", "X is", "4.8", "Song"));
                } else if (position == 1) {
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.azerbulbul2, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.ferdi2, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.muslumkuskun, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.samiyusuf4, "5.00", "X is", "4.8", "Song"));


                }
                else if (position == 2) {
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.eminem4, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.eylemaktas, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.eminem, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.azer, "5.00", "X is", "4.8", "Song"));


                }
                else if (position == 3) {
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.kevin1, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.kevin2jpg, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.kevin2jpg, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.kevin2jpg, "5.00", "X is", "4.8", "Song"));


                }
                else if (position == 4) {
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.maherzain6, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.samiyusuf4, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.kevin3, "5.00", "X is", "4.8", "Song"));
                    homeVerticalModels.add(new HomeVerticalModel(R.drawable.kevin3, "5.00", "X is", "4.8", "Song"));


                }

                updateVerticalRecycler.callBack(position, homeVerticalModels);
            }
        });

        // Seçili öğeyi görsel olarak belirtmek için
        if (row_index == position) {
            holder.cardView.setBackgroundResource(R.drawable.change_bg);
        } else {
            holder.cardView.setBackgroundResource(R.drawable.default_bg);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
