package com.tourism.utils.comparators;

import com.tourism.models.Tour;

import java.util.Comparator;

public class PriceComparatorDesc implements Comparator<Tour> {
    @Override
    public int compare(Tour tour1, Tour tour2) {
        return Double.compare(tour2.getPrice(), tour1.getPrice());
    }
}
