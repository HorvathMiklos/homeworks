
package xyz.codingmentor.javaeehomework.main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import xyz.codingmentor.javaeehomework.beans.Color;
import xyz.codingmentor.javaeehomework.beans.Device;
import xyz.codingmentor.javaeehomework.beans.Manufacturer;
import xyz.codingmentor.javaeehomework.beans.Sex;
import xyz.codingmentor.javaeehomework.beans.UserEntity;
import xyz.codingmentor.javaeehomework.json.JSONwriter;

/**
 *
 * @author mhorvath
 */
public class main {
    
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
        Calendar beforeNow = Calendar.getInstance();
        beforeNow.add(Calendar.DAY_OF_YEAR, -165);
        Calendar longbeforeNow = Calendar.getInstance();
        longbeforeNow.add(Calendar.DAY_OF_YEAR, -365);
        for (int i = 0; i < 10; i++) {
            newUser= new UserEntity("Firstname Lastname", "Admin112", String.valueOf(i)+"verycleveremailadress@companymail.com");
            newUser.setFirstname("Firstname");
            newUser.setLastname("Lastname");
            newUser.setAddress("1123 Java street 58");
            newUser.setPhone("06112358132");
            newUser.setSex(Sex.MALE);
            newUser.setRegistrationDate(beforeNow.getTime());
            newUser.setLastModifiedDate(beforeNow.getTime());
            newUser.setDateOfBirth(longbeforeNow.getTime());
            newUser.setAdmin(i%2==0);
            userList.add(newUser);
        }
        return userList;
    }  
           
    public static void main(String[] args) {
        String usersPath="c:\\jsonfiles/users.json";
        String devicesPath="c:\\jsonfiles/devices.json";
        JSONwriter userWriter = new JSONwriter(usersPath);
        JSONwriter deviceWriter = new JSONwriter(devicesPath);
        userWriter.userEntityListToJson(newUserList());
        deviceWriter.deviceListToJson(newDeviceList());        
    }     
}
