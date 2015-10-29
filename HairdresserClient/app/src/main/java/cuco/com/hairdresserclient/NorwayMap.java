package cuco.com.hairdresserclient;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eagle on 29/10/15.
 */
public class NorwayMap extends FragmentActivity{

    GoogleMap norwayMap;

    // List of markers
    List<Marker> listMarker = new ArrayList<Marker>();

    // Hairdresser objects
    List<hairdresserObjects> hObjectsList = new ArrayList<hairdresserObjects>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.norway_map);
        setUpMapIfNeeded();

        // Setting a custom info window adapter for the google map
        norwayMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            // Defines the contents of the InfoWindow
            @Override
            public View getInfoContents(Marker marker) {
                // Getting view from the layout file windowinfolayout
                View v = getLayoutInflater().inflate(R.layout.window_hairdresser_info, null);

                // Getting reference to the TextView to set hairdresserName
                TextView hName = (TextView) v.findViewById(R.id.hairdresserName);
                // Getting reference to the TextView to set address
                TextView hAddress = (TextView) v.findViewById(R.id.hairdresserAddress);
                // Getting reference to the TextView to set schedule
                TextView hSchedule = (TextView) v.findViewById(R.id.hairdresserSchedule);
                // Getting reference to the TextView to set email
                TextView hEmail = (TextView) v.findViewById(R.id.hairdresserEmail);
                // Getting reference to the TextView to set phone
                TextView hPhone = (TextView) v.findViewById(R.id.hairdresserPhone);
                // Getting reference to the TextView to set type
                TextView hType = (TextView) v.findViewById(R.id.hairdresserType);
                // Getting reference to the TextView to set type
                TextView hFacebook = (TextView) v.findViewById(R.id.hairdresserFacebook);

                for (hairdresserObjects hObj : hObjectsList) {

                    // fill the layout with the specific hairdresser information
                    //if (hObj.getHairdresserName().equals(marker.getTitle()+" "+hObj.getAddress())) {
                    //if (marker.getTitle().equals(hObj.getHairdresserName() + " " + hObj.getAddress())) {
                        hName.setText(hObj.getHairdresserName());
                        hAddress.setText(hObj.getAddress());

                        hSchedule.setText(hObj.getSchedule());
                        hEmail.setText(hObj.getEmail());
                        hPhone.setText(hObj.getPhone());
                        hType.setText(hObj.gethType());
                        hFacebook.setText(hObj.getFacebookPage());

                     //   break;
                    //}
                }
                return v;
            }
        });


    }

    private void setUpMapIfNeeded() {

        // Do a null check to confirm that we have not already instantiated the map.
        if (norwayMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            norwayMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Hide the zoom controls as the button panel will cover it
            norwayMap.getUiSettings().setZoomControlsEnabled(true);

            // Set map type getting configuration from Sharedsettings
            /*MapConfiguration mConf = new MapConfiguration();

            SharedPreferences mapSettings = getSharedPreferences("mapType", 0);
            boolean mTypeNormal = mapSettings.getBoolean("normal", false);
            boolean mTypeSatellite = mapSettings.getBoolean("satellite", false);
            boolean mTypeTerrain = mapSettings.getBoolean("terrain", false);*/

            /*if (mTypeNormal) {
                mMap.setMapType(1);

            }
            if (mTypeSatellite) {
                mMap.setMapType(2);

            }
            if (mTypeTerrain) {
                mMap.setMapType(3);

            }*/

            // Set default camera position and zoom
            LatLng defaultlLatLong = new LatLng(60.8175897, 11.0134724);
            CameraUpdate center = CameraUpdateFactory.newLatLng(defaultlLatLong);
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(5);
            norwayMap.moveCamera(center);
            norwayMap.animateCamera(zoom);

            // Buildings enabled
            norwayMap.setBuildingsEnabled(true);

            // Check if we were successful in obtaining the map.
            if (norwayMap != null) {
                //new ConnectAsync().execute();
                setUpMap("Manolo" + " " + "Holsetgata street", "60.7967395", "11.0735713");
                hairdresserObjects oTest = new hairdresserObjects();
                oTest.setHairdresserName("headZUP");
                oTest.setAddress("Torggata 13");
                oTest.setSchedule("10-22");
                oTest.setEmail("empty");
                oTest.setPhone("62 52 99 88");
                oTest.sethType("Unisex");
                oTest.setFacebookPage("Empty");
                hObjectsList.add(oTest);
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #norwayMap} is not null.
     */
    public void setUpMap(String hairdresserName, String lat, String longi) {
        // Create latitude and longitude for this specific location
        LatLng LatLongHairdresser = new LatLng(Double.parseDouble(lat), Double.parseDouble(longi));
        // Add location to the map
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.p)).position(LatLongHairdresser).title(hairdresserName));
        Marker mark = norwayMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).position(LatLongHairdresser).title(hairdresserName));
        // Add marker to the ArrayList
        listMarker.add(mark);

    }

}
