package fr.synapsegaming.statistiques.vo;

public class RaceMostPlayedVO implements Comparable<RaceMostPlayedVO> {

	private String name;

	private Integer nbUsers;
	
	public RaceMostPlayedVO(String name, int nbUsers) {
		this.name = name;
		this.nbUsers = nbUsers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNbUsers() {
		return nbUsers;
	}

	public void setNbUsers(Integer nbUsers) {
		this.nbUsers = nbUsers;
	}

	@Override
	public int compareTo(RaceMostPlayedVO raceMostPlayedVO) {
        return raceMostPlayedVO.getNbUsers()-this.nbUsers;
	}
}
