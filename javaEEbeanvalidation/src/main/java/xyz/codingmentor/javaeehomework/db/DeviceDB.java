package xyz.codingmentor.javaeehomework.db;

import xyz.codingmentor.javaeehomework.exceptions.NotExistingDeviceException;
import java.util.ArrayList;
import java.util.List;
import xyz.codingmentor.javaeehomework.beans.Device;

/**
 *
 * @author mhorvath
 */
public class DeviceDB {

    private List<Device> deviceList = new ArrayList();

    Device addDevice(Device newDevice) {
        deviceList.add(newDevice);
        return deviceList.get(deviceList.size() - 1);
    }

    Device editDevice(Device deviceToEdit) {
        for (Device device : deviceList) {
            if (deviceToEdit.equals(device)) {
                device.setManufacturer(deviceToEdit.getManufacturer());
                device.setType(deviceToEdit.getType());
                device.setPrice(deviceToEdit.getPrice());
                device.setColor(deviceToEdit.getColor());
                device.setCount(deviceToEdit.getCount());
                return device;
            }
        }
        throw new NotExistingDeviceException();
    }

    Device getDevice(String iD) {
        for (Device device : deviceList) {
            if (device.getId() == iD) {
                return device;
            }
        }
        throw new NotExistingDeviceException();
    }

    Device deleteDevice(Device deviceToDelete) {
        for (Device device : deviceList) {
            if (deviceToDelete.equals(device)) {
                deviceList.remove(deviceToDelete);
                return device;
            }
        }
        throw new NotExistingDeviceException();
    }

    List<Device> getAllDevices() {
        return this.deviceList;
    }
}
