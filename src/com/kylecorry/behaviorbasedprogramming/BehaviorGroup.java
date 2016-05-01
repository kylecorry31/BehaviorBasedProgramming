package com.kylecorry.behaviorbasedprogramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BehaviorGroup {
	private List<Behavior> mBehaviors;

	/**
	 * A group of behaviors that can be run in order of their hierarchy.
	 * 
	 * @param behaviors
	 *            The behaviors in the BehaviorGroup.
	 */
	public BehaviorGroup(List<Behavior> behaviors) {
		mBehaviors = behaviors;
		sortBehaviors();
	}

	/**
	 * A group of behaviors that can be run in order of their hierarchy.
	 */
	public BehaviorGroup() {
		mBehaviors = new ArrayList<>();
	}

	/**
	 * Sort the behaviors based on their importance.
	 */
	private void sortBehaviors() {
		mBehaviors.sort(new Comparator<Behavior>() {
			@Override
			public int compare(Behavior o1, Behavior o2) {
				return o2.importance() - o1.importance();
			}
		});
	}

	/**
	 * Add a behavior to the hierarchy.
	 * 
	 * @param behavior
	 *            The behavior to add.
	 */
	public void add(Behavior behavior) {
		mBehaviors.add(behavior);
		sortBehaviors();
	}

	/**
	 * Get all of the behaviors in the group.
	 * 
	 * @return The behaviors.
	 */
	public List<Behavior> getBehaviors() {
		return mBehaviors;
	}

	/**
	 * Run the triggered behavior that is highest up on the hierarchy.
	 * 
	 * @return Whether a behavior was run.
	 */
	public boolean run() {
		for (Behavior behavior : mBehaviors) {
			if (behavior.trigger()) {
				behavior.control();
				return true;
			}
		}
		return false;
	}
}
