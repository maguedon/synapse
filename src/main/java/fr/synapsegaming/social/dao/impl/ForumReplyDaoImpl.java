package fr.synapsegaming.social.dao.impl;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.social.dao.ForumReplyDao;
import fr.synapsegaming.social.entity.ForumReply;
import fr.synapsegaming.user.dao.impl.UserDaoImpl;
import fr.synapsegaming.user.entity.User;

@Repository("ForumReplyDao")
public class ForumReplyDaoImpl extends AbstractDao<ForumReply, Long> implements
        ForumReplyDao {
    /**
     * The logger
     */
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    
	/**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<User> listRepliesForUser(long idUser) {
        Session session = this.getSession();
        try {
            Query query = session
                    .createQuery("from ForumReply fr join fetch fr.author a where a.id = :idUser");
            query.setParameter("idUser", idUser);
            return query.list();
        } catch (Exception e) {
            LOGGER.warn(e);
            return Collections.emptyList();
        } finally {
            session.close();
        }
    }

}
