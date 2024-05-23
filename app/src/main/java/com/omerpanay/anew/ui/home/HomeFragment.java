package com.omerpanay.anew.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omerpanay.anew.R;
import com.omerpanay.anew.adapters.HomeHorizontalAdapter;
import com.omerpanay.anew.adapters.HomeVerticalAdapter;
import com.omerpanay.anew.adapters.UpdateVerticalRecycler;
import com.omerpanay.anew.databinding.FragmentHomeBinding;
import com.omerpanay.anew.models.HomeHorizontalModel;
import com.omerpanay.anew.models.HomeVerticalModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRecycler {
    RecyclerView homeHorizontalRecycler,homeVerticalRecycler;
    ArrayList<HomeHorizontalModel> homeHorizontalModelList;
    HomeHorizontalAdapter homeHorizontalAdapter;
    ///////vertical
    ArrayList<HomeVerticalModel> homeVerticalModelList;
    HomeVerticalAdapter homeVerticalAdapter;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeHorizontalRecycler =root.findViewById(R.id.home_hor_recycler);
        homeVerticalRecycler=root.findViewById(R.id.home_ver_recycler);


        ////////////horizontal
        homeHorizontalModelList = new ArrayList<>();
        homeHorizontalModelList.add(new HomeHorizontalModel("Fitness",R.drawable.kevin1));
        homeHorizontalModelList.add(new HomeHorizontalModel("Traditional",R.drawable.geleneksel));
        homeHorizontalModelList.add(new HomeHorizontalModel("Rape",R.drawable.hareketli_music));
        homeHorizontalModelList.add(new HomeHorizontalModel("Film Music",R.drawable.film_music));
        homeHorizontalModelList.add(new HomeHorizontalModel("Podcast",R.drawable.podcast3));

        homeHorizontalAdapter=new HomeHorizontalAdapter(this,getActivity(),homeHorizontalModelList);
        homeHorizontalRecycler.setAdapter(homeHorizontalAdapter);
        homeHorizontalRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRecycler.setHasFixedSize(true);
        homeHorizontalRecycler.setNestedScrollingEnabled(false);
        /////////////vertical
        homeVerticalModelList = new ArrayList<>();


        homeVerticalAdapter=new HomeVerticalAdapter(getActivity(),homeVerticalModelList);
        homeVerticalRecycler.setAdapter(homeVerticalAdapter);
        homeVerticalRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerticalModel> list) {

        homeVerticalAdapter=new HomeVerticalAdapter(getContext(),list);
        homeVerticalAdapter.notifyDataSetChanged();
        homeVerticalRecycler.setAdapter(homeVerticalAdapter);




    }
}