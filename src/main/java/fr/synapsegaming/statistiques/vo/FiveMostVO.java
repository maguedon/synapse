package fr.synapsegaming.statistiques.vo;

public abstract class FiveMostVO<T> implements Comparable<T>{
	
	private String name;
	
	public FiveMostVO(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
