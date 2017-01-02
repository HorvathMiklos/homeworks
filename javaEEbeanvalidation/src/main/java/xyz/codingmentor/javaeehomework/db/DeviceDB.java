package xyz.codingmentor.javaeehomework.db;

import xyz.codingmentor.javaeehomework.exceptions.NotExistingDeviceException;
import java.util.HashMap;
import java.util.Map;
import xyz.codingmentor.javaeehomework.beans.Device;
import xyz.codingmentor.javaeehomework.exceptions.DeviceAllreadyInDeviceListException;

/**
 *
 * @author mhorvath
 */
public class DeviceDB {

    private Map deviceList = new HashMap();
    private static void checkDeviceExistence(String deviceID,Map deviceList){
        if(!deviceList.containsKey(deviceID)){
            throw new NotExistingDeviceException();
        }
    }
    Device addDevice(Device newDevice) {
        if(deviceList.containsKey(newDevice.getId())){
            throw new DeviceAllreadyInDeviceListException();
        }
        deviceList.put(newDevice.getId(), newDevice);
        return (Device) deviceList.get(newDevice.getId());
    }

    Device editDevice(Device deviceToEdit) {
        checkDeviceExistence(deviceToEdit.getId(), deviceList);
        deviceList.put(deviceToEdit.getId(), deviceToEdit);
        return (Device) deviceList.get(deviceToEdit.getId());                      
    }

    Device getDevice(String iD) {
        checkDeviceExistence(iD, deviceList);
        return (Device) deviceList.get(iD);        
    }

    Device deleteDevice(Device deviceToDelete) {
        Device deletedDevice;
        checkDeviceExistence(deviceToDelete.getId(), deviceList);
        deletedDevice=getDevice(deviceToDelete.getId());
        deviceList.remove(deviceToDelete.getId());
        return deletedDevice;
    }

    Map getAllDevices() {
        return this.deviceList;
    }
}
