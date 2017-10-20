package by.training.zakharchenya.demo;

import by.training.zakharchenya.entity.UberSevice;
import by.training.zakharchenya.entity.location.Location;
import by.training.zakharchenya.entity.user.Client;
import by.training.zakharchenya.reader.LocationReader;

import java.util.List;

public class Demo {
    static final String INPUT = "input/locationData.txt";
    public static void main(String args[]){

        UberSevice.startUberService();
        List<Location> locs = LocationReader.readFromFile(INPUT);

        new Client("Mike Johnson",      locs.get(0)).makeOrder(locs.get(1));
        new Client("Jack Richardson",   locs.get(2)).makeOrder(locs.get(0));
        new Client("Vadim Ivanov",      locs.get(1)).makeOrder(locs.get(3));
        new Client("Olga Malysheva",    locs.get(4)).makeOrder(locs.get(5));
        new Client("Dima Buiny",        locs.get(3)).makeOrder(locs.get(0));
        new Client("Alex Sipov",        locs.get(2)).makeOrder(locs.get(1));
        new Client("Andrew Karsky",     locs.get(0)).makeOrder(locs.get(2));
        new Client("Vlad Kozlov",       locs.get(5)).makeOrder(locs.get(0));
        new Client("Konstantin Polita", locs.get(7)).makeOrder(locs.get(6));
        new Client("Amir Guldy",        locs.get(2)).makeOrder(locs.get(3));
        new Client("Olga Malysheva",    locs.get(4)).makeOrder(locs.get(5));
        new Client("Dima Buiny",        locs.get(3)).makeOrder(locs.get(0));
        new Client("Alex Sipov",        locs.get(2)).makeOrder(locs.get(1));
        new Client("Andrew Karsky",     locs.get(0)).makeOrder(locs.get(2));
        new Client("Mike Johnson",      locs.get(0)).makeOrder(locs.get(1));
        new Client("Jack Richardson",   locs.get(2)).makeOrder(locs.get(0));
        new Client("Vadim Ivanov",      locs.get(1)).makeOrder(locs.get(3));
        new Client("Andrew Karsky",     locs.get(0)).makeOrder(locs.get(2));
        new Client("Vlad Kozlov",       locs.get(5)).makeOrder(locs.get(0));
        new Client("Konstantin Polita", locs.get(7)).makeOrder(locs.get(6));
        new Client("Amir Guldy",        locs.get(2)).makeOrder(locs.get(3));
    }
}
