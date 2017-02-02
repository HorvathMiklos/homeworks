package xyz.codingmentor.db;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.exceptions.EntityException;
import xyz.codingmentor.exceptions.NotExistingUserException;
import xyz.codingmentor.exceptions.UserAlreadyInUserListException;
import xyz.codingmentor.interceptor.ValidationInterceptor;

/**
 *
 * @author mhorvath
 */
@Singleton
@Interceptors(ValidationInterceptor.class)
public class UserDB {

    private Map<String, UserEntity> userMap = new HashMap<>();

    private void checkUserExistence(String username) throws EntityException {
        if (!userMap.containsKey(username)) {
            throw new NotExistingUserException(username);
        }
    }

    @ExcludeClassInterceptors
    public UserEntity addUser(UserEntity newUser) throws EntityException {
        if (userMap.containsKey(newUser.getUsername())) {
            throw new UserAlreadyInUserListException();
        }
        userMap.put(newUser.getUsername(), newUser);
        return userMap.get(newUser.getUsername());
    }

    public UserEntity getUser(String username) throws EntityException {
        checkUserExistence(username);
        return userMap.get(username);

    }

    public boolean authenticate(String username, String password) {
        UserEntity userToAuthenticate;
        if (null == userMap.get(username)) {
            return false;
        }
        userToAuthenticate = userMap.get(username);
        return userToAuthenticate.getPassword() == null ? false : userToAuthenticate.getPassword().equals(password);

    }

    public UserEntity modifyUser(UserEntity userToModify) throws EntityException {
        Calendar now = Calendar.getInstance();
        checkUserExistence(userToModify.getUsername());
        userToModify.setLastModifiedDate(now.getTime());
        userMap.put(userToModify.getUsername(), userToModify);
        return userMap.get(userToModify.getUsername());
    }

    public UserEntity deleteUser(UserEntity userToDelete) throws EntityException {
        UserEntity deletedUser;
        checkUserExistence(userToDelete.getUsername());
        deletedUser = userMap.get(userToDelete.getUsername());
        userMap.remove(userToDelete.getUsername());
        return deletedUser;

    }

    @ExcludeClassInterceptors
    public List<UserEntity> getAllUser() {
        return new ArrayList<>(userMap.values());
    }

}
