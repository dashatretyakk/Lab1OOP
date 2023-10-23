package com.tourism.utils.comparators;

import com.tourism.models.Tour;

import java.util.Comparator;

public class PriceComparatorAsc implements Comparator<Tour> {
    @Override
    public int compare(Tour tour1, Tour tour2) {
        return Double.compare(tour1.getPrice(), tour2.getPrice());
    }
}

