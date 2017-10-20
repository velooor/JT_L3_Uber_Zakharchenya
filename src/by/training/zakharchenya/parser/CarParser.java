package by.training.zakharchenya.parser;

import by.training.zakharchenya.entity.location.Location;
import by.training.zakharchenya.entity.user.Car;
import by.training.zakharchenya.exception.WrongParameterException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarParser {
    static final Logger LOGGER = LogManager.getLogger(CarParser.class);
    public static Car parseCar(String line) {
        try{
            if(line.isEmpty()) { throw new WrongParameterException("There no parameters in the line!"); }
            String[] string = line.split(" ");
            if(string.length != 5){ throw new WrongParameterException("There are not enough parameters!"); }

            String name = string[0];
            int x = Integer.parseInt(string[1]);
            int y = Integer.parseInt(string[2]);
            String address = string[3];
            long speed = Long.parseLong(string[4]);

            return new Car(name, new Location(address, x, y), speed);

        } catch (WrongParameterException e){
            LOGGER.log(Level.WARN, e);
        }
        return null;
    }


}
