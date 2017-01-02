package xyz.codingmentor.javaeehomework.db;

import xyz.codingmentor.javaeehomework.exceptions.NotExistingUserException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import xyz.codingmentor.javaeehomework.beans.UserEntity;
import xyz.codingmentor.javaeehomework.exceptions.UserAllreadyInUserListException;

/**
 *
 * @author mhorvath
 */
public class UserDB {

    Map userList;
    Calendar currentTime;

    UserDB() {
        userList = new HashMap();

    }
    private static void checkUserExistence(String username,Map userList){
        if(!userList.containsKey(username)){
            throw new NotExistingUserException();
        }
    }
    public UserEntity addUser(UserEntity newUser) {
        if(userList.containsKey(newUser.getUsername())){
            throw new UserAllreadyInUserListException();
        }
        userList.put(newUser.getUsername(), newUser);
        return (UserEntity) userList.get(newUser.getUsername());             
    }

    public UserEntity getUser(String username) {
        checkUserExistence(username, userList);
        return (UserEntity) userList.get(username);
        
    }

    public boolean authenticate(String username, String password) {
        UserEntity userToAuthenticate;
        if(null==userList.get(username)){
            return false;
        }
        userToAuthenticate=(UserEntity)userList.get(username);
        return userToAuthenticate.getPassword() == null ? false : userToAuthenticate.getPassword().equals(password);
        
    }

    public UserEntity modifyUser(UserEntity userToModify) {
        Calendar now = Calendar.getInstance();
        checkUserExistence(userToModify.getUsername(), userList);
        userToModify.setLastModifiedDate(now.getTime());
        userList.put(userToModify.getUsername(),userToModify );
        return (UserEntity) userList.get(userToModify.getUsername());        
    }

    public UserEntity deleteUser(UserEntity userToDelete) {
        UserEntity deletedUser;
        checkUserExistence(userToDelete.getUsername(), userList);
        deletedUser=(UserEntity) userList.get(userToDelete.getUsername());
        userList.remove(userToDelete.getUsername());
        return deletedUser;
       
    }

    Map getAllUser() {
        return this.userList;
    }

}
