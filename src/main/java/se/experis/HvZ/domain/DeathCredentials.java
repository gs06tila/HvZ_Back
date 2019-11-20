package se.experis.HvZ.domain;

public class DeathCredentials {
    private String victimBiteCode;
    private int killerId;
    private double lng;
    private double lat;

    public String getVictimBiteCode() {
        return victimBiteCode;
    }

    public void setVictimBiteCode(String victimBiteCode) {
        this.victimBiteCode = victimBiteCode;
    }

    public int getKillerId() {
        return killerId;
    }

    public void setKillerId(int killerId) {
        this.killerId = killerId;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
