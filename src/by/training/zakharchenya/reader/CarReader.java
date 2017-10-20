package by.training.zakharchenya.reader;

import by.training.zakharchenya.entity.FreeCars;
import by.training.zakharchenya.parser.CarParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CarReader {
    static final Logger LOGGER = LogManager.getLogger(CarReader.class);

    public static FreeCars readFromFile(String source){
        FreeCars res = null;
        List<String> data = new ArrayList();
        try{
            res = new FreeCars();
            Files.lines(Paths.get(source), StandardCharsets.UTF_8).forEach(value -> data.add(value));
            for(String temp : data){
                if(CarParser.parseCar(temp) != null) { res.addCar(CarParser.parseCar(temp));}
            }
        } catch (IOException e){
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException("No data!");
        }
        return res;
    }
}
