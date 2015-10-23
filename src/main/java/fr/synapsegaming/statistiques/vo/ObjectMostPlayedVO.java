package fr.synapsegaming.statistiques.vo;

public class ObjectMostPlayedVO implements Comparable<ObjectMostPlayedVO>{
	
	private String name;
	
	private Integer nbUsers;

	public ObjectMostPlayedVO(String name, Integer nbUsers) {
		this.name = name;
		this.nbUsers = nbUsers;
	}

	public ObjectMostPlayedVO() {
		
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
	public int compareTo(ObjectMostPlayedVO objectMostPlayedVO) {
        return objectMostPlayedVO.getNbUsers()-this.nbUsers;
	}

}
