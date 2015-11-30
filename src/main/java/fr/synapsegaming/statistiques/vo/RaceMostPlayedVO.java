package fr.synapsegaming.statistiques.vo;

import java.util.List;

public class RaceMostPlayedVO extends FiveMostVO<RaceMostPlayedVO>{
	private Integer nbUsers;
	
	public RaceMostPlayedVO(String name, Integer nbUsers) {
		super(name);
		this.nbUsers = nbUsers;
	}

	public List<RaceMostPlayedVO> list(){
		
		return null;
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
