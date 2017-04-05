package com.acadgild.session15;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ReadymadeMapActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {

    private GoogleMap mMap;
    LocationRequest request;
    Location myPresentLocation;
    GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readymade_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ////// Location Reading Code

        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int status = apiAvailability.isGooglePlayServicesAvailable(this);
        if (status == ConnectionResult.SUCCESS) {
            request = new LocationRequest();
            request.setInterval(2000);
            request.setFastestInterval(1000);
            request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

            client = new GoogleApiClient.Builder(this)
                    .addOnConnectionFailedListener(this)
                    .addConnectionCallbacks(this)
                    .addApi(LocationServices.API)
                    .build();
            client.connect();
        } else {
            Toast.makeText(this, "Location Service is Unavailable..", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng indiaLatitudeLongitude = new LatLng(20.5937, 78.9629);
        MarkerOptions indiaMarker = new MarkerOptions();
        indiaMarker.position(indiaLatitudeLongitude);
        indiaMarker.title("I Love My India...");
        indiaMarker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        mMap.addMarker(indiaMarker);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(indiaLatitudeLongitude));
        CameraPosition newPosition = new CameraPosition.Builder()
                .target(indiaLatitudeLongitude)
//                .zoom(14)
                .build();


        MarkerOptions mumbai = new MarkerOptions();
        mumbai.position(new LatLng(20, 78));
        mumbai.title("Mumbai");
        mMap.addMarker(mumbai);
        mMap.addCircle(new CircleOptions().center(new LatLng(20, 78)).radius(20000));

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(newPosition));


    }

    MarkerOptions presentLocationmarker = new MarkerOptions();

    void updateUIMap() {
        if (myPresentLocation != null) {
            LatLng myLocationDimensions = new LatLng(myPresentLocation.getLatitude(), myPresentLocation.getLongitude());
            presentLocationmarker.position(myLocationDimensions);
            presentLocationmarker.title("I'm here");
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(myLocationDimensions)
                    .build();

            mMap.addMarker(presentLocationmarker);
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        }
    }

    @Override
    public void onLocationChanged(Location location) {
        myPresentLocation = location;
        Toast.makeText(this, "Changed the Location" + location, Toast.LENGTH_SHORT).show();
        updateUIMap();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "Connection to Google Service Failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Toast.makeText(this, "Connected to Google Service", Toast.LENGTH_SHORT).show();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission Not granted", Toast.LENGTH_SHORT).show();

            return;
        } else
            Toast.makeText(this, "Registred for location updates", Toast.LENGTH_SHORT).show();
        PendingResult<Status> pendingResult = LocationServices.FusedLocationApi.requestLocationUpdates(client, request, this);


//        updateUIMap();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(this, "Google Denied the Connection", Toast.LENGTH_SHORT).show();

    }
}
