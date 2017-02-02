
package xyz.codingmentor.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.exceptions.DeviceAllreadyInDeviceListException;
import xyz.codingmentor.exceptions.NotExistingDeviceException;
import xyz.codingmentor.interceptor.ValidationInterceptor;

/**
 *
 * @author mhorvath
 */
@Singleton
@Interceptors(ValidationInterceptor.class)
public class DeviceDB {

    private Map<String,Device> deviceMap = new HashMap<>();;
        
    private void checkDeviceExistence(String deviceID){
        if(!deviceMap.containsKey(deviceID)){
            throw new NotExistingDeviceException(deviceID);
        }
    }
    @ExcludeClassInterceptors
    public Device addDevice(Device newDevice) {
        if(deviceMap.containsKey(newDevice.getId())){
            throw new DeviceAllreadyInDeviceListException();
        }
        deviceMap.put(newDevice.getId(), newDevice);
        return deviceMap.get(newDevice.getId());
    }
    
    public Device editDevice(Device deviceToEdit) {
        checkDeviceExistence(deviceToEdit.getId());
        deviceMap.put(deviceToEdit.getId(), deviceToEdit);
        return deviceMap.get(deviceToEdit.getId());                      
    }
    
    public Device getDevice(String id) {
        checkDeviceExistence(id);
        return deviceMap.get(id);        
    }
    
    public boolean isExisting(String id){
        return deviceMap.containsKey(id);           
    }
    
    public Device deleteDevice(Device deviceToDelete) {
        Device deletedDevice;
        checkDeviceExistence(deviceToDelete.getId());
        deletedDevice=getDevice(deviceToDelete.getId());
        deviceMap.remove(deviceToDelete.getId());
        return deletedDevice;
    }

    public List<Device> getAllDevices() {
        return new ArrayList<>(deviceMap.values());
    }
}

