
package main.java.routerider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private TextView latitudeTextView;
    private TextView longitudeTextView;
    private Button trackingButton;
    private boolean isTracking = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        latitudeTextView = root.findViewById(R.id.latitudeTextView);
        longitudeTextView = root.findViewById(R.id.longitudeTextView);
        trackingButton = root.findViewById(R.id.trackingButton);

        trackingButton.setOnClickListener(v -> toggleTracking());

        return root;
    }

    private void toggleTracking() {
        isTracking = !isTracking;
        if (isTracking) {
            trackingButton.setText(R.string.stop_tracking);
            // Start location updates
            updateLocation();
        } else {
            trackingButton.setText(R.string.start_tracking);
            // Stop location updates
        }
    }

    private void updateLocation() {
        // In a real app, you would use LocationManager or FusedLocationProviderClient
        // This is just a simulation
        double latitude = Math.random() * 180 - 90;
        double longitude = Math.random() * 360 - 180;
        latitudeTextView.setText(String.format("Latitude: %.4f", latitude));
        longitudeTextView.setText(String.format("Longitude: %.4f", longitude));
    }
}
