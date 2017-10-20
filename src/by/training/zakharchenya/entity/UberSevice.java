package by.training.zakharchenya.entity;

import by.training.zakharchenya.reader.CarReader;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UberSevice {
    private static UberSevice instance;
    private static AtomicBoolean flag = new AtomicBoolean();
    private static Lock locker = new ReentrantLock();
    static final String INPUT = "input/carsData.txt";

    private static FreeCars list = new FreeCars();

    private UberSevice() {
    }

    public static UberSevice getInstance() {
        if (!flag.get()) {
            locker.lock();
            try {
                if (instance == null) {
                    instance = new UberSevice();
                }
            } finally {
                locker.unlock();
            }
        }
        return instance;
    }

    public static FreeCars getList() {
        return list;
    }

    public static void startUberService(){
        list = CarReader.readFromFile(INPUT);
    }
}
