package fr.synapsegaming.statistiques.vo;

public class UserMostActiveVO extends FiveMostVO<UserMostActiveVO> {
	
	private Integer nbReplies;

	public UserMostActiveVO(String name, Integer nbReplies) {
		super(name);
		this.nbReplies = nbReplies;
	}

	public int getNbReplies() {
		return nbReplies;
	}

	public void setNbReplies(int nbReplies) {
		this.nbReplies = nbReplies;
	}

	@Override
	public int compareTo(UserMostActiveVO userMostActiveVO) {
        return userMostActiveVO.getNbReplies()-this.nbReplies;
	}

}
