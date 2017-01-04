
package xyz.codingmentor.javaeehomework.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.javaeehomework.beans.Device;
import xyz.codingmentor.javaeehomework.beans.UserEntity;

/**
 *
 * @author mhorvath
 */
public class JSONwriter {
    private String path;
    private final ObjectMapper mapper;
    public JSONwriter(String path) {
        this.path = path;
        mapper=new ObjectMapper();
    }
    
    public void userEntityListToJson(List<UserEntity> userEntitys){
        try {
            mapper.writeValue(new File(path), userEntitys);
        } catch (IOException ex) {
            Logger.getLogger(JSONwriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deviceListToJson(List<Device> devices){
        try {
            mapper.writeValue(new File(path), devices);
        } catch (IOException ex) {
            Logger.getLogger(JSONwriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
