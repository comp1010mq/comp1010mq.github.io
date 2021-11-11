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

import java.util.Random;

/**
 * <p>This class simulates the "market feed" which accepts a
 * stream of price updates and stores the most recent price
 * for each stock in the market.</p>
 * 
 * <p>It is implemented as a class that extends the {@link java.lang.Thread}
 * class so that we can run the market feed independently 
 * in a thread of its own.</p>
 * 
 * <p>In practice this would read information from an incoming 
 * data stream provided by an exchange, but in this case we
 * randomly generate stock price movements.</p>
 * 
 * @author Dominic Verity
 *
 */
public class MarketFeed extends Thread {
	
	// Static data members (constants and class variable)

	/**
	 * Array of symbolic names of the stocks in this market
	 */
	private static final String[] STOCK_NAMES = {"ANZ","TLS", "NAB", "RIO", "GIO"};

	/**
	 * Number of stocks traded in this market
	 */
	public static final int NUM_STOCKS = STOCK_NAMES.length;
	
	/**
	 * Simulation parameter - maximum uptick / downtick per update
	 */
	private static final int MAX_TICK = 20;
	
	/**
	 * Simulation parameter - maximum wait between updates
	 */
	private static final long MAX_UPDATE_WAIT = 1000;

	// Data members (instance variables)
	
	/**
	 * Array to hold the most recent traded price in each stock
	 */
	private int[] mQuotes;
	
	/**
	 * Variable to hold a random number generator
	 */
	private Random mGenerator;

	// Constructors
	
	/**
	 * Default constructor - create a quotes array and
	 * populate it with randomly generated initial values.
	 */
	MarketFeed () {
		mQuotes = new int[NUM_STOCKS];
		mGenerator = new Random();
		for (int i = 0; i < NUM_STOCKS; i++)
			mQuotes[i] = Math.abs(mGenerator.nextInt()) % 2000;
	}

	// Public methods
	
	/**
	 * The run() method for this thread, simply generates
	 * price updates at randomly chosen update intervals.
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			while (!interrupted()) {
				int vStockNum = (int)(Math.abs (mGenerator.nextLong()) % NUM_STOCKS);
				long vPriceUpdate = (int)(mGenerator.nextLong() % MAX_TICK);
				mQuotes[vStockNum] += vPriceUpdate;
				Thread.sleep(Math.abs(mGenerator.nextLong()) % MAX_UPDATE_WAIT);
			}
		} catch (InterruptedException e) { 
			// Nothing to do here, just drop through and exit.
		}
	}
	
	/**
	 * Get a stock quote for a specific numbered stock.
	 * 
	 * @param pStockNo the number of the stock to return a quote for.
	 * @return the quote if 0 <= pStockNo < NUM_STOCKS and -1 otherwise. 
	 */
	public int getQuote(int pStockNo) {
		if (0 <= pStockNo && pStockNo < NUM_STOCKS) 
			return mQuotes[pStockNo];
		else
			return -1;
	}
	
	/**
	 * Get the ticker name for a specific numbered stock
	 * 
	 * @param pStockNo the number of the stock whose ticker name is required.
	 * @return the ticker name if 0 <= pStockNo < NUM_STOCKS and empty otherwise.
	 */
	public String getTickerName(int pStockNo) {
		if (0 <= pStockNo && pStockNo < NUM_STOCKS) 
			return STOCK_NAMES[pStockNo];
		else
			return "";
	}
}
