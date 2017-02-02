package xyz.codingmentor.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.db.DeviceDB;
import xyz.codingmentor.db.UserDB;

/**
 *
 * @author mhorvath
 */
public class JSONreader {

    private final ObjectMapper mapper;
    private final File deviceDBFile;
    private final File userDBFile;

    public JSONreader(String deviceDbPath, String userDbPath) {
        ClassLoader classLoader = getClass().getClassLoader();
        deviceDBFile = new File(classLoader.getResource(deviceDbPath).getFile());
        userDBFile = new File(classLoader.getResource(userDbPath).getFile());
        mapper = new ObjectMapper();
    }

    private List<UserEntity> jsonToUserEntityList() throws IOException {
        return mapper.readValue(userDBFile, new TypeReference<List<UserEntity>>() {
        });
    }

    private List<Device> jsonToDeviceList() throws IOException {
        return mapper.readValue(deviceDBFile, new TypeReference<List<Device>>() {
        });
    }

    public UserDB jsonToUserDB(UserDB userDB) {
        Calendar calendar = Calendar.getInstance();
        userDB = new UserDB();
        List<UserEntity> userEntitys = new ArrayList<>();
        try {
            userEntitys = this.jsonToUserEntityList();
        } catch (IOException ex) {
            Logger.getLogger(JSONreader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (UserEntity userEntity : userEntitys) {
            userEntity.setRegistrationDate(calendar.getTime());
            userEntity.setLastModifiedDate(calendar.getTime());
            userDB.addUser(userEntity);
        }
        return userDB;
    }

    public DeviceDB jsonToDeviceDB(DeviceDB deviceDB) {
        deviceDB = new DeviceDB();
        List<Device> devices = new ArrayList<>();
        try {
            devices = this.jsonToDeviceList();
        } catch (IOException ex) {
            Logger.getLogger(JSONreader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Device device : devices) {
            deviceDB.addDevice(device);
        }
        return deviceDB;
    }

}
