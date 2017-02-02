package xyz.codingmentor.initcialization;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.db.DeviceDB;
import xyz.codingmentor.db.UserDB;
import xyz.codingmentor.exceptions.EntityException;
import xyz.codingmentor.json.JSONreader;

/**
 *
 * @author mhorvath
 */
@Startup
@Singleton
public class Initialization {

    private static final Logger LOGGER = Logger.getLogger(Initialization.class.getName());

    @Inject
    private UserDB userDB;
    @Inject
    private DeviceDB deviceDB;

    @PostConstruct
    public void dbInit() {
        String usersPath = "users.json";
        String devicesPath = "devices.json";
        JSONreader reader = new JSONreader(devicesPath, usersPath);
        tryAddUser(reader);
        tryAddDevice(reader);
        logAll();
    }

    private void tryAddDevice(JSONreader reader) {
        try {
            reader.jsonToDeviceDB(deviceDB);
        } catch (EntityException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private void tryAddUser(JSONreader reader) {
        try {
            reader.jsonToUserDB(userDB);
        } catch (EntityException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private void logAll() {
        logDevices();
        logUsers();
    }

    private void logUsers() {
        LOGGER.log(Level.INFO, userDB.toString());
        for (UserEntity userEntity : userDB.getAllUser()) {
            LOGGER.log(Level.INFO, userEntity.toString());
        }
    }

    private void logDevices() {
        LOGGER.log(Level.INFO, deviceDB.toString());
        for (Device device : deviceDB.getAllDevices()) {
            LOGGER.log(Level.INFO, device.toString());
        }
    }
}
