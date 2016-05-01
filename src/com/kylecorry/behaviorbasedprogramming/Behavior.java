package com.kylecorry.behaviorbasedprogramming;

public interface Behavior {

	public enum Type {
		BALLISTIC, SERVO
	}

	/**
	 * The type of the behavior where Ballistic runs without sensor feedback,
	 * and the Servo runs with sensor feedback.
	 * 
	 * @return The type of the behavior.
	 */
	public Type type();

	/**
	 * The importance of the behavior in the hierarchy, where the higher the
	 * number, the more important the behavior is.
	 * 
	 * @return The importance of this behavior.
	 */
	public int importance();

	/**
	 * A boolean trigger for this behavior. Normally behaviors are triggered by
	 * sensor values, but default behaviors should return true.
	 * 
	 * @return Whether this behavior should be run.
	 */
	public boolean trigger();

	/**
	 * The control part of the behavior where the action is performed.
	 */
	public void control();
}
