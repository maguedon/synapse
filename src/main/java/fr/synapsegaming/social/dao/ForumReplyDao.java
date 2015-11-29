package fr.synapsegaming.social.dao;

import java.util.List;

import fr.synapsegaming.commons.dao.Dao;
import fr.synapsegaming.social.entity.ForumReply;
import fr.synapsegaming.user.entity.User;

/**
 * <b>ForumReplyDao</b> is the public interface who describe the ForumReply DAO
 * 
 * @author Meidi
 * 
 */
public interface ForumReplyDao extends Dao<ForumReply, Long> {

	public List<User> listRepliesForUser(long idUser);

}
