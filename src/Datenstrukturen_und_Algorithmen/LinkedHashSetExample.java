package Datenstrukturen_und_Algorithmen;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.DoubleStream;

public class LinkedHashSetExample {

    public static void main(String[] args) {

        double[] values = new double[]{2.0, 3.0, 2.0, 4.0, 2.0, 5.0, 3.0, 6.0, 2.0, 4.0, 7.0};

        double[] uniqueValues = unique2(values);

        for(double value : uniqueValues) {
            System.out.println(value);
        }
    }

    public static double[] unique(double... values) {

        if ( values == null ) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        Set<Double> uniqueValues = new LinkedHashSet<>();

        for (double value : values) {
            uniqueValues.add(value);
        }

        double[] result = new double[uniqueValues.size()];
        int i = 0;

        for (Double value : uniqueValues) {
            result[i++] = value;
        }

        return result;
    }

    public static double[] unique2(double... values) {
        return DoubleStream.of(values).distinct().toArray();
    }
}
