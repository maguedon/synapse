package fr.synapsegaming.user.dao.impl;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.user.dao.UserDao;
import fr.synapsegaming.user.entity.User;

@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

    /**
     * The logger
     */
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public User findByMail(String mail) {
        return (User) DataAccessUtils.uniqueResult(getHibernateTemplate().find("from User u where u.mail = ?", mail));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<User> listByGroups(List<Integer> groups) {
        Session session = this.getSession();
        try {
            Query query = session.createQuery("from User u join fetch u.group g where g.id in (:groupIds)");
            query.setParameterList("groupIds", groups);
            return query.list();
        } catch (Exception e) {
            LOGGER.warn(e);
            return Collections.emptyList();
        } finally {
            session.close();
        }
    }

}
