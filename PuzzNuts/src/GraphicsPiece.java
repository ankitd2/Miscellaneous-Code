import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class GraphicsPiece {
	private BufferedImage[] allForms;
	private BufferedImage b;
	private PuzzlePiece p;
	private int index;
	private double x;
	private double y;
	private int width;
	private int length;

	// ctor given File and Piece, reads in BufferedImage
	public GraphicsPiece(File f, PuzzlePiece p) {
		this.p = p;
		index = 0;
		x = 10;
		y = 10;
		width = 118;
		length = 118;
		try {
			b = ImageIO.read(f);
			allForms = new BufferedImage[4];
			allForms = createAllFormsArray(b);
			b = allForms[0];
		} catch (Exception E) {
		}
	}

	// returns a rotated BufferedImage
	public BufferedImage generateRotation(BufferedImage b, int rotation) {
		int w = b.getWidth();
		int h = b.getHeight();
		BufferedImage rotatedImage = new BufferedImage(w, h, b.getType());
		Graphics2D g2 = rotatedImage.createGraphics();
		g2.rotate(Math.toRadians(rotation), w / 2, h / 2); // rotate by the
															// center
		g2.drawImage(b, null, 0, 0);
		return rotatedImage;
	}

	// returns array of BufferedImages, each image is a different rotation (0,
	// 90, 180, 270)
	public BufferedImage[] createAllFormsArray(BufferedImage b) {
		BufferedImage[] allForms = new BufferedImage[4];
		for (int i = 0; i < 4; i++) {
			allForms[i] = generateRotation(b, i * 90);
		}
		return allForms;
	}

	// rotates the BufferedImage by 90 degrees
	public void rotate(Puzzle p) {
		this.p.rotate(true);
		index = (index + 1) % 4;
		for (int i = 0; i < p.getRows(); i++)
			for (int j = 0; j < p.getCols(); j++)
				// checks if the piece is in the puzzle and rotating it would
				// make it no longer fit
				if (p.getPiece(i, j) != null && p.getPiece(i, j).equals(this.p) && !p.canFit(i, j, this.p)) {
					this.p.rotate(true);
					this.p.rotate(true);
					this.p.rotate(true);
					index = (index + 3) % 4;
				}

		b = allForms[index];
	}

	// called after solving the puzzle, rotates the image so that it correctly
	// matches the orientation of the piece
	public void resyncSides() {
		index = p.getRotation();
		b = allForms[index];
	}

	// returns true if point is on the BufferedImage (used to make sure you are
	// clicking on the Piece)
	public boolean contains(Point p) {
		if (p.x >= x + width / 5 && p.x <= x + 4 * width / 5 && p.y >= y + length / 5 && p.y <= y + 4 * length / 5)
			return true;
		return false;
	}

	// removes Piece from Board
	public void removeFromBoard(Puzzle p) {
		for (int i = 0; i < p.getRows(); i++)
			for (int j = 0; j < p.getCols(); j++)
				if (p.getPiece(i, j) != null && p.getPiece(i, j).equals(this.p))
					p.removePiece(i, j);
	}

	// getter for BufferedImage
	public BufferedImage getB() {
		return b;
	}

	// sets coordinates of Piece to (x,y)
	public void setCoords(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// gets x coordinate of Piece
	public double getX() {
		return x;
	}

	// gets y coordinate of Piece
	public double getY() {
		return y;
	}

	// gets width of image
	public int getWidth() {
		return width;
	}

	// sets width of image
	public void setWidth(int width) {
		this.width = width;
	}

	// gets length of image
	public int getLength() {
		return length;
	}

	// sets length of image
	public void setLength(int length) {
		this.length = length;
	}

	// gets Piece
	public PuzzlePiece getPiece() {
		return p;
	}

}
