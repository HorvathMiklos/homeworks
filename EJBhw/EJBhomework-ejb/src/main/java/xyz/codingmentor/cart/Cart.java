package xyz.codingmentor.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.db.DeviceDB;
import xyz.codingmentor.exceptions.EntityException;
import xyz.codingmentor.exceptions.NotEnoughDeviceExeption;
import xyz.codingmentor.exceptions.NotExistingDeviceException;

/**
 *
 * @author mhorvath
 */
@SessionScoped
@Stateful
@StatefulTimeout(value = 2000, unit = TimeUnit.SECONDS)
public class Cart implements Serializable {

    private Integer value;
    private Map<String, Integer> devicesInCart;

    @Inject
    private DeviceDB deviceDB;
    private static final Logger LOGGER = Logger.getLogger(Cart.class.getSimpleName());

    @PostConstruct
    private void init() {
        value = 0;
        devicesInCart = new HashMap<>();
    }

    public void addDevice(String id, int count) throws EntityException{
        if (!deviceDB.isExisting(id)) {
            throw new NotExistingDeviceException(id);
        }
        Device device = deviceDB.getDevice(id);
        if (device.getCount() > count) {
            throw new NotEnoughDeviceExeption(id);
        }
        if (devicesInCart.containsKey(id)) {
            devicesInCart.put(id, devicesInCart.get(id) + count);
            value = value + count * device.getPrice();
        } else {
            devicesInCart.put(id, count);
            value = value + count * device.getPrice();
        }
        device.setCount(device.getCount() - count);

    }

    private void modifyCountsToDelete(String id, int count) throws EntityException{
        devicesInCart.put(id, devicesInCart.get(id) - count);
        Device deviceUsedForEdit = deviceDB.getDevice(id);
        deviceUsedForEdit.setCount(deviceUsedForEdit.getCount() + count);
    }

    private void modifyValueToDelete(String id, int count) throws EntityException{
        value = value - count * deviceDB.getDevice(id).getPrice();
    }

    public void deleteDevice(String id, int count) throws EntityException{
        if (!devicesInCart.containsKey(id)) {
            throw new NotExistingDeviceException(id);
        }
        if (devicesInCart.get(id) < count) {
            throw new NotEnoughDeviceExeption(id);
        }
        modifyCountsToDelete(id, count);
        modifyValueToDelete(id, count);
    }

    public void delete() throws EntityException{
        for (Map.Entry<String, Integer> entry : devicesInCart.entrySet()) {
            modifyCountsToDelete(entry.getKey(), entry.getValue());
            modifyValueToDelete(entry.getKey(), entry.getValue());
        }
    }

    public Integer value() {
        return value;
    }

    public void buy() throws EntityException{
        LOGGER.log(Level.INFO, "Bought devices:");
        logAllDevices();
        LOGGER.log(Level.INFO, "Value of bought devices:" + value.toString());
    }

    public void logAllDevices() throws EntityException{
        for (Map.Entry<String, Integer> entry : devicesInCart.entrySet()) {
            LOGGER.log(Level.INFO, deviceDB.getDevice(entry.getKey()).toString());
            LOGGER.log(Level.INFO, devicesInCart.get(entry.getKey()).toString() + " count in cart: ");
        }
    }
}
