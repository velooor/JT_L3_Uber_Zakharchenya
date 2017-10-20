package by.training.zakharchenya.entity;

import by.training.zakharchenya.entity.location.Location;
import by.training.zakharchenya.entity.location.Region;
import by.training.zakharchenya.entity.user.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class FreeCars {
    private List<Car> list = new ArrayList<>();
    private static Lock locker = new ReentrantLock();
    public static final Logger LOGGER = LogManager.getLogger(FreeCars.class);

    public void addCar(Car car) {
        locker.lock();
        try {
            list.add(car);
        } finally {
            locker.unlock();
        }
    }
    public void returnCar(Car car) {
        locker.lock();
        try {
            list.add(car);
        } finally {
            locker.unlock();
        }
    }

    public Car bookBestCar(Location start) {
        Car bestCar;
        try {
            locker.lock();
            if(list.isEmpty()) return null;
            Region region = start.getRegion();

            double bestDistance;
            int bestIndex = 0;
            bestCar = list.get(0); bestDistance = Location.calculateDistance(start, bestCar.getLocation());
            for(int i = 0; i < list.size(); i++){
                Car car = list.get(i);
                if(region == Location.regionParser(car.getLocation().getX(), car.getLocation().getY())){
                    if(Location.calculateDistance(start, car.getLocation()) < bestDistance) {
                        bestCar = car;
                        bestIndex = i;
                    }
                }
            }
            list.remove(bestIndex);

        } finally {
            locker.unlock();
        }
        return bestCar;
    }
    public void setList(List<Car> list) {
        this.list = list;
    }

    public boolean hasCar() {
        locker.lock();
        try {
            return !list.isEmpty();
        } finally {
            locker.unlock();
        }
    }


}
