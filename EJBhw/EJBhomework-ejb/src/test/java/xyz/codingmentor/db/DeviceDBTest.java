
package xyz.codingmentor.db;


import java.util.UUID;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import xyz.codingmentor.beans.Color;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.beans.Manufacturer;
import xyz.codingmentor.exceptions.EntityException;
import xyz.codingmentor.exceptions.NotExistingDeviceException;


public class DeviceDBTest {

    private static ValidatorFactory vf;
    private static Validator validator;
    private Device newDeviceOne;
    private Device DeviceOneEdited;
    private Device newDeviceTwo;
    private DeviceDB deviceDB;

    public DeviceDBTest() {

    }

    @Before
    public void setUp() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
        deviceDB = new DeviceDB();

        newDeviceOne = new Device();
        newDeviceOne.setManufacturer(Manufacturer.HTC);
        newDeviceOne.setType("phone");
        newDeviceOne.setPrice(1000);
        newDeviceOne.setColor(Color.BLUE);
        newDeviceOne.setCount(50);

        DeviceOneEdited = new Device();
        DeviceOneEdited.setManufacturer(Manufacturer.HTC);
        DeviceOneEdited.setType("phone");
        DeviceOneEdited.setPrice(1000);
        DeviceOneEdited.setColor(Color.BLUE);
        DeviceOneEdited.setCount(40);

        newDeviceTwo = new Device();
        newDeviceTwo.setManufacturer(Manufacturer.ONEPLUS);
        newDeviceTwo.setType("phone");
        newDeviceTwo.setPrice(1500);
        newDeviceTwo.setColor(Color.RED);
        newDeviceTwo.setCount(1000);
    }

    @Test
    public void testAddDevice() throws EntityException{
        deviceDB.addDevice(newDeviceOne);
        assertEquals(true, deviceDB.getAllDevices().contains(newDeviceOne));
    }

    @Test
    public void editDeviceReturnsSameDeviceAsInput() throws EntityException{
        deviceDB.addDevice(newDeviceOne);
        newDeviceOne.setCount(314592);
        assertEquals(newDeviceOne, deviceDB.editDevice(newDeviceOne));

    }

    @Test(expected = NotExistingDeviceException.class)
    public void testEditDeviceThrowsNotExistingDeviceException() throws EntityException{
        deviceDB.editDevice(DeviceOneEdited);
    }

    @Test(expected = NotExistingDeviceException.class)
    public void testGetDeviceThrowsNotExistingDeviceException() throws EntityException{
        deviceDB.getDevice("NotExistingId");
    }

    @Test
    public void testDeleteDevice() throws EntityException{
        deviceDB.addDevice(newDeviceOne);
        deviceDB.addDevice(newDeviceTwo);
        deviceDB.deleteDevice(newDeviceTwo);
        assertEquals(true, deviceDB.getAllDevices().contains(newDeviceOne));
        assertEquals(false, deviceDB.getAllDevices().contains(newDeviceTwo));

    }

    @Test(expected = NotExistingDeviceException.class)
    public void testDeleteDeviceThrowsNotExistingDeviceException() throws EntityException{
        deviceDB.deleteDevice(newDeviceTwo);
    }

}
