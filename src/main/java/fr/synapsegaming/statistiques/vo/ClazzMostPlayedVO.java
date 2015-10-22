package fr.synapsegaming.statistiques.vo;

public class ClazzMostPlayedVO implements Comparable<ClazzMostPlayedVO>{
	
	private String name;
	
	private Integer nbUsers;

	public ClazzMostPlayedVO(String name, Integer nbUsers) {
		this.name = name;
		this.nbUsers = nbUsers;
	}

	public ClazzMostPlayedVO() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbUsers() {
		return nbUsers;
	}

	public void setNbUsers(int nbUsersInClazz) {
		this.nbUsers = nbUsersInClazz;
	}

	@Override
	public int compareTo(ClazzMostPlayedVO clazzMostPlayedVO) {
        return clazzMostPlayedVO.getNbUsers()-this.nbUsers;
	}

}
