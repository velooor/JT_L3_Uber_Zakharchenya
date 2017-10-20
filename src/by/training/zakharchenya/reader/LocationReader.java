package by.training.zakharchenya.reader;

import by.training.zakharchenya.entity.FreeCars;
import by.training.zakharchenya.entity.location.Location;
import by.training.zakharchenya.parser.CarParser;
import by.training.zakharchenya.parser.LocationParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LocationReader {
        static final Logger LOGGER = LogManager.getLogger(LocationReader.class);

        public static List<Location> readFromFile(String source){
            List<Location> res = null;
            List<String> data = new ArrayList();
            try{
                res = new ArrayList<>();
                Files.lines(Paths.get(source), StandardCharsets.UTF_8).forEach(value -> data.add(value));
                for(String temp : data){
                    if(LocationParser.parseLocation(temp) != null) { res.add(LocationParser.parseLocation(temp));}
                }
            } catch (IOException e){
                LOGGER.log(Level.FATAL, e);
                throw new RuntimeException("No data!");
            }
            return res;
        }
    }
