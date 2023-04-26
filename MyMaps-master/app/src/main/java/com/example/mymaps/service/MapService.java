package com.example.mymaps.service;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.mymaps.R;
import com.example.mymaps.db.ImitationDB;
import com.example.mymaps.domain.Place;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MapService implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener{

    private final Context context;

    public MapService(Context context) {
        this.context = context;
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        Toast.makeText(context, latLng.latitude + " "
                + latLng.longitude, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        Toast.makeText(context, "LONG " + latLng.latitude + " "
                + latLng.longitude, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setOnMapClickListener(this);
        googleMap.setOnMapLongClickListener(this);
        for (Place p: ImitationDB.getPlaces()) {
            googleMap.addMarker(new MarkerOptions().position(p.getLatLng()).title(p.getName()));
        }
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                Place place = ImitationDB.getPlaceByName(marker.getTitle());
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_fragment);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView tv_name = dialog.getWindow().findViewById(R.id.tv_name);
                TextView tv_address = dialog.getWindow().findViewById(R.id.tv_address);
                TextView tv_info = dialog.getWindow().findViewById(R.id.tv_description);
                tv_name.setText(place.getName());
                tv_address.setText(place.getAddress());
                tv_info.setText(place.getInformation());
                ImageView imageView = dialog.getWindow().findViewById(R.id.iv_image);
                FirebaseStorage firebaseStorage =
                        FirebaseStorage.getInstance("gs://mymaps-b35de.appspot.com");
                StorageReference reference = firebaseStorage.getReference(place.getPathToImage());
                Glide.with(context).load(reference).into(imageView);
                return false;
            }
        });
    }
    private void showDialog(){}
}
