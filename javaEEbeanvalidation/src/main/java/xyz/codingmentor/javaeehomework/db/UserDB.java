package xyz.codingmentor.javaeehomework.db;

import java.util.ArrayList;
import xyz.codingmentor.javaeehomework.exceptions.NotExistingUserException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.codingmentor.javaeehomework.beans.UserEntity;
import xyz.codingmentor.javaeehomework.exceptions.UserAlreadyInUserListException;

/**
 *
 * @author mhorvath
 */
public class UserDB {
    private Map<String,UserEntity> userMap;
    public UserDB() {
        userMap = new HashMap<>();
    }
    private void checkUserExistence(String username){
        if(!userMap.containsKey(username)){
            throw new NotExistingUserException(username);
        }
    }
    public UserEntity addUser(UserEntity newUser) {
        if(userMap.containsKey(newUser.getUsername())){
            throw new UserAlreadyInUserListException();
        }
        userMap.put(newUser.getUsername(), newUser);
        return userMap.get(newUser.getUsername());             
    }

    public UserEntity getUser(String username) {
        checkUserExistence(username);
        return userMap.get(username);
        
    }

    public boolean authenticate(String username, String password) {
        UserEntity userToAuthenticate;
        if(null==userMap.get(username)){
            return false;
        }
        userToAuthenticate=userMap.get(username);
        return userToAuthenticate.getPassword() == null ? false : userToAuthenticate.getPassword().equals(password);
        
    }

    public UserEntity modifyUser(UserEntity userToModify) {
        Calendar now = Calendar.getInstance();
        checkUserExistence(userToModify.getUsername());
        userToModify.setLastModifiedDate(now.getTime());
        userMap.put(userToModify.getUsername(),userToModify );
        return userMap.get(userToModify.getUsername());        
    }

    public UserEntity deleteUser(UserEntity userToDelete) {
        UserEntity deletedUser;
        checkUserExistence(userToDelete.getUsername());
        deletedUser= userMap.get(userToDelete.getUsername());
        userMap.remove(userToDelete.getUsername());
        return deletedUser;
       
    }

    public List<UserEntity> getAllUser() {
        return new ArrayList<>(userMap.values());
    }

}
