package fr.synapsegaming.statistiques.vo;

public class ClazzMostPlayedVO extends FiveMostVO<ClazzMostPlayedVO>{
	private Integer nbUsers;

	public ClazzMostPlayedVO(String name, Integer nbUsers) {
		super(name);
		this.nbUsers = nbUsers;
	}

	public Integer getNbUsers() {
		return nbUsers;
	}

	public void setNbUsers(Integer nbUsers) {
		this.nbUsers = nbUsers;
	}

	@Override
	public int compareTo(ClazzMostPlayedVO clazzMostPlayedVO) {
		return clazzMostPlayedVO.getNbUsers()-this.nbUsers;
	}


}
