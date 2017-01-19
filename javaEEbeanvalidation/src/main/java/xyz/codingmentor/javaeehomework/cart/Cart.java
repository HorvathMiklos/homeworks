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
    private Integer value;
    private Map<String, Integer> devicesInCart;
    private DeviceDB deviceDB;
    private static final Logger LOGGER = Logger.getLogger("myLogger");

    public Cart(DeviceDB deviceDB) {
        this.deviceDB = deviceDB;
        devicesInCart = new HashMap<>();
        value=0;
    }

    public void addDevice(String id, int count) {
        if (!deviceDB.isExisting(id)) {
            throw new NotExistingDeviceException(id);
        }
        Device device=deviceDB.getDevice(id);
        if (device.getCount() > count) {
            throw new NotEnoughDeviceExeption(id);
        }
        if (devicesInCart.containsKey(id)) {
            devicesInCart.put(id, devicesInCart.get(id) + count);
            value=value+count*device.getPrice();
        } else {
            devicesInCart.put(id, count);
            value=value+count*device.getPrice();
        }
        editDevice.setCount(device.getCount() - count);
        
    }

    private void modifyCountsToDelete(String id, int count) {
        devicesInCart.put(id, devicesInCart.get(id) - count);
        Device editDevice = deviceDB.getDevice(id);
        editDevice.setCount(editDevice.getCount() + count);
    }

    private void modifyValueToDelete(String id, int count) {
        value=value-count*deviceDB.getDevice(id).getPrice();
    }
    public void deleteDevice(String id, int count) {
        if (!devicesInCart.containsKey(id)) {
            throw new NotExistingDeviceException(id);
        }
        if (devicesInCart.get(id) < count) {
            throw new NotEnoughDeviceExeption(id);
        }
        modifyCountsToDelete(id,count);
        modifyValueToDelete(id, count);
    }

    public void delete() {
        for (Map.Entry<String,Integer> entry : devicesInCart.entrySet()) {
             modifyCountsToDelete(entry.getKey(), entry.getValue());
             modifyValueToDelete(entry.getKey(), entry.getValue());
        }
    }

    public Integer value() {
        return value;
    }

    public void buy() {
        LOGGER.log(Level.INFO,"Bought devices:");
        logAllDevices();
        LOGGER.log(Level.INFO,"Value of bought devices:"+value.toString());        
    }

    public void logAllDevices() {
        for (Map.Entry<String,Integer> entry : devicesInCart.entrySet()) {
                LOGGER.log(Level.INFO,deviceDB.getDevice(entry.getKey()).toString());
                LOGGER.log(Level.INFO,devicesInCart.get(entry.getKey()).toString()+" count in cart: ");
        }
    }
}

