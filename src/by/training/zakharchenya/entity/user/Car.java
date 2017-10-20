package by.training.zakharchenya.entity.user;

import by.training.zakharchenya.entity.location.Location;

public class Car extends UberUser {
    private long speed;

    public Car(String name, Location location, long speed) {
        super(name, location);
        this.speed = speed;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        return speed == car.speed;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (speed ^ (speed >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() +
                " speed: " + speed +
                '}';
    }
}
