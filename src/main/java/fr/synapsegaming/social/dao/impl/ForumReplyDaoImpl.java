package fr.synapsegaming.social.dao.impl;

import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.social.dao.ForumReplyDao;
import fr.synapsegaming.social.entity.ForumReply;

@Repository("ForumReplyDao")
public class ForumReplyDaoImpl extends AbstractDao<ForumReply, Long> implements
        ForumReplyDao {

}
