import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;

/**
 * @author adatta This class extends the JPanel class and shows the display of
 *         the Rotating Line project. It creates an application window which
 *         allows the user to start rotation, change the speed of rotation,
 *         reverse the direction of rotation, and stop the rotation of a line on
 *         the screen.
 *
 *         Data fields include a DrawScreen object where the rotation is done
 */
public class Display extends JPanel {
	private DrawScreen ds;

	/**
	 * Create the panel.
	 */
	public Display() {
		// creates the DrawScreen panel in the top center of the window
		ds = new DrawScreen();
		setLayout(new BorderLayout(0, 0));

		DrawScreen ds = new DrawScreen();
		add(ds, BorderLayout.CENTER);

		// creates the panel for the controls of the rotation
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		// creates a start button with a green text color
		JButton btnStart = new JButton("Start");
		btnStart.setForeground(new Color(0, 204, 0));
		panel.add(btnStart);

		// creates a reverse button with a blue text color
		JButton btnReverse = new JButton("Reverse");
		btnReverse.setForeground(new Color(0, 0, 255));
		panel.add(btnReverse);

		// creates a stop button with a red text color
		JButton btnStop = new JButton("Stop");
		btnStop.setForeground(new Color(255, 0, 0));
		panel.add(btnStop);

		// adds spacing in between elements
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		/*
		 * creates the slider where the speed and direction rotation can be
		 * manually controlled
		 */
		// creates a counterClockwise label
		JLabel lblCounterclockwise = new JLabel("Counterclockwise");
		panel.add(lblCounterclockwise);
		// creates a slider with values from -25 to 25 set to 0 by default
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setMaximum(25);
		slider.setMinimum(-25);
		panel.add(slider);
		// creates an actionListener for the start button which sets the
		// rotation speed to 5 on the slider
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				slider.setValue(5);
			}
		});
		// creates an actionListener for the stop button which sets the rotation
		// speed to 0 on the slider
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				slider.setValue(0);
			}
		});
		// creates an actionListener for the reverse button which sets the
		// rotation speed to the negative value of what
		// the slider was previously set to

		btnReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				slider.setValue(-1 * slider.getValue());
			}
		});

		JLabel lblClockwise = new JLabel("Clockwise");

		panel.add(lblClockwise);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);

		/*
		 * creates a timer which rotates the line by pi/180 radians times the
		 * value of the slider which controls the angle of rotation so the line
		 * can rotate faster or slower, and repaints the DrawScreen panel every
		 * time to update the line
		 */
		class TimerListener implements ActionListener {

			public void actionPerformed(ActionEvent event) {
				ds.rotate((slider.getValue() * Math.PI) / 180);
				ds.repaint();
			}
		}
		final Timer timer = new Timer(20, new TimerListener());
		timer.start();

	}

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		Display test = new Display();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(500, 300));
		frame.setVisible(true);
		frame.setContentPane(test);
		test.updateUI();

		;

	}

}