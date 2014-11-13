import java.util.ArrayList;
import java.util.List;


public class Country {

	//used for normal gameplay
	private int army = 1;
	private int player;
	private int continentNum;
	private List<Country> adjacent = new ArrayList<>();
	
	//used for generation
	private int index;
	private boolean coast = false;
	private boolean land = false;
	private int distancex;
	private int distancey;
	private boolean isSeed = false;
	
	
	public Country(int distancex, int distancey, int index, int playerIn){
		this.distancex = distancex;
		this.distancey = distancey;
		this.index = index;
		this.player = playerIn;
	}
	
	public int getArmy() {
		return army;
	}

	public void setArmy(int army) {
		this.army = army;
	}

	public int getContinentNum() {
		return continentNum;
	}

	public void setContinentNum(int continentNum) {
		this.continentNum = continentNum;
	}

	public void setAdjacent(List<Country> adjacent) {
		this.adjacent = adjacent;
	}

	public boolean isSeed() {
		return isSeed;
	}

	public void setSeed(boolean isSeed) {
		this.isSeed = isSeed;
	}

	public void addtoAdjacent(Country newAdjacent){
		adjacent.add(newAdjacent);
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getIndex() {
		return index;
	}
	
	public List<Country> getAdjacent() {
		return adjacent;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isCoast() {
		return coast;
	}

	public void setCoast(boolean coast) {
		this.coast = coast;
	}

	public boolean isLand() {
		return land;
	}

	public void setLand(boolean land) {
		this.land = land;
	}

	public int getDistancex() {
		return distancex;
	}

	public void setDistancex(int distancex) {
		this.distancex = distancex;
	}

	public int getDistancey() {
		return distancey;
	}

	public void setDistancey(int distancey) {
		this.distancey = distancey;
	}
	
	
	
}
