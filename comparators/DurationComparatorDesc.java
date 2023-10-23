package com.tourism.utils.comparators;

import com.tourism.models.Tour;

import java.util.Comparator;

public class DurationComparatorDesc implements Comparator<Tour> {
    @Override
    public int compare(Tour tour1, Tour tour2) {
        return Integer.compare(tour2.getDays(), tour1.getDays());
    }
}
