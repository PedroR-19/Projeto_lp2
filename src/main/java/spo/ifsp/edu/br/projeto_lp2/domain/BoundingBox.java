package spo.ifsp.edu.br.projeto_lp2.domain;

public class BoundingBox {
    private double minLatitude;
    private double maxLatitude;
    private final double minLongitude;
    private final double maxLongitude;

    public BoundingBox(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude) {
        if (minLatitude > maxLatitude) {
            throw new IllegalArgumentException("minLatitude can't be greater than maxLatitude");
        }

        if (minLongitude > maxLongitude) {
            throw new IllegalArgumentException("minLongitude can't be greater than maxLongitude");
        }

        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
    }

    public double getLatitudeMin() {
        return minLatitude;
    }

    public void setLatitudeMin(double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public double getLatitudeMax() {
        return maxLatitude;
    }

    public void setLatitudeMax(double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public boolean isInside(Coordinates coordinates) {
        var latitude = coordinates.getLatitude();
        var longitude = coordinates.getLongitude();

        return latitude >= minLatitude && latitude <= maxLatitude && longitude >= minLongitude && longitude <= maxLongitude;

    }
}
