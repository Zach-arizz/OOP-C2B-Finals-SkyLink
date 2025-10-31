public final class AviationMath {
    private static final int EARTH_RADIUS_KM = 6371;

    private AviationMath() {}

    public static double calculateDistanceBetween(Waypoint start, Waypoint end) {
        double lat1 = Math.toRadians(start.latitude());
        double lon1 = Math.toRadians(start.longitude());
        double lat2 = Math.toRadians(end.latitude());
        double lon2 = Math.toRadians(end.longitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.pow(Math.sin(dLon / 2), 2)
                * Math.cos(lat1) * Math.cos(lat2);

        double c = 2 * Math.asin(Math.sqrt(a));

        return EARTH_RADIUS_KM * c;
    }
}
