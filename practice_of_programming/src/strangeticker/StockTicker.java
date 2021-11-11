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

import javax.swing.JTextField;

/**
 * <p>The {@link StockTicker} widget class itself. This inherits from 
 * {@link JTextField}, because it really is a special type of text field 
 * which automatically updates itself.</p>
 * 
 * <p>It also implements the Runnable interface, so that we can run it in a 
 * thread which keep the ticker message moving. Look in the {@link TickerExample} 
 * class to see how we set this going in a thread of its own.</p>
 * 
 * @author Dominic Verity
 *
 */

@SuppressWarnings("serial")
public class StockTicker extends JTextField implements Runnable {

	// Static data members (constants and class variables)
	
	/**
	 * Pause between ticker display updates
	 * Making this smaller will increase the rate at which things
	 * scroll past
	 */
	private static final long UPDATE_PAUSE = 100;
	
	/**
	 * Number of characters in the ticker message
	 */
	private static final int MESSAGE_LENGTH = 200;

	// Data members (instance variables)
	
	/**
	 * Number of the next stock whose price information is to be 
	 * added to the ticker message.
	 */
	private int mCurrentStock = 0;
	
	/**
	 * A string buffer in which to store the currently displayed ticker message.
	 */
	private StringBuffer mStringBuffer = null;
	
	/**
	 * The MarketFeed object from which this ticker sources its market information.
	 */
	private MarketFeed mFeed;
	
	/**
	 * Constructor. Creates a stock ticker component which reads its market
	 * information from a given MarketFeed object. Initialises the text field and
	 * an associated string buffer with stock price information.
	 */
	public StockTicker(MarketFeed pFeed) {
		// Save supplied market feed object for future use.
		mFeed = pFeed;
		
		// Create a string buffer to hold the current ticker message.
		mStringBuffer = new StringBuffer(MESSAGE_LENGTH + 50);
		
		// Initialise number of next stock to append to ticker message.
		mCurrentStock = 0;
		
		// Add the information about as many stocks as possible to the
		// ticker message.
		while (mStringBuffer.length() < MESSAGE_LENGTH)
			appendCurrentStock();
		
		// ... and set the displayed content of this text field to be this
		// ticker message.
		setText(mStringBuffer.toString());
		
		// Prevent the user from editing or focusing this text field.
		setEditable(false);
		setFocusable(false);
		setBackground(null);
	}

	/**
	 * Add the name of the next stock to be displayed to the ticker message
	 * and update the next stock pointer.
	 */
	private void appendCurrentStock() {
		mStringBuffer.append(mFeed.getTickerName(mCurrentStock)+":" + 
				mFeed.getQuote(mCurrentStock)+" ");
		mCurrentStock = (mCurrentStock + 1) % MarketFeed.NUM_STOCKS;
	}
	
	/**
	 * Here is the body of the thread, which updates the
	 * stock price ticker display.
	 */
	public void run() {
		
		try {
			while (!Thread.interrupted()) {
				Thread.sleep(UPDATE_PAUSE);
			
				mStringBuffer.deleteCharAt(0);	
				if (mStringBuffer.length() < MESSAGE_LENGTH) 
					appendCurrentStock();
				setText(mStringBuffer.toString());
			}	
		} catch (InterruptedException eExn) {
			// Nothing to do here, just fall through and exit this thread.
		}
		
	}
}
