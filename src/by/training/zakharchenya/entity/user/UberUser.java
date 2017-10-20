package by.training.zakharchenya.entity.user;

import by.training.zakharchenya.entity.location.Location;

abstract public class UberUser {
    protected String name;
    protected Location location;


    public UberUser(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UberUser uberUser = (UberUser) o;

        if (!name.equals(uberUser.name)) return false;
        return location.equals(uberUser.location);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  " '" + name + '\'' +
                ", " + location +
                '}';
    }
}
