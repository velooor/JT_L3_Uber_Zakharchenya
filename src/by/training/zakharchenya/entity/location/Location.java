package by.training.zakharchenya.entity.location;

public class Location {
    private String address;
    private Region region;
    private int x;
    private int y;

    public Location(String address, int x, int y) {
        this.address = address;
        this.region = regionParser(x, y);
        this.x = x;
        this.y = y;
    }

    public static Region regionParser(int x, int y){
        if((x >= 0) && (y >= 0)) {return Region.LAKE_DISTRICT;}
        else if((x <= 0) && (y >= 0)) {return Region.DOWNTOWN;}
        else if((x <= 0) && (y <= 0)) {return Region.SILENT_DISTRICT;}
        else if((x >= 0) && (y <= 0)) {return Region.MARKET_DISTRICT;}
        else return null;
    }

    public static double calculateDistance(Location a, Location b){
        return Math.sqrt(Math.pow((a.getX()-b.getX()),2) + Math.pow((a.getY()-b.getY()),2));
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "'" + address + '\'' +
                ",  " + region +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
