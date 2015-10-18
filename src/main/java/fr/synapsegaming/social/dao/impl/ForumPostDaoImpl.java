package fr.synapsegaming.social.dao.impl;

import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.social.dao.ForumPostDao;
import fr.synapsegaming.social.entity.ForumPost;

@Repository("ForumPostDao")
public class ForumPostDaoImpl extends AbstractDao<ForumPost, Long> implements
        ForumPostDao {

}
