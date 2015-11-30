package fr.synapsegaming.statistiques.vo;

public class SpecMostPlayedVO extends FiveMostVO<SpecMostPlayedVO>{
	private Integer nbUsers;
	
	public SpecMostPlayedVO(String name, Integer nbUsers){
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
	public int compareTo(SpecMostPlayedVO specMostPlayedVO) {
		return specMostPlayedVO.getNbUsers()-this.nbUsers;
	}
	

}
