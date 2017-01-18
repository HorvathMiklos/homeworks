package xyz.codingmentor.javaeehomework.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.javaeehomework.beans.Device;
import xyz.codingmentor.javaeehomework.db.DeviceDB;
import xyz.codingmentor.javaeehomework.exceptions.NotEnoughDeviceExeption;
import xyz.codingmentor.javaeehomework.exceptions.NotExistingDeviceException;

/**
 *
 * @author mhorvath
 */
public class Cart {

    private Map<String, Integer> devicesInCart;
    private DeviceDB deviceDB;
    private static final Logger LOGGER = Logger.getLogger("myLogger");

    public Cart(DeviceDB deviceDB) {
        this.deviceDB = deviceDB;
        devicesInCart = new HashMap<>();
    }

    public void addDevice(String iD, int count) {
        Device editDevice;
        if (!deviceDB.isExistingDevice(iD)) {
            throw new NotExistingDeviceException();
        }
        if (deviceDB.getDevice(iD).getCount() > count) {
            throw new NotEnoughDeviceExeption();
        }
        if (devicesInCart.containsKey(iD)) {
            devicesInCart.put(iD, devicesInCart.get(iD) + count);
        } else {
            devicesInCart.put(iD, count);
        }
        editDevice = deviceDB.getDevice(iD);
        editDevice.setCount(editDevice.getCount() - count);
        deviceDB.editDevice(editDevice);
    }

    public void deleteDevice(String iD, int count) {
        Device editDevice;
        if (!devicesInCart.containsKey(iD)) {
            throw new NotExistingDeviceException();
        }
        if (devicesInCart.get(iD) < count) {
            throw new NotEnoughDeviceExeption();
        }
        devicesInCart.put(iD, devicesInCart.get(iD) - count);
        if (deviceDB.isExistingDevice(iD)) {
            editDevice = deviceDB.getDevice(iD);
            editDevice.setCount(editDevice.getCount() + count);
            deviceDB.editDevice(editDevice);
        } else {
            throw new NotExistingDeviceException();
        }
    }

    public void delete() {
        for (Map.Entry<String,Integer> entry : devicesInCart.entrySet()) {
            deleteDevice(entry.getKey(), entry.getValue());
        }
    }

    public Integer value() {
        int value = 0;

        for (Map.Entry<String,Integer> entry : devicesInCart.entrySet()) {
            if (!deviceDB.isExistingDevice(entry.getKey())) {
                LOGGER.log(Level.INFO,"idbeforeexeption: "+entry.getKey());
                throw new NotExistingDeviceException();
            }
            value =value + deviceDB.getDevice(entry.getKey()).getPrice() * devicesInCart.get(entry.getKey());
        }
        return value;
    }

    public void buy() {
        LOGGER.log(Level.INFO,"Bought devices:");
        logAllDevices();
        LOGGER.log(Level.INFO,"Value of bought devices:"+value().toString());        
    }

    public void logAllDevices() {
        for (Map.Entry<String,Integer> entry : devicesInCart.entrySet()) {
            if (deviceDB.isExistingDevice(entry.getKey())) {
                LOGGER.log(Level.INFO, "ID: " + entry.getKey());
                LOGGER.log(Level.INFO, " manufacturer: " + deviceDB.getDevice(entry.getKey()).getManufacturer().toString());
                LOGGER.log(Level.INFO, " color: " + deviceDB.getDevice(entry.getKey()).getColor().toString());
                LOGGER.log(Level.INFO, " price: " + deviceDB.getDevice(entry.getKey()).getPrice().toString());
                LOGGER.log(Level.INFO, " count: " + devicesInCart.get(entry.getKey()).toString());
            }else{
                LOGGER.log(Level.INFO, "ID: " + entry.getKey());
                LOGGER.log(Level.INFO, " count: " + devicesInCart.get(entry.getKey()).toString());
            }
        }

    }
}

