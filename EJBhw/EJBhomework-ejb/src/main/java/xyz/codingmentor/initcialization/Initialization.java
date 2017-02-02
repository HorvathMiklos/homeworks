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
        userDB = reader.jsonToUserDB();
        deviceDB = reader.jsonToDeviceDB();
        LOGGER.log(Level.INFO, userDB.toString());
        for (UserEntity userEntity : userDB.getAllUser()) {
            LOGGER.log(Level.INFO, userEntity.toString());
        }
        LOGGER.log(Level.INFO, deviceDB.toString());
        for (Device device : deviceDB.getAllDevices()) {
            LOGGER.log(Level.INFO, device.toString());
        }
    }
}
