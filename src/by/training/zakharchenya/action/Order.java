package by.training.zakharchenya.action;

import by.training.zakharchenya.entity.UberSevice;
import by.training.zakharchenya.entity.location.Location;
import by.training.zakharchenya.entity.user.Car;
import by.training.zakharchenya.entity.user.Client;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Order extends Thread {
    static final Logger LOGGER = LogManager.getLogger(Order.class);
    private Location startLocation;
    private Location finishLocation;
    private Client client;

    public Order(Location start, Location finish, Client cl){
        startLocation = start;
        finishLocation = finish;
        client = cl;
    }

    @Override
    public void run(){
        try {
            UberSevice uber = UberSevice.getInstance();

            Car car;
            do{
                car = UberSevice.getList().bookBestCar(this.startLocation);
            }while(car == null);

            LOGGER.log(Level.INFO, client + " is waiting for a car: " + car);

            double dist1 = Location.calculateDistance(this.startLocation, car.getLocation());
            double dist2 = Location.calculateDistance(this.startLocation, this.finishLocation);

            TimeUnit.MILLISECONDS.sleep((long)(dist1*car.getSpeed()));
            LOGGER.log(Level.INFO, client + " started the trip");

            TimeUnit.MILLISECONDS.sleep((long)(dist2*car.getSpeed()));
            LOGGER.log(Level.INFO, client + " was served");

            car.setLocation(this.finishLocation);
            UberSevice.getList().returnCar(car);

            LOGGER.log(Level.INFO, car + " is free now with new " + car.getLocation());

        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "");
        }
    }
}
