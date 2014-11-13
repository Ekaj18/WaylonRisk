import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class RiskBoard extends JPanel {

	private List<Country> world = new ArrayList<>(); // holds all countries
														// in 2nd Tier
	private List<Country> countries3 = new ArrayList<>(); // holds all countries
															// in 3rd Tier
	private List<Country> coastal2 = new ArrayList<>();
	private List<Country> coastal3 = new ArrayList<>();

	RiskBoard() {
		setPreferredSize(new Dimension(1300, 800));

		// Generates world nodes
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 18; j++) {
				int Player = (int) (Math.random() * 4) + 1;
				if (i % 2 == 0) {
					world.add(new Country(60 * j, 52 * i, (i * 18) + (j + 1),
							Player));
				} else {
					world.add(new Country(60 * j + 30, 52 * i, (i * 18)
							+ (j + 1), Player));
				}
			}
		}

		for (int i = 0; i < 11 * 18; i++) {
			// top row
			if (i < 18) {
				// Left side
				if (world.get(i).getIndex() == 1) {
					world.get(i).addtoAdjacent(world.get(1));
					// world.get(i).addtoAdjacent(world.get(17));
					world.get(i).addtoAdjacent(world.get(18));
					// world.get(i).addtoAdjacent(world.get(35));
					// Right side
				} else if (world.get(i).getIndex() == 17) {
					world.get(i).addtoAdjacent(world.get(16));
					// world.get(i).addtoAdjacent(world.get(1));
					world.get(i).addtoAdjacent(world.get(34));
					world.get(i).addtoAdjacent(world.get(35));
					// Center Top
				} else {
					world.get(i).addtoAdjacent(world.get(i + 1));
					world.get(i).addtoAdjacent(world.get(i - 1));
					world.get(i).addtoAdjacent(world.get(i + 18));
					world.get(i).addtoAdjacent(world.get(i + 17));
				}
			}

			// bottom row
			else if (i > 179) {
				// Left Side
				if (world.get(i).getIndex() == 181) {
					world.get(i).addtoAdjacent(world.get(181));
					// world.get(i).addtoAdjacent(world.get(197));
					world.get(i).addtoAdjacent(world.get(i - 18));
					// world.get(i).addtoAdjacent(world.get(i - 1));
					// Right side
				} else if (world.get(i).getIndex() == 198) {
					// world.get(i).addtoAdjacent(world.get(i - 17));
					world.get(i).addtoAdjacent(world.get(i - 18));
					world.get(i).addtoAdjacent(world.get(i - 19));
					world.get(i).addtoAdjacent(world.get(i - 1));
					// Center bottom
				} else {
					world.get(i).addtoAdjacent(world.get(i + 1));
					world.get(i).addtoAdjacent(world.get(i - 1));
					world.get(i).addtoAdjacent(world.get(i - 18));
					world.get(i).addtoAdjacent(world.get(i - 19));
				}

				// middle 9 rows
			} else {

				System.out.println(world.get(i).getIndex());
				if (i % 18 == 0) {

					// Left Edge inside
					if ((i / 18) % 2 == 1) {
						world.get(i).addtoAdjacent(world.get(i + 1));
						// world.get(i).addtoAdjacent(world.get(i + 17));
						world.get(i).addtoAdjacent(world.get(i + 18));
						world.get(i).addtoAdjacent(world.get(i + 19));
						world.get(i).addtoAdjacent(world.get(i - 18));
						world.get(i).addtoAdjacent(world.get(i - 17));
						// Left Edge outside
					} else {
						world.get(i).addtoAdjacent(world.get(i + 1));
						// world.get(i).addtoAdjacent(world.get(i + 17));
						world.get(i).addtoAdjacent(world.get(i + 18));
						// world.get(i).addtoAdjacent(world.get(i + 35));
						world.get(i).addtoAdjacent(world.get(i - 18));
						// world.get(i).addtoAdjacent(world.get(i - 1));
					}
					// Right Side
				} else if ((i + 1) % 18 == 0) {
					// Right Edge Inside
					if ((i / 18) % 2 == 0) {
						world.get(i).addtoAdjacent(world.get(i - 1));
						world.get(i).addtoAdjacent(world.get(i + 17));
						world.get(i).addtoAdjacent(world.get(i + 18));
						// world.get(i).addtoAdjacent(world.get(i - 17));
						world.get(i).addtoAdjacent(world.get(i - 18));
						world.get(i).addtoAdjacent(world.get(i - 19));
						// Right Edge Outside
					} else {
						// world.get(i).addtoAdjacent(world.get(i + 1));
						world.get(i).addtoAdjacent(world.get(i + 18));
						// world.get(i).addtoAdjacent(world.get(i - 17));
						// world.get(i).addtoAdjacent(world.get(i - 35));
						world.get(i).addtoAdjacent(world.get(i - 18));
						world.get(i).addtoAdjacent(world.get(i - 1));
					}
					// center
				} else {
					world.get(i).addtoAdjacent(world.get(i + 1));
					world.get(i).addtoAdjacent(world.get(i - 1));
					world.get(i).addtoAdjacent(world.get(i - 18));
					world.get(i).addtoAdjacent(world.get(i - 19));
					world.get(i).addtoAdjacent(world.get(i + 18));
					world.get(i).addtoAdjacent(world.get(i + 17));
				}
			}
		}

		randomSeeds(5);

	}

	public void randomSeeds(int numberOfContinents) {
		for (int i = numberOfContinents; i > 0; i--) {
			int index = (int) (Math.random() * 198);
			
			int randoCarisian = (i+1)*5;

			makeContinent(randoCarisian, new Seed(world.get(index), i));
		}
	}

	public void makeContinent(int size, Seed seed) {

		int contFull = 0;
		makeLand(seed.getSeed(), seed);

		for (int i = size; i > 0; i--) {

			double randomSeed2 = Math.random();

			int location = (int) (randomSeed2 * seed.getRing1().size());

			if (seed.getRing1().get(location).isLand() == false) {
				makeLand(seed.getRing1().get(location), seed);
				seed.getRing1().get(location)
						.setContinentNum(seed.getContinentNum());
			} else {
				i++;
			}

			contFull++;
			if (contFull > 500) {
				i = -20;
			}
		}
		repaint();
	}

	public void makeLand(Country newLand, Seed seed) {

		newLand.setLand(true);
		if (seed.getInnerCircle().contains(newLand)) {
			for (int i = newLand.getAdjacent().size() - 1; i > -1; i--) {
				if (!seed.getRing1().contains(newLand.getAdjacent().get(i))) {
					seed.getRing1().add(newLand.getAdjacent().get(i));
				}
			}
		}
	}

	public void paint(Graphics g) {

		g.setColor(new Color(39, 68, 148)); // Dark Blue background
		g.fillRect(0, 0, 1300, 800); // draws over entire screen
		// g.drawImage(bkg, 0, -25, this);

		// Sets Font
		Font f = new Font("SANS_SERIF", Font.PLAIN, 40);
		g.setFont(f);

		// Starting Position for Country 0
		int x = 95;
		int y = 120;

		// shows entire grid for debugging adj. lists
		// g.setColor(new Color(0, 0, 0));
		//
		// for (int i = world.size() - 1; i > -1; i--) {
		// g.fillOval(x + world.get(i).getDistancex(), y
		// + world.get(i).getDistancey(), 60, 60);
		// }

		for (int i = world.size() - 1; i > -1; i--) {
			if (world.get(i).isLand()) {

				if (world.get(i).getContinentNum() == 5) {
					g.setColor(new Color(204, 198, 84));
					g.fillOval(x + world.get(i).getDistancex(), y
							+ world.get(i).getDistancey(), 60, 60);
				} else if (world.get(i).getContinentNum() == 4) {
					g.setColor(new Color(153, 118, 73));
					g.fillOval(x + world.get(i).getDistancex(), y
							+ world.get(i).getDistancey(), 60, 60);
				} else if (world.get(i).getContinentNum() == 3) {
					g.setColor(new Color(255, 155, 116));
					g.fillOval(x + world.get(i).getDistancex(), y
							+ world.get(i).getDistancey(), 60, 60);
				} else if (world.get(i).getContinentNum() == 2) {
					g.setColor(new Color(166, 166, 166));
					g.fillOval(x + world.get(i).getDistancex(), y
							+ world.get(i).getDistancey(), 60, 60);
				} else if (world.get(i).getContinentNum() == 1) {
					g.setColor(new Color(138, 204, 97));
					g.fillOval(x + world.get(i).getDistancex(), y
							+ world.get(i).getDistancey(), 60, 60);
				}

			}
			if (world.get(i).isLand()) {

				if (world.get(i).getPlayer() == 1) {
					g.setColor(new Color(76, 57, 97));
					g.fillOval(x + 2 + world.get(i).getDistancex(), y
							+ 2 + world.get(i).getDistancey(), 56, 56);
					
					g.setColor(new Color(131, 98, 166));
					g.drawString(""+ world.get(i).getArmy(),x + 19 + world.get(i).getDistancex(),y
							+ 45 + world.get(i).getDistancey());
					
				}
				if (world.get(i).getPlayer() == 2) {
					g.setColor(new Color(26, 107, 106));
					g.fillOval(x + 2 + world.get(i).getDistancex(), y
							+ 2 + world.get(i).getDistancey(), 56, 56);
					
					g.setColor(new Color(40, 163, 162));
					g.drawString(""+ world.get(i).getArmy(),x + 19 + world.get(i).getDistancex(),y
							+ 45 + world.get(i).getDistancey());
				}
				if (world.get(i).getPlayer() == 3) {
					g.setColor(new Color(117, 36, 41));
					g.fillOval(x + 2 + world.get(i).getDistancex(), y
							+ 2 + world.get(i).getDistancey(), 56, 56);
					
					g.setColor(new Color(181, 58, 48));
					g.drawString(""+ world.get(i).getArmy(),x + 19 + world.get(i).getDistancex(),y
							+ 45 + world.get(i).getDistancey());
				}
				if (world.get(i).getPlayer() == 4) {
					g.setColor(new Color(32, 97, 4));
					g.fillOval(x + 2 + world.get(i).getDistancex(), y
							+ 2 + world.get(i).getDistancey(), 56, 56);
					
					g.setColor(new Color(54, 163, 6));
					g.drawString(""+ world.get(i).getArmy(),x + 19 + world.get(i).getDistancex(),y
							+ 45 + world.get(i).getDistancey());
				}

				

			}
		}
	}
}
