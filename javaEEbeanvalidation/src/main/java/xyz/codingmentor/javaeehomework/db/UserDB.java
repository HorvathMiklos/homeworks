package xyz.codingmentor.javaeehomework.db;

import xyz.codingmentor.javaeehomework.exceptions.NotExistingUserException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import xyz.codingmentor.javaeehomework.beans.UserEntity;

/**
 *
 * @author mhorvath
 */
public class UserDB {

    List<UserEntity> userList;
    Calendar currentTime;

    UserDB() {
        userList = new ArrayList();

    }

    public UserEntity addUser(UserEntity newUser) {
        userList.add(newUser);
        return userList.get(userList.size() - 1);
    }

    public UserEntity getUser(String username) {
        for (UserEntity user : userList) {
            if (user.getUsername() == username) {
                return user;
            }
        }
        throw new NotExistingUserException();
    }

    public boolean authenticate(String username, String pasword) {
        for (UserEntity user : userList) {
            if (user.getUsername() == username && user.getPassword() == pasword) {
                return true;
            }
        }
        return false;
    }

    public UserEntity modifyUser(UserEntity userToModify) {
        Calendar now = Calendar.getInstance();
        for (UserEntity user : userList) {
            if (userToModify.equals(user)) {
                user.setUsername(userToModify.getUsername());
                user.setPassword(userToModify.getPassword());
                user.setAddress(userToModify.getAddress());
                user.setFirstname(userToModify.getFirstname());
                user.setFirstname(userToModify.getLastname());
                user.setPhone(userToModify.getPhone());
                user.setSex(userToModify.getSex());
                user.setRegistrationDate(userToModify.getRegistrationDate());
                user.setDateOfBirth(userToModify.getDateOfBirth());
                user.setLastModifiedDate(now.getTime());
                return user;
            }
        }
        throw new NotExistingUserException();
    }

    public UserEntity deleteUser(UserEntity userToDelete) {
        for (UserEntity user : userList) {
            if (userToDelete.equals(user)) {
                userList.remove(user);
                return user;
            }
        }
        throw new NotExistingUserException();
    }

    List<UserEntity> getAllUser() {
        return this.userList;
    }

}
