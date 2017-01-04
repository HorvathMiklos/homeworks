
package xyz.codingmentor.javaeehomework.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhorvath
 */
public class JSONwriter {
    
    private final ObjectMapper mapper;
    public JSONwriter() {
        mapper=new ObjectMapper();
    }
    
    public <T> void listToJson(List<T> entities,String path){
        try {
            mapper.writeValue(new File(path), entities);
        } catch (IOException ex) {
            Logger.getLogger(JSONwriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
