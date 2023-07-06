package org.example.Enums;

public enum Distance {
    MM(1),
    CM(10),
    M(1000),
    KM(1000000),
    MILE(1609344),
    YARD(914.4);

    private double value;

    Distance(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}


