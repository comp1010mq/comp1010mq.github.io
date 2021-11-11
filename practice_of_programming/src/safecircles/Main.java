package safecircles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener{

	private static Main mApplication;

	/**
	 * Start the application by creating an application
	 * object and running its {@link Main#initApp()}
	 * method in the event dispatch thread.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		mApplication = new Main();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mApplication.initApp();
			}
		});
	}

	private JButton mButton;
	private Animator mAnimatorPanel;
	private JPanel mContentPane;
	
	/**
	 * Setup the GUI by calling {@link #setup()}
	 * and start it running by making it visible.
	 */
	private void initApp() {
		setup();
		pack();
		setVisible(true);
	}

	/**
	 * Creates the components of the GUI
	 * of this application and lays them out on the 
	 * content pane of the it's top-level window.
	 * 
	 */
	private void setup() {
		setTitle("Safe Circles");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		mButton = new JButton("Start");
		mButton.addActionListener(this);
		
		mAnimatorPanel = new Animator(new CirclesAnimation());
		
		mContentPane = (JPanel)getContentPane();
		mContentPane.setLayout(new BorderLayout());
		mContentPane.add(mButton, BorderLayout.SOUTH);
		mContentPane.add(mAnimatorPanel, BorderLayout.CENTER);
	}

	/**
	 * This method listens to events from the "Start" button
	 * and starts the circle drawing animation when the button in pressed.
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		mAnimatorPanel.start();
	}

}
