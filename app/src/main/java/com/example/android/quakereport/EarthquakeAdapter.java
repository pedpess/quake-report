package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private String location;
    private String locationOffset;
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake earthquakeAdapter = getItem(position);

        String originalLocation = earthquakeAdapter.getLocation();

        trimStringLocationOffset(originalLocation);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(FormatterUtil.formatScaleNumber(earthquakeAdapter.getMagnitude()));

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(location);

        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetTextView.setText(locationOffset);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(FormatterUtil.formatDate(new Date(earthquakeAdapter.getDate())));

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        timeTextView.setText(FormatterUtil.formatTime(new Date(earthquakeAdapter.getDate())));

        return listItemView;
    }

    private void trimStringLocationOffset(String originalLocation) {
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            location = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            location = originalLocation;
        }
    }
}
