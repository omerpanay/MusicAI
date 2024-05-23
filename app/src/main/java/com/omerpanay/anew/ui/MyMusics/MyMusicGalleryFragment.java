package com.omerpanay.anew.ui.MyMusics;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.omerpanay.anew.R;
import com.omerpanay.anew.adapters.MyMusicGalleryAdapter;
import com.omerpanay.anew.databinding.FragmentMyMusicGalleryBinding;
import com.omerpanay.anew.models.MyMusicGallery;

import java.util.ArrayList;
import java.util.List;

public class MyMusicGalleryFragment extends Fragment {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1001;
    private static final int CAMERA_REQUEST_CODE = 1002;
    private FragmentMyMusicGalleryBinding binding;
    private MediaPlayer mediaPlayer;
    private MyMusicGalleryAdapter adapter;
    private List<MyMusicGallery> musicList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMyMusicGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        musicList = new ArrayList<>();
        adapter = new MyMusicGalleryAdapter(getContext(), musicList);
        binding.listMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.listMusic.setAdapter(adapter);

        binding.buttonCapture.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CAMERA},
                        CAMERA_PERMISSION_REQUEST_CODE);
            } else {
                openCamera();
            }
        });

        loadInitialMusicList();

        return root;
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
    }

    private void loadInitialMusicList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(getContext(), "Kamera izni reddedildi.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == getActivity().RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            detectFaces(photo);
        }
    }

    private void detectFaces(Bitmap bitmap) {
        InputImage image = InputImage.fromBitmap(bitmap, 0);

        FaceDetectorOptions options =
                new FaceDetectorOptions.Builder()
                        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                        .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
                        .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
                        .build();

        FaceDetector detector = FaceDetection.getClient(options);

        detector.process(image)
                .addOnSuccessListener(
                        faces -> {
                            for (Face face : faces) {
                                float smileProb = face.getSmilingProbability() != null ? face.getSmilingProbability() : 0;
                                float leftEyeOpenProb = face.getLeftEyeOpenProbability() != null ? face.getLeftEyeOpenProbability() : 0;
                                float rightEyeOpenProb = face.getRightEyeOpenProbability() != null ? face.getRightEyeOpenProbability() : 0;

                                String emotion = determineEmotion(smileProb, leftEyeOpenProb, rightEyeOpenProb);
                                showEmotion(emotion);
                            }
                        })
                .addOnFailureListener(
                        e -> Log.e("Face Detection", "Face detection failed", e));
    }

    private String determineEmotion(float smileProb, float leftEyeOpenProb, float rightEyeOpenProb) {
        if (smileProb > 0.5) {
            return "Mutlu";
        }  else {
            return "Üzgün";
        }
    }


    private void showEmotion(String emotion) {
        binding.textEmotion.setText("Duygu Durumu: " + emotion);
        Toast.makeText(getContext(), "Duygu Durumu: " + emotion, Toast.LENGTH_SHORT).show();

        List<MyMusicGallery> newMusicList = getMusicListForEmotion(emotion);
        musicList.clear();
        musicList.addAll(newMusicList);
        adapter.notifyDataSetChanged();
    }

    private List<MyMusicGallery> getMusicListForEmotion(String emotion) {
        List<MyMusicGallery> newMusicList = new ArrayList<>();
        switch (emotion) {
            case "Mutlu":
                newMusicList.add(new MyMusicGallery(R.drawable.eminem, "Lose Yourself", "Audio", "Eminem", R.raw.eminemwithoutme));
                newMusicList.add(new MyMusicGallery(R.drawable.eminem2, "Till I Collapse", "Audio", "Eminem", R.raw.colapse));
                newMusicList.add(new MyMusicGallery(R.drawable.samiyusuf, "Allah-u Allah", "Audio", "Sami Yusuf", R.raw.samiyusufAllahuAllah));
                newMusicList.add(new MyMusicGallery(R.drawable.samiyusuf1, "Paradise", "Audio", "Sami Yusuf", R.raw.samiyusufparadise));
                newMusicList.add(new MyMusicGallery(R.drawable.maherzain6, "Ghafuru Rahim", "Audio", "Maher Zain", R.raw.mahergafururahim));
                newMusicList.add(new MyMusicGallery(R.drawable.maherzain2, "For the Rest of My Life", "Audio", "Maher Zain", R.raw.maherfortherest));
                newMusicList.add(new MyMusicGallery(R.drawable.samiyusuf3, "Eigen", "Audio", "Sami Yusuf", R.raw.samiyusufEigen));
                newMusicList.add(new MyMusicGallery(R.drawable.eminem, "Mocking Bird", "Audio", "Eminem", R.raw.eminemmockingbird));
                newMusicList.add(new MyMusicGallery(R.drawable.eminem4, "Real Slim", "Audio", "Eminem", R.raw.eminemrealslim));
                newMusicList.add(new MyMusicGallery(R.drawable.maherzain3, "Rahmetelil Alemin", "Audio", "Maher Zain", R.raw.maherrahmatelilalemin));
                newMusicList.add(new MyMusicGallery(R.drawable.eminem2, "Without Me", "Audio", "Eminem", R.raw.eminemwithoutme));
                newMusicList.add(new MyMusicGallery(R.drawable.maherzain5, "Sallam-u Alayka", "Audio", "Maher Zain", R.raw.mahersallamalayka));
                newMusicList.add(new MyMusicGallery(R.drawable.maherzain6, "Ya Nabi", "Audio", "Maher Zain", R.raw.maheryanabi));
                newMusicList.add(new MyMusicGallery(R.drawable.samiyusuf4, "Journey", "Audio", "Sami Yusuf", R.raw.samiyusufpurney));
                newMusicList.add(new MyMusicGallery(R.drawable.samiyusuf4, "Nasimi", "Audio", "Sami Yusuf", R.raw.samiyusufnasimi));
                newMusicList.add(new MyMusicGallery(R.drawable.samiyusuf4, "You Came To Me", "Audio", "Sami Yusuf", R.raw.samiyusufyoucametome));
                break;
            case "Üzgün":
                newMusicList.add(new MyMusicGallery(R.drawable.zeynepbastikjpg, "Lan", "Audio", "Zeynep Bastık", R.raw.zeyneplan));
                newMusicList.add(new MyMusicGallery(R.drawable.azerbulbul2, "İyi Değilim", "Audio", "Azer Bülbül", R.raw.azeriyidegilim));
                newMusicList.add(new MyMusicGallery(R.drawable.eylemaktas, "Fikrimin İnce Gülü", "Audio", "Eylem Aktaş", R.raw.eylemfikrimin));
                newMusicList.add(new MyMusicGallery(R.drawable.ferdi3, "Yüreğimde Yara", "Ferdi Tayfur", "Eminem", R.raw.ferdiyuregimdeyara));
                newMusicList.add(new MyMusicGallery(R.drawable.muslumkuskun, "Küskünüm", "Audio", "Müslüm Gürses", R.raw.muslumkuskunum));
                newMusicList.add(new MyMusicGallery(R.drawable.ferdi4, "Emmioğlu", "Audio", "Ferdi Tayfur", R.raw.ferdiemmioglu));
                newMusicList.add(new MyMusicGallery(R.drawable.muslum_gurses, "Seni Yazdım", "Audio", "Müslüm Gürses", R.raw.muslumseniyazdim));
                newMusicList.add(new MyMusicGallery(R.drawable.kentttt, "Deniz Anlatıyor mu beni sana", "Audio", "Kent Şarkıları", R.raw.kentdeniz));

                newMusicList.add(new MyMusicGallery(R.drawable.kentttt, "Tut Elimi Yüreğimin", "Audio", "Kent Şarkıları", R.raw.kenttutelimi));
                newMusicList.add(new MyMusicGallery(R.drawable.kentttt, "Hayat Devam Ediyor", "Audio", "Kent Şarkıları", R.raw.kenthayatdevam));
                newMusicList.add(new MyMusicGallery(R.drawable.azerbulbul2, "Duygularım", "Audio", "AZ", R.raw.azerduygularim));
                break;
        }
        return newMusicList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
