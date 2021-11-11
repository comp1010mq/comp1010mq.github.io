/**
 * This file is part of a project entitled Week9Samples which is provided as
 * sample code for the following Macquarie University unit of study:
 * 
 * COMP229 "Object Oriented Programming Practices"
 * 
 * Copyright (c) 2011 and 2012 Dominic Verity and Macquarie University.
 * 
 * Week9Samples is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * Week9Samples is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Week9Samples. (See files COPYING and COPYING.LESSER.) If not, see
 * <http://www.gnu.org/licenses/>.
 */

package safecircles;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * <p>The Animator class provides the basic functionality to display the 
 * state of an animation and to step that animation forward at a regular 
 * frame rate.</p>
 * 
 * <p>This class extends JPanel, to provide a component upon which the 
 * animation is drawn. It also implements Runnable in order to provide 
 * a thread which periodically steps the state of the animation to the
 * next frame and calls repaint() to persuade the event dispatch thread 
 * to paint that frame.</p>
 * 
 * <p>The state of the animation is actually managed by an aggregated object 
 * of a class which implements the {@link Animatable} interface. This
 * provides methods by which the state may be stepped or painted.</p>
 * 
 * <p>To ensure thread safety, the methods of this class, except for 
 * <code>run()</code> which shouldn't be called directly anyway, should 
 * only be called from within the event dispatch thread.</p>
 * 
 * @author Dominic Verity
 *
 */
@SuppressWarnings("serial")
public class Animator extends JPanel implements Runnable {

	/*
	 * Class variables and constants
	 */
	
	/** 
	 * The pause between frames of the animation in milliseconds.
	 * So FRAME_PAUSE=30 gives a frame rate of approximately
	 * 30 frames per second.
	 */
	private static final int FRAME_PAUSE = 200;
	
	/*
	 * Instance variables (fields)
	 */
	
	/**
	 * Aggregated object which maintains the state of this animation
	 * from one frame to the next.
	 */
	private Animatable mState;
	
	/**
	 * The animation thread will keep running for as long as this variable
	 * is set to true. Setting it to false will cause the animation loop to
	 * stop, the <code>run()</code> method to exit and the animation thread
	 * to die.
	 */
	private volatile boolean mRunning;
	
	/**
	 * The thread in which this animator is running.
	 */
	private Thread mAnimatorThread;
		
	/**
	 * Create an animator to animate a supplied animatable object.
	 *  
	 * @param pState the {@link Animatable} object to be aggregated into the new
	 *               animator.
	 */
	public Animator(Animatable pState) {
		setPreferredSize(new Dimension(pState.getWidth(), pState.getHeight()));
		mState = pState;
		mRunning = false;
	}
	
	/**
	 * Updates the position of all the components of this animation.
	 * This also calls the <code>repaint()</code> of this component to inform the 
	 * event \ dispatch thread that it needs to paint the next frame.</p>
	 */
	public void step() {
		mState.step();
		repaint();
	}
	
	/**
	 * The <code>paintComponent()</code> method which is called from 
	 * the event dispatch thread whenever the GUI wants to repaint
	 * this component.
	 */
	public void paintComponent(Graphics pGraphics) {
		pGraphics.setColor(Color.WHITE);
		pGraphics.fillRect(0, 0, getWidth(), getHeight());
		mState.paint(pGraphics);
	}

	/**
	 * <p>The <code>run()</code> method of an animator thread simply loops
	 * calling <code>step()</code> to update the aggregated {@link Animatable}
	 * object.</p>
	 * 
	 * <p>We pause between each frame for <code>FRAME_PAUSE</code> milliseconds,
	 * so decreasing <code>FRAME_PAUSE</code> we can increase the frame rate 
	 * (and thus the speed) of the animation.</p>
	 */
	public void run() {
		while (mRunning) {
			try {
				Thread.sleep(FRAME_PAUSE);
				step();
			} catch (InterruptedException eExn) {
				// Nothing to do here.
			}
		}
	}

	/**
	 * Method to toggle this animation on and off.
	 */
	public void togglePause() {
		if (mRunning) {
			stop();
		} else {
			start();
		}
		
	}

	/**
	 * Query animator to see if it is running.
	 * 
	 * @return true if animation is running and false otherwise.
	 */
	public boolean isRunning() {
		return mRunning;
	}
	
	/**
	 * If this animator isn't already running, create a new thread 
	 * and set the animation going.
	 */
	public void start() {
		if (mRunning) {
			return;
		}
		mAnimatorThread = new Thread(this);
		mAnimatorThread.start();
		mRunning = true;
	}
	
	/**
	 * If this animator is already running, stop the animation loop
	 * and wait for the animation thread to die.
	 */
	public void stop() {
		if (!mRunning) {
			return;
		}
		mRunning = false;
		mAnimatorThread.interrupt();
		try {
			mAnimatorThread.join();
		} catch (InterruptedException eExn) {
			eExn.printStackTrace();
		}
	}
}
