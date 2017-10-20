package by.training.zakharchenya.entity.user;

import by.training.zakharchenya.entity.location.Location;
import by.training.zakharchenya.action.Order;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client extends UberUser {
    static final Logger LOGGER = LogManager.getLogger(Client.class);

    public Client(String name, Location location) {
        super(name, location);
    }

    public void makeOrder(Location finishLocation){
        LOGGER.log(Level.INFO, this + " make an order.");
        new Order(this.location, finishLocation, this).start();
    }

    @Override
    public String toString() {
        return "Client " + super.toString();
    }
}
