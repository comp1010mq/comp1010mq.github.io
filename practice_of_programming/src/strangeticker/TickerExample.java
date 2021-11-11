/**
 * This file is part of a project entitled Week9Samples which is provided as
 * sample code for the following Macquarie University unit of study:
 * 
 * COMP229 "Object Oriented Programming Practices"
 * 
 * Copyright (c) 2011-2012 Dominic Verity and Macquarie University.
 * 
 * Week9Samples is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Week9Samples is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Week9Samples. (See files COPYING and COPYING.LESSER.) If not,
 * see <http://www.gnu.org/licenses/>.
 */

package strangeticker;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 * <p>An example application which uses our stock ticker. We create a 
 * {@link MarketFeed} and a {@link StockTicker} widget object and set them 
 * both running in threads of their own. Notice that we use different thread 
 * creation methodologies in each case - as described in the week 8 notes.</p>
 * 
 * @author Dominic Verity
 *
 */

@SuppressWarnings("serial")
public class TickerExample extends JFrame {

	// Static data members (class variables and contants)
	
	/**
	 * Our application must have an application object of type {@link TickerExample}, 
	 * which we keep a hold of in the following static variable.
	 */
	private static TickerExample mApplication;

	// Data members (instance variables)
	
	/**
	 * A convenience variable, which we use to hold a reference to the applications
	 * content pane object.
	 */
	private JPanel jContentPane = null;
	
	/**
	 * Our GUI contains only a single component, a {@link StockTicker} widget which is
	 * referred to by the following variable.
	 */
	private StockTicker mStockTicker = null;
	
	/**
	 * We also need a variable to hold the {@link MarketFeed} object we'll use to provide 
	 * our stock ticker with stock price quotes.
	 */
	private MarketFeed mFeed = null;

	/**
	 * The main entry point to our application - simply creates the application
	 * object and sets it running. Notice that we must run the initialisation code
	 * for any GUI in the "Event Dispatch Thread" rather than in the "Main" thread,
	 * and to do that we use the {@link SwingUtilities#invokeLater(Runnable)} 
	 * method - you'll find out more about this in week 9.
	 * 
	 * @param pArgs array of command line arguments.
	 */
	public static void main(String[] pArgs) {
		mApplication = new TickerExample();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mApplication.initApp();
			}
		});
	}

	/**
	 * Initialise our application, by setting up the GUI layout, packing
	 * its components, switching 
	 */
	private void initApp() {
		// Setup the GUI of our application.
		setup();
		pack();
		setVisible(true);
		
		// Now set the market feed running.
		// The MarketFeed class inherits from Thread so this is just a 
		// matter of calling start().
		mFeed.start();
		
		// Also set the stock ticker widget running. 
		// The StockTicker class doesn't inherit from Thread, instead
		// it implements Runnable - so to get it running we must first
		// create a new Thread object, passing our Runnable StockTicker object
		// as the parameter to the Thread class constructor, and then 
		// call start() on that Thread object.
		Thread vTickerThread = new Thread(mStockTicker);
		vTickerThread.start();
	}
	
	/**
	 * Create the components for the GUI and
	 * lay them out in the application window.
	 */
	private void setup() {
		// Set basic frame parameters
		setTitle("Stock Ticker Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a market feed object
		mFeed = new MarketFeed();
		
		// Create a stock ticker widget object.
		// By passing the market feed object constructed above as the
		// parameter to this constructor, we ensure that our new ticker
		// will obtain its data from that particular market feed object.
		mStockTicker = new StockTicker(mFeed);

		// Get the content pane for the main GUI window...
		jContentPane = (JPanel)getContentPane();
		
		// ... set it to use border layout ... 
		jContentPane.setLayout(new BorderLayout());
		
		// ... add our stick ticker widget into the bottom border
		// of the window and...
		jContentPane.add(mStockTicker, BorderLayout.SOUTH);

		// ... specify a preferred main window size.
		jContentPane.setPreferredSize(new Dimension(300,200));
	}
}
