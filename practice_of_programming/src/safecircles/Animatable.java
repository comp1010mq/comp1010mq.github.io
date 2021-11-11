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

import java.awt.Graphics;

/**
 * <p>This interface should be implemented by any class which is intended to
 * represent the state of an animation as it evolves from frame to frame.</p>
 * 
 * <p>Note that the <code>step()</code> and <code>paint()</code> methods should
 * generally be synchronized, because they are called from different threads. 
 * Specifically, <code>step()</code> is called from the animation thread and 
 * <code>paint()</code> is called from the event dispatch thread.</p>
 * 
 * @author Dominic Verity
 */
public interface Animatable {

	/**
	 * Step the animation state forward by one frame.
	 */
	public void step();
	
	/**
	 * Paint the current state of the animation onto the supplied 
	 * graphics canvas.
	 */
	public void paint(Graphics pGraphics);
	
	/**
	 * Get the width of this animation.
	 * 
	 * @return default width of the canvas on which this animation should 
	 * 		   be drawn in pixels.
	 */
	public int getWidth();

	/**
	 * Get the height of this animation.
	 * 
	 * @return default height of the canvas on which this animation should 
	 * 		   be drawn in pixels.
	 */
	public int getHeight();

}
