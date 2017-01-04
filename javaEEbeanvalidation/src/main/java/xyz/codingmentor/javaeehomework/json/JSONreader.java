
package xyz.codingmentor.javaeehomework.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    private String path;
    private final ObjectMapper mapper;

    public JSONreader(String path) {
        this.path = path;
        mapper=new ObjectMapper();
    }
    private List<UserEntity> jsonToUserEntityList() throws IOException{
        return mapper.readValue(new File(path), new TypeReference<List<UserEntity>>(){});
    }
    private List<Device> jsonToDeviceList() throws IOException{
        return mapper.readValue(new File(path), new TypeReference<List<Device>>(){});
    }
    public UserDB jsonToUserDB(){
        UserDB userDBtoReturn = new UserDB();
        List<UserEntity> userEntitys = new ArrayList<>();
        try {
            userEntitys=this.jsonToUserEntityList();
        } catch (IOException ex) {
            Logger.getLogger(JSONreader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (UserEntity userEntity : userEntitys) {
            userDBtoReturn.addUser(userEntity);
        }
        return userDBtoReturn;
    }
    public DeviceDB jsonToDeviceDB(){
        DeviceDB deviceDBtoReturn = new DeviceDB();
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
