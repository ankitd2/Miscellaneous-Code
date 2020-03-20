import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	private JLabel[][] squares;
	
	// ctor given Puzzle, creates new JLabel for each square on board
	public BoardPanel(Puzzle p) {
		setLayout(new GridLayout(p.getRows(), p.getCols()));
		squares = new JLabel[p.getRows()][p.getCols()];
		for (int i = 0; i < p.getRows(); i++) {
			for (int j = 0; j < p.getCols(); j++) {
				squares[i][j] = new JLabel();
				squares[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				add(squares[i][j]);
			}
		}

	}

	// snaps GraphicPiece into place when within a specified distance of the
	// spot on the board
	public void snap(GraphicsPiece p, int extraWidth, Puzzle puzzle) {
		double pl = p.getY() + p.getLength() / 5;
		double pw = p.getX() + p.getWidth() / 5;
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				if (Math.abs(squares[i][j].getX() + this.getX() + extraWidth - pw) < 15
						&& Math.abs(squares[i][j].getY() + this.getY() - pl) < 15
						&& puzzle.canFit(i, j, p.getPiece())) {
					p.setCoords(squares[i][j].getX() + this.getX() + extraWidth - p.getWidth() / 5,
							squares[i][j].getY() + this.getY() - p.getLength() / 5);
					puzzle.addPiece(i, j, p.getPiece());
				}
			}
		}
	}

	// draws the GraphicsPiece objects in the correct spot as specified by the
	// Puzzle class's solve() method
	public void drawSolvedPuzzle(GraphicsPiece[] pieces, int extraWidth, Puzzle p) {
		for (int k = 0; k < pieces.length; k++)
			pieces[k].resyncSides();
		for (int i = 0; i < p.getRows(); i++)
			for (int j = 0; j < p.getCols(); j++)
				for (int k = 0; k < pieces.length; k++)
					if (p.getPiece(i, j) != null && p.getPiece(i, j).equals(pieces[k].getPiece()))
						pieces[k].setCoords(squares[i][j].getX() + this.getX() + extraWidth - pieces[k].getWidth() / 5,
								squares[i][j].getY() + this.getY() - pieces[k].getLength() / 5);
	}
}
