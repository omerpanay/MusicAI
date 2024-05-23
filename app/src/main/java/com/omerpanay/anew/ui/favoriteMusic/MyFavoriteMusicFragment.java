package com.omerpanay.anew.ui.favoriteMusic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.omerpanay.anew.fromAPI.ApiInterface;
import com.omerpanay.anew.fromAPI.Datum;
import com.omerpanay.anew.adapters.MyAdapter;
import com.omerpanay.anew.fromAPI.MyData;
import com.omerpanay.anew.databinding.FragmentMyFavoriteMusicsBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



import java.util.List;


public class MyFavoriteMusicFragment extends Fragment {

    private FragmentMyFavoriteMusicsBinding binding;
    private MyAdapter myAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMyFavoriteMusicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Retrofit çağrısı
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<MyData> call = apiInterface.getData("eminem");
        call.enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
                if (response.isSuccessful()){
                    MyData myData = response.body();
                    if (myData != null) {
                        List<Datum> dataList = myData.getData();
                        myAdapter = new MyAdapter(getActivity(), dataList);
                        binding.recyclerViewFavori.setAdapter(myAdapter);
                        binding.recyclerViewFavori.setLayoutManager(new LinearLayoutManager(getActivity()));
                    }
                } else {
                    // response.isSuccessful() false olduğunda yapılacaklar
                }
            }

            @Override
            public void onFailure(Call<MyData> call, Throwable t) {
                t.printStackTrace();
                // Hata durumunda yapılacaklar
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
