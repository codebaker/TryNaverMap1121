package com.codebakery.joan.trynavermap1121;

import android.graphics.Color;
import android.graphics.PointF;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationSource;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Align;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.util.MarkerIcons;

public class RetainedMapFragmentInLayoutActivity extends AppCompatActivity{
    static int cnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retained_map_fragment_in_layout);

        MapFragment mapFragment = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.setRetainInstance(true);
        mapFragment.getMapAsync(this::onMapReady);
    }

    @UiThread
    //@Override
    // OnMapReadyCallback
    public void onMapReady(@NonNull NaverMap naverMap) {
        naverMap.setOnMapClickListener( (point, latLng) -> {

                Marker marker = new Marker(MarkerIcons.PINK);
                marker.setPosition(latLng);
                marker.setCaptionAlign(Align.Top);
                marker.setCaptionText(latLng.toString());
                marker.setMap(naverMap);

                marker.setOnClickListener(overlay -> {
                    overlay.setMap(null);
                    return true;
                });

        });

    }
}
