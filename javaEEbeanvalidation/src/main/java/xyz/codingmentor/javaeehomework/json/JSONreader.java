
package xyz.codingmentor.javaeehomework.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import xyz.codingmentor.javaeehomework.beans.Device;
import xyz.codingmentor.javaeehomework.beans.UserEntity;
import xyz.codingmentor.javaeehomework.db.DeviceDB;
import xyz.codingmentor.javaeehomework.db.UserDB;

/**
 *
 * @author mhorvath
 */
public class JSONreader {
   
    private final ObjectMapper mapper;

    public JSONreader() {
        
        mapper=new ObjectMapper();
    }
    private List<UserEntity> jsonToUserEntityList(String path) throws IOException{
        return mapper.readValue(new File(path), new TypeReference<List<UserEntity>>(){});
    }
    private List<Device> jsonToDeviceList(String path) throws IOException{
        return mapper.readValue(new File(path), new TypeReference<List<Device>>(){});
    }
    public UserDB jsonToUserDB(String path){
        Calendar calendar = Calendar.getInstance();
        UserDB userDBtoReturn = new UserDB();
        List<UserEntity> userEntitys = new ArrayList<>();
        try {
            userEntitys=this.jsonToUserEntityList(path);
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
    public DeviceDB jsonToDeviceDB(String path){
        DeviceDB deviceDBtoReturn = new DeviceDB();
        List<Device> devices = new ArrayList<>();
        try {
            devices=this.jsonToDeviceList(path);
        } catch (IOException ex) {
            Logger.getLogger(JSONreader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Device device : devices) {
            deviceDBtoReturn.addDevice(device);
        }
        return deviceDBtoReturn;
    }

}
