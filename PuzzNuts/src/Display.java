import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Display {
	private JFrame frame;
	private JPanel entirePanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JLabel currentTime;
	private JButton solve;
	private JButton clear;
	private BoardPanel board;
	private JPanel gPane;
	private GraphicsPiece[] pieces;
	private Puzzle puzzle;
	private GraphicsPiece selectedPiece;
	private Timer timer;
	private Timer victoryTimer;
	private JLabel fireworks;
	private boolean isSolved;
	private boolean isAutoSolved;
	private double oldW;
	private double oldH;
	private long start;

	public Display() {
		initializePieces();
		initialize();
	}

	// sets up all JLabels, JPanels, Timers, MouseEvents, Graphics, etc.
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Puzzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(500, 500));
		entirePanel = new JPanel();
		entirePanel.setPreferredSize(new Dimension(1000, 800));
		oldH = 800;
		oldW = 1000;
		isAutoSolved = false;
		frame.add(entirePanel);
		gPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				for (int i = 0; i < 9; i++)
					g2.drawImage(pieces[i].getB(), (int) pieces[i].getX(), (int) pieces[i].getY(),
							(int) pieces[i].getWidth(), (int) pieces[i].getLength(), null);
			}
		};
		gPane.setLayout(new BorderLayout());
		frame.setGlassPane(gPane);
		gPane.setVisible(true);
		gPane.setOpaque(false);
		frame.pack();

		ImageIcon firework = new ImageIcon("fireworks.gif");
		fireworks = new JLabel(firework, JLabel.CENTER);
		fireworks.setPreferredSize(new Dimension(500, 500));
		fireworks.setVisible(false);
		gPane.add(fireworks, BorderLayout.CENTER);

		rightPanel = new JPanel();
		leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(entirePanel.getWidth() / 5, entirePanel.getHeight()));
		leftPanel.setBackground(Color.BLACK);
		rightPanel.setPreferredSize(
				new Dimension(entirePanel.getWidth() - entirePanel.getWidth() / 5, entirePanel.getHeight()));
		rightPanel.setBackground(Color.WHITE);

		rightPanel.setLayout(new GridBagLayout());
		int score = 0;

		currentTime = new JLabel("Current Time - 0 Seconds", JLabel.CENTER);

		start = new Date().getTime();

		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent event) {// updates
															// currentTime
				currentTime.setText("Current Time - " + ((new Date().getTime() - start) / 1000) + " Seconds");
			}
		});

		timer.start();
		victoryTimer = new Timer(700, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				gPane.repaint();
			}
		});

		currentTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		currentTime.setBackground(Color.WHITE);
		currentTime.setOpaque(true);

		GridBagConstraints bag = new GridBagConstraints();

		bag.fill = GridBagConstraints.HORIZONTAL;
		bag.gridwidth = 1;
		bag.gridx = 0;
		bag.gridy = 0;
		bag.weightx = 1;
		bag.gridx = 1;
		rightPanel.add(currentTime, bag);

		bag.gridwidth = 2;
		bag.gridx = 0;
		bag.gridy = 1;
		JPanel padding1 = new JPanel();
		padding1.setPreferredSize(new Dimension(rightPanel.getWidth(), 50));
		rightPanel.add(padding1, bag);

		bag.gridy = 2;
		bag.fill = GridBagConstraints.NONE;
		board = new BoardPanel(puzzle);
		board.setPreferredSize(new Dimension(210, 210));
		rightPanel.add(board, bag);

		bag.fill = GridBagConstraints.HORIZONTAL;
		bag.gridx = 0;
		bag.gridy = 3;
		JPanel padding2 = new JPanel();
		padding2.setPreferredSize(new Dimension(rightPanel.getWidth(), 50));
		rightPanel.add(padding2, bag);

		padding1.setOpaque(false);
		padding2.setOpaque(false);

		solve = new JButton("Solve");
		solve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {// solves the puzzle
															// and repaints all
															// the pieces in
															// their correct
															// positions
				isAutoSolved = true;
				initializePieces();
				resetPieces();
				puzzle.solvePuzzle();
				board.drawSolvedPuzzle(pieces, leftPanel.getWidth(), puzzle);
				puzzle.solvePuzzle();
				frame.repaint();
			}
		});
		clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {// clears the board
				if (isSolved) {
					isSolved = false;
					start = new Date().getTime();
					timer.start();
					victoryTimer.stop();
				}
				start = new Date().getTime();
				timer.start();
				isAutoSolved = false;
				initializePieces();
				resetPieces();
				puzzle.clear();

				frame.repaint();
			}
		});

		bag.gridwidth = 1;
		bag.gridy = 4;
		rightPanel.add(solve, bag);
		bag.gridx = 1;
		rightPanel.add(clear, bag);
		setFont();

		entirePanel.setLayout(new BorderLayout());
		entirePanel.add(leftPanel, BorderLayout.LINE_START);
		entirePanel.add(rightPanel, BorderLayout.CENTER);

		entirePanel.addComponentListener(new ComponentListener() {
			public void componentResized(ComponentEvent e) {// resizes the font,
															// images, and some
															// components
				leftPanel.setPreferredSize(new Dimension(entirePanel.getWidth() / 5, entirePanel.getHeight()));
				board.setPreferredSize(
						new Dimension(entirePanel.getWidth() * 21 / 100, 21 * entirePanel.getHeight() / 80));
				setFont();

				for (int i = 0; i < pieces.length; i++) {
					pieces[i].setWidth(118 * entirePanel.getWidth() / 1000);
					pieces[i].setLength(118 * entirePanel.getHeight() / 800);
					pieces[i].setCoords(pieces[i].getX() * entirePanel.getWidth() / oldW,
							pieces[i].getY() * entirePanel.getHeight() / oldH);
				}
				oldW = entirePanel.getWidth();
				oldH = entirePanel.getHeight();
			}

			public void componentHidden(ComponentEvent arg0) {
			}

			public void componentMoved(ComponentEvent arg0) {
			}

			public void componentShown(ComponentEvent arg0) {
			}
		});
		gPane.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {// if a piece is currently
													// selected, the selected
													// piece will follow the
													// mouse
				if (selectedPiece != null) {
					selectedPiece.setCoords(
							Math.max(-selectedPiece.getWidth() / 5,
									Math.min(e.getX() - selectedPiece.getWidth() / 2,
											frame.getWidth() - 4 * selectedPiece.getWidth() / 5)),
							Math.max(-selectedPiece.getLength() / 5,
									Math.min(frame.getHeight() - selectedPiece.getLength(),
											e.getY() - selectedPiece.getLength() / 2)));
					gPane.repaint();
				}
			}

			public void mouseMoved(MouseEvent e) {
			}

		});
		gPane.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e) && !isAutoSolved && !isSolved) {
					for (int i = pieces.length - 1; i >= 0; i--)
						if (pieces[i].contains(e.getPoint())) {
							pieces[i].rotate(puzzle);
							break;
						}
					frame.repaint();
				} else if (SwingUtilities.isLeftMouseButton(e)) {
					Point glassPanePoint = e.getPoint();
					Container container = frame.getContentPane();
					Point containerPoint = SwingUtilities.convertPoint(gPane, glassPanePoint, container);
					Component component = SwingUtilities.getDeepestComponentAt(container, containerPoint.x,
							containerPoint.y);
					if (component != null && (component.equals(solve) || component.equals(clear))) {
						((JButton) component).doClick();
					}
				}
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e) && !isAutoSolved && !isSolved) {
					selectedPiece = null;
					for (int i = pieces.length - 1; i >= 0; i--) {
						if (pieces[i].contains(e.getPoint())) {
							selectedPiece = pieces[i];
							movePieceToFront(i);
							break;
						}
					}
					if (selectedPiece != null)
						selectedPiece.removeFromBoard(puzzle);
				}
			}

			public void mouseReleased(MouseEvent e) {// if a piece is selected,
														// it is deselected and
														// snapped into position
														// on the board if
														// necessary
				if (selectedPiece != null)
					board.snap(selectedPiece, leftPanel.getWidth(), puzzle);
				if (puzzle.isSolved() && !isAutoSolved && !isSolved) {
					isSolved = true;
					timer.stop();
					int score = 0;
				}
				frame.repaint();
				selectedPiece = null;
			}
		});

		for (int i = 0; i < pieces.length; i++)
			pieces[i].setCoords(40, i * 800 / pieces.length);
		frame.setVisible(true);
	}

	// moves the GraphicsPiece at the given index to the last spot in the array,
	// effectively bringing it to the front
	public void movePieceToFront(int index) {
		for (int i = index; i < pieces.length - 1; i++) {
			GraphicsPiece temp = pieces[i];
			pieces[i] = pieces[i + 1];
			pieces[i + 1] = temp;
		}
	}

	// starts the victory sound and initializes a mario object to prepare for
	// the ending animation
	public void prepareEndingAnimation() {
		victoryTimer.start();
	}

	// sets Fonts for currentTime, solve, and clear
	public void setFont() {
		currentTime.setFont(new Font(currentTime.getFont().getName(), Font.PLAIN,
				Math.min(entirePanel.getWidth() / 30, entirePanel.getHeight() / 30)));
		solve.setFont(new Font(solve.getFont().getName(), Font.PLAIN,
				Math.min(entirePanel.getWidth() / 30, entirePanel.getHeight() / 30)));
		clear.setFont(new Font(clear.getFont().getName(), Font.PLAIN,
				Math.min(entirePanel.getWidth() / 30, entirePanel.getHeight() / 30)));
	}

	// lays out Pieces on leftPanel
	public void resetPieces() {
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].setWidth(118 * entirePanel.getWidth() / 1000);
			pieces[i].setLength(118 * entirePanel.getHeight() / 800);
			}
		for (int i = 0; i < pieces.length; i++)
			pieces[i].setCoords(leftPanel.getWidth() / 2 - pieces[i].getWidth() / 2,
					i * leftPanel.getHeight() / pieces.length);
	}

	// adds all 9 Pieces to Piece[] and all 9 Files to File[]
	// Piece[] and File[] are used to read in the image corresponding to each
	// piece
	public void initializePieces() {
		selectedPiece = null;
		PuzzlePiece[] test = new PuzzlePiece[9];
		test[0] = new PuzzlePiece(3, 2, -4, -3);
		test[1] = new PuzzlePiece(1, 4, -1, -2);
		test[2] = new PuzzlePiece(2, 1, -1, -3);
		test[3] = new PuzzlePiece(2, 4, -3, -3);
		test[4] = new PuzzlePiece(1, 1, -2, -3);
		test[5] = new PuzzlePiece(2, 4, -4, -2);
		test[6] = new PuzzlePiece(1, 4, -2, -4);
		test[7] = new PuzzlePiece(3, 2, -1, -2);
		test[8] = new PuzzlePiece(4, 3, -3, -4);
		puzzle = new Puzzle(3, test);

		File[] f = new File[9];
		pieces = new GraphicsPiece[9];
		f[0] = new File("src/piece_1.png");
		f[1] = new File("src/piece_2.png");
		f[2] = new File("src/piece_3.png");
		f[3] = new File("src/piece_4.png");
		f[4] = new File("src/piece_5.png");
		f[5] = new File("src/piece_6.png");
		f[6] = new File("src/piece_7.png");
		f[7] = new File("src/piece_8.png");
		f[8] = new File("src/piece_9.png");
		for (int i = 0; i < 9; i++) {
			pieces[i] = new GraphicsPiece(f[i], test[i]);

		}
	}

	public static void main(String[] args) {
		Display display = new Display();
	}
}
