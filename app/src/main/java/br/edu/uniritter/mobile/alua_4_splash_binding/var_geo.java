package br.edu.uniritter.mobile.alua_4_splash_binding;

public class var_geo {

    public double lat;
    public double lng;

    public var_geo(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() { return lng; }

    public void setLng(double lng) { this.lng = lng; }
}
