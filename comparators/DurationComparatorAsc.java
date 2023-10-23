package com.tourism.utils.comparators;

import com.tourism.models.Tour;

import java.util.Comparator;

public class DurationComparatorAsc implements Comparator<Tour> {
    @Override
    public int compare(Tour tour1, Tour tour2) {
        return Integer.compare(tour1.getDays(), tour2.getDays());
    }
}
