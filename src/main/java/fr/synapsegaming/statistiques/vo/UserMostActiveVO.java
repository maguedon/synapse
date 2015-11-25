package fr.synapsegaming.statistiques.vo;

public class UserMostActiveVO implements Comparable<UserMostActiveVO>{
	
	private String name;
	
	private Integer nbReplies;

	public UserMostActiveVO(String name, Integer nbReplies) {
		this.name = name;
		this.nbReplies = nbReplies;
	}

	public UserMostActiveVO() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
