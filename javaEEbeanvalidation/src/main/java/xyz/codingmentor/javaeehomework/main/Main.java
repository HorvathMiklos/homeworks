
package xyz.codingmentor.javaeehomework.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.javaeehomework.beans.Color;
import xyz.codingmentor.javaeehomework.beans.Device;
import xyz.codingmentor.javaeehomework.beans.Manufacturer;
import xyz.codingmentor.javaeehomework.beans.Sex;
import xyz.codingmentor.javaeehomework.beans.UserEntity;
import xyz.codingmentor.javaeehomework.db.DeviceDB;
import xyz.codingmentor.javaeehomework.db.UserDB;
import xyz.codingmentor.javaeehomework.json.JSONreader;
import xyz.codingmentor.javaeehomework.json.JSONwriter;

/**
 *
 * @author mhorvath
 */
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.javaeehomework.cart.Cart;
import xyz.codingmentor.javaeehomework.exceptions.InvalidBeanExeption;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String DEVICE_TYPE = "phone";

    private Main() {
        //hide public main, empty on purpuse
    }

    public static void main(String[] args) {
        jsonTest();
        interceptorTest();
        cartTest();
    }

    private static void jsonTest() {
        UserDB userDB;
        DeviceDB deviceDB;

        String usersPath = "users.json";
        String devicesPath = "devices.json";

        JSONwriter writer = new JSONwriter();
        JSONreader reader = new JSONreader();
        writer.listToJson(newDeviceList(), devicesPath);
        writer.listToJson(newUserList(), usersPath);
        userDB = reader.jsonToUserDB(usersPath);
        deviceDB = reader.jsonToDeviceDB(devicesPath);
        LOGGER.log(Level.INFO, userDB.toString());
        for (UserEntity userEntity : userDB.getAllUser()) {
            LOGGER.log(Level.INFO, userEntity.toString());
        }
        LOGGER.log(Level.INFO, deviceDB.toString());
        for (Device device : deviceDB.getAllDevices()) {
            LOGGER.log(Level.INFO, device.toString());
        }

    }
    
    private static void interceptorTest() {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        UserDB userDBvalidationtest = container.instance().select(UserDB.class).get();
        DeviceDB deviceDBvalidationtest = container.instance().select(DeviceDB.class).get();
        UserEntity invalidUser;
        Device invalidDevice;
        invalidUser = new UserEntity("inv", "weakpassword", "invalidmail");
        invalidUser.setFirstname("Firstname");
        invalidUser.setLastname("Lastname");
        invalidUser.setAddress("1123 Java street 58");
        invalidUser.setPhone("afwegf");
        invalidUser.setSex(Sex.MALE);
        invalidUser.setDateOfBirth(null);
        invalidUser.setAdmin(true);

        invalidDevice = new Device();
        invalidDevice.setId(UUID.randomUUID().toString());
        invalidDevice.setManufacturer(Manufacturer.HTC);
        invalidDevice.setType(DEVICE_TYPE);
        invalidDevice.setPrice(-36736);
        invalidDevice.setColor(Color.BLUE);
        invalidDevice.setCount(-478);

        userDBvalidationtest.addUser(invalidUser);
        deviceDBvalidationtest.addDevice(invalidDevice);
        try {
            userDBvalidationtest.modifyUser(invalidUser);
        } catch (InvalidBeanExeption e) {
            LOGGER.log(Level.INFO, "modifyUser has invalid bean parameter", e);
        }
        try {
            userDBvalidationtest.deleteUser(invalidUser);
        } catch (InvalidBeanExeption e) {
            LOGGER.log(Level.INFO, "deleteUser has invalid bean parameter", e);
        }
        try {
            deviceDBvalidationtest.editDevice(invalidDevice);
        } catch (InvalidBeanExeption e) {
            LOGGER.log(Level.INFO, "editDevice has invalid bean parameter", e);
        }
        try {
            deviceDBvalidationtest.deleteDevice(invalidDevice);
        } catch (InvalidBeanExeption e) {
            LOGGER.log(Level.INFO, "deleteDevice has invalid bean parameter", e);
        }
    }

    private static void cartTest() {
        DeviceDB deviceDBCartTest = new DeviceDB();
        Cart testCart = new Cart(deviceDBCartTest);
        Device blueHTC;
        Device blueHTCten;
        Device whiteIphone;
        String blueHTCiD = UUID.randomUUID().toString();
        String whiteIphoneiD = UUID.randomUUID().toString();
        blueHTC = new Device();
        blueHTC.setId(blueHTCiD);
        blueHTC.setManufacturer(Manufacturer.HTC);
        blueHTC.setType(DEVICE_TYPE);
        blueHTC.setPrice(1000);
        blueHTC.setColor(Color.BLUE);
        blueHTC.setCount(50);
        deviceDBCartTest.addDevice(blueHTC);

        blueHTCten = new Device();
        blueHTCten.setId(blueHTCiD);
        blueHTCten.setManufacturer(Manufacturer.HTC);
        blueHTCten.setType(DEVICE_TYPE);
        blueHTCten.setPrice(1000);
        blueHTCten.setColor(Color.BLUE);
        blueHTCten.setCount(10);

        whiteIphone = new Device();
        whiteIphone.setId(whiteIphoneiD);
        whiteIphone.setManufacturer(Manufacturer.APPLE);
        whiteIphone.setType(DEVICE_TYPE);
        whiteIphone.setPrice(9000);
        whiteIphone.setColor(Color.WHITE);
        whiteIphone.setCount(50);
        deviceDBCartTest.addDevice(whiteIphone);
        log(deviceDBCartTest, testCart);
        testCart.addDevice(blueHTC.getId(), 50);
        testCart.addDevice(whiteIphone.getId(), 50);
        LOGGER.log(Level.INFO, "after 50 both phone added to cart:");
        log(deviceDBCartTest, testCart);
        testCart.deleteDevice(blueHTC.getId(), 10);
        LOGGER.log(Level.INFO, "after 10 blueHTC deleted:");
        log(deviceDBCartTest, testCart);
        testCart.addDevice(blueHTC.getId(), 10);
        LOGGER.log(Level.INFO, "after 10 blueHTC added again:");
        log(deviceDBCartTest, testCart);
        testCart.delete();
        LOGGER.log(Level.INFO, "after delete");
        log(deviceDBCartTest, testCart);
        testCart.addDevice(blueHTC.getId(), 50);
        testCart.addDevice(whiteIphone.getId(), 50);
        LOGGER.log(Level.INFO, "after 50 both phone added to cart again:");
        log(deviceDBCartTest, testCart);
        LOGGER.log(Level.INFO, "buy!");
        testCart.buy();
    }

    private static void log(DeviceDB deviceDBCartTest, Cart testCart) {
        LOGGER.log(Level.INFO, ".........................................................................");
        LOGGER.log(Level.INFO, "deviceDBCartTest tartalma");
        for (Device device : deviceDBCartTest.getAllDevices()) {
            LOGGER.log(Level.INFO, device.toString());
        }
        LOGGER.log(Level.INFO, "testCart tartalma");
        testCart.logAllDevices();
        LOGGER.log(Level.INFO, ".........................................................................");
    }

    public static List<Device> newDeviceList() {
        List<Device> deviceList = new ArrayList<>();
        Device newDevice;
        for (int i = 0; i < 10; i++) {
            newDevice = new Device();
            newDevice.setId(UUID.randomUUID().toString());
            newDevice.setManufacturer(Manufacturer.HTC);
            newDevice.setType("phone");
            newDevice.setPrice(1000 + i * 20);
            newDevice.setColor(Color.BLUE);
            newDevice.setCount(50 + i);
            deviceList.add(newDevice);
        }
        return deviceList;
    }

    public static List<UserEntity> newUserList() {
        List<UserEntity> userList = new ArrayList<>();
        UserEntity newUser;
        Calendar longbeforeNow = Calendar.getInstance();
        longbeforeNow.add(Calendar.DAY_OF_YEAR, -365);
        for (int i = 0; i < 10; i++) {
            newUser = new UserEntity("Firstname Lastname".substring(i), "Admin112", String.valueOf(i) + "verycleveremailadress@companymail.com");
            newUser.setFirstname("Firstname");
            newUser.setLastname("Lastname");
            newUser.setAddress("1123 Java street 58");
            newUser.setPhone("06112358132");
            newUser.setSex(Sex.MALE);
            newUser.setDateOfBirth(longbeforeNow.getTime());
            newUser.setAdmin(i % 2 == 0);
            userList.add(newUser);
        }
        return userList;
    }
}
