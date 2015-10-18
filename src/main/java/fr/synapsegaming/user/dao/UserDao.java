package fr.synapsegaming.user.dao;

import java.util.List;

import fr.synapsegaming.commons.dao.Dao;
import fr.synapsegaming.user.entity.User;

/**
 * <b>UserDao</b> is the public interface who describe the User DAO
 * 
 * @author Meidi
 * 
 */
public interface UserDao extends Dao<User, Long> {

    /**
     * Get a User by mail if it exists
     * 
     * @param mail
     *            : the mail to check if the User exists
     * @return a User if its exists or NULL if it isn't
     */
    public User findByMail(String mail);

    /**
     * Get all the users in the groups parameter
     * 
     * @param groups
     *            : the looked for user's group
     * @return a list of User
     */
    public List<User> listByGroups(List<Integer> groups);

}
