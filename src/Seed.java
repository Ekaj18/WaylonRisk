import java.util.ArrayList;
import java.util.List;

public class Seed {

	private List<Country> ring1 = new ArrayList<>();
	private List<Country> innerCircle = new ArrayList<>();
	private int continentNum;
	private Country seed;

	public Seed(Country seedIn, int continentNum) {
		this.seed = seedIn;
		seedIn.setSeed(true);
		this.seed.setContinentNum(continentNum);
		setContinentNum(continentNum);
		
		innerCircle = seedIn.getAdjacent();
		innerCircle.add(seed);

	}
	

	public List<Country> getInnerCircle() {
		return innerCircle;
	}

	public void setInnerCircle(List<Country> innerCircle) {
		this.innerCircle = innerCircle;
	}

	public int getContinentNum() {
		return continentNum;
	}

	public void setContinentNum(int continentNum) {
		this.continentNum = continentNum;
	}

	public List<Country> getRing1() {
		return ring1;
	}

	public void setRing1(List<Country> ring1) {
		this.ring1 = ring1;
	}

	public Country getSeed() {
		return seed;
	}

	public void setSeed(Country seed) {
		this.seed = seed;
	}
}
