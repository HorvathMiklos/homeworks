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
import xyz.codingmentor.beans.DeviceEntity;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.db.DeviceDB;
import xyz.codingmentor.db.UserDB;
import xyz.codingmentor.exceptions.EntityException;

/**
 *
 * @author mhorvath
 */
public class JSONReader {

    private final ObjectMapper mapper;
    private final File deviceDBFile;
    private final File userDBFile;

    public JSONReader(String deviceDbPath, String userDbPath) {
        ClassLoader classLoader = getClass().getClassLoader();
        deviceDBFile = new File(classLoader.getResource(deviceDbPath).getFile());
        userDBFile = new File(classLoader.getResource(userDbPath).getFile());
        mapper = new ObjectMapper();
    }

    private List<UserEntity> jsonToUserEntityList() throws IOException {
        return mapper.readValue(userDBFile, new TypeReference<List<UserEntity>>() {
        });
    }

    private List<DeviceEntity> jsonToDeviceList() throws IOException {
        return mapper.readValue(deviceDBFile, new TypeReference<List<DeviceEntity>>() {
        });
    }

    public UserDB jsonToUserDB(UserDB userDB) throws EntityException {
        Calendar calendar = Calendar.getInstance();
        List<UserEntity> userEntitys = new ArrayList<>();
        try {
            userEntitys = this.jsonToUserEntityList();
        } catch (IOException ex) {
            Logger.getLogger(JSONReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (UserEntity userEntity : userEntitys) {
            userEntity.setRegistrationDate(calendar.getTime());
            userEntity.setLastModifiedDate(calendar.getTime());
            userDB.addUser(userEntity);
        }
        return userDB;
    }

    public DeviceDB jsonToDeviceDB(DeviceDB deviceDB) throws EntityException {
        List<DeviceEntity> devices = new ArrayList<>();
        try {
            devices = this.jsonToDeviceList();
        } catch (IOException ex) {
            Logger.getLogger(JSONReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (DeviceEntity device : devices) {
            deviceDB.addDevice(device);
        }
        return deviceDB;
    }

}
