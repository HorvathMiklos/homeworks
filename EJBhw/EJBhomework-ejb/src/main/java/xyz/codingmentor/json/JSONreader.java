
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
import javax.inject.Inject;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.db.DeviceDB;
import xyz.codingmentor.db.UserDB;

/**
 *
 * @author mhorvath
 */
public class JSONreader {
    @Inject
    UserDB userDBtoReturn;
    @Inject
    DeviceDB deviceDBtoReturn;
    private final ObjectMapper mapper;
    private File deviceDBFile;
    private File userDBFile;
    public JSONreader(String deviceDbPath,String userDbPath) {
        ClassLoader classLoader = getClass().getClassLoader();
        deviceDBFile=new File(classLoader.getResource(deviceDbPath).getFile());
        userDBFile=new File(classLoader.getResource(userDbPath).getFile());
        mapper=new ObjectMapper();
    }
    private List<UserEntity> jsonToUserEntityList() throws IOException{
        return mapper.readValue(userDBFile, new TypeReference<List<UserEntity>>(){});
    }
    private List<Device> jsonToDeviceList() throws IOException{
        return mapper.readValue(deviceDBFile, new TypeReference<List<Device>>(){});
    }
    public UserDB jsonToUserDB(){
        Calendar calendar = Calendar.getInstance();
        userDBtoReturn=new UserDB();
        List<UserEntity> userEntitys = new ArrayList<>();
        try {
            userEntitys=this.jsonToUserEntityList();
        } catch (IOException ex) {
            Logger.getLogger(JSONreader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (UserEntity userEntity : userEntitys) {
            userEntity.setRegistrationDate(calendar.getTime());
            userEntity.setLastModifiedDate(calendar.getTime());
            userDBtoReturn.addUser(userEntity);
        }
        return userDBtoReturn;
    }
    public DeviceDB jsonToDeviceDB(){
        deviceDBtoReturn=new DeviceDB();
        List<Device> devices = new ArrayList<>();
        try {
            devices=this.jsonToDeviceList();
        } catch (IOException ex) {
            Logger.getLogger(JSONreader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Device device : devices) {
            deviceDBtoReturn.addDevice(device);
        }
        return deviceDBtoReturn;
    }

}
