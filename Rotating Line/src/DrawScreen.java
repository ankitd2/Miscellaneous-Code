import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author adatta This class extends the JPanel class and is used to draw a line
 *         and rotate it on the panel used in the Display class. Its data fields
 *         include a RotatingLine object line and a double angle
 */
public class DrawScreen extends JPanel {


	private RotatingLine line;
	private double angle;

	// constructors using RotatingLine constructors using the center point for
	// originX and originY, the length of the line,
	// and the angle which the line is currently at
	public DrawScreen() {
		line = new RotatingLine();
	}

	public DrawScreen(int originX, int originY, double angle) {
		line = new RotatingLine(originX, originY, angle);
	}

	public DrawScreen(double length, int originX, int originY, double angle) {
		line = new RotatingLine(length, originX, originY, angle);
	}

	// this method is used to calculate the radius of the DrawScreen panel
	// depending on the height and width of the window. By using the Pythagorean
	// theorem, it takes half the width and half the length,
	// squares them and adds them together and takes the square root of the sum.
	// It returns this final value as a double.
	public double getScreenRadius() {
		return Math.sqrt(Math.pow(getDrawScreenWidth() / 2, 2) + Math.pow(getDrawScreenHeight() / 2, 2));
	}

	// gets the width of the screen and returns it as an integer value
	public int getDrawScreenWidth() {
		return this.getWidth();
	}

	// gets the height of the screen and returns it as an integer value
	public int getDrawScreenHeight() {
		return this.getHeight();
	}
	// calculates the coordinates for the center of the panel and returns it as
		// an array of ints with the x-value in index 0 and y-value in index 1
	public int[] getCenter() {
		int[] center = new int[2];
		center[0] = getDrawScreenWidth() / 2;
		center[1] = getDrawScreenHeight() / 2;
		return center;

	}
	// paints the line on the screen using the paintComponent method and
		// coordinates given from the RotatingLine class method getCoords()
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		line.setOriginX(getCenter()[0]);
		line.setOriginY(getCenter()[1]);
		line.setLength(getScreenRadius());

		g.drawLine(line.getCoords()[0], line.getCoords()[1], line.getCoords()[2], line.getCoords()[3]);
		line.setAngle(line.getAngle() + Math.PI);

	}
	// this method does the rotation of the line by change the angle of the line
	public void rotate(double angle) {
		line.rotate(angle);

	}

}