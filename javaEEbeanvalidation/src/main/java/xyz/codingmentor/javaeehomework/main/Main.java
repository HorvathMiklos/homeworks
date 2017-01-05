
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
public class Main {
    private static final Logger LOGGER = Logger.getLogger("myLogger");
    private Main(){
        //hide public main, empty on purpuse
    }
    public static void main(String[] args) {
        String usersPath="users.json";
        String devicesPath="devices.json";
        UserDB userDB;
        DeviceDB deviceDB;
        JSONwriter writer = new JSONwriter();        
        JSONreader reader = new JSONreader();
        writer.listToJson(newDeviceList(),devicesPath);
        writer.listToJson(newUserList(),usersPath);
        userDB=reader.jsonToUserDB(usersPath);
        deviceDB=reader.jsonToDeviceDB(devicesPath);
        LOGGER.log(Level.INFO, userDB.toString());
        for (UserEntity userEntity : userDB.getAllUser()) {
            LOGGER.log(Level.INFO, userEntity.toString());               
        }
        LOGGER.log(Level.INFO, deviceDB.toString());
        for (Device device : deviceDB.getAllDevices()) {
            LOGGER.log(Level.INFO, device.toString());            
        }
    }
    public static List<Device> newDeviceList(){        
        List<Device> deviceList= new ArrayList<>();        
        Device newDevice;
        for (int i = 0; i < 10; i++) {
            newDevice= new Device();
            newDevice.setId(UUID.randomUUID().toString());        
            newDevice.setManufacturer(Manufacturer.HTC);
            newDevice.setType("phone");
            newDevice.setPrice(1000+i*20);
            newDevice.setColor(Color.BLUE);
            newDevice.setCount(50+i);
            deviceList.add(newDevice);
        }
        return deviceList;
    }
    public static List<UserEntity> newUserList(){
        List<UserEntity> userList=new ArrayList<>();
        UserEntity newUser;        
        Calendar longbeforeNow = Calendar.getInstance();
        longbeforeNow.add(Calendar.DAY_OF_YEAR, -365);
        for (int i = 0; i < 10; i++) {            
            newUser= new UserEntity("Firstname Lastname".substring(i), "Admin112", String.valueOf(i)+"verycleveremailadress@companymail.com");
            newUser.setFirstname("Firstname");
            newUser.setLastname("Lastname");
            newUser.setAddress("1123 Java street 58");
            newUser.setPhone("06112358132");
            newUser.setSex(Sex.MALE);            
            newUser.setDateOfBirth(longbeforeNow.getTime());
            newUser.setAdmin(i%2==0);
            userList.add(newUser);
        }
        return userList;
    } 
}
