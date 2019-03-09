package com.examples.ezoo.model;

public class FeedingSchedule {
	
	private long schedule_id = 0L;

	private String food = "";

	private String notes = "";

	private double hoursBetweenFeedings = 0D;

	private double numberPounds = 0D;

	
	/**
	 * @return the schedule_id
	 */
	
	
	public long getSchedule_id() {
		return schedule_id;
	}

	/**
	 * @param schedule_id
	 *            the schedule_id to set
	 */
	public void setSchedule_id(long schedule_id) {
		this.schedule_id = schedule_id;
	}

	/**
	 * @return the HoursBetweenFeedings
	 */
	public double getHoursBetweenFeedings() {
		return hoursBetweenFeedings;
	}

	/**
	 * @param HoursBetweenFeedings
	 *            the HoursBetweenFeedings to set
	 */
	public void setHoursBetweenFeedings(double HoursBetweenFeedings) {
		this.hoursBetweenFeedings = HoursBetweenFeedings;
	}

	/**
	 * @return the food
	 */
	public String getFood() {
		return food;
	}

	/**
	 * @param food
	 *            the food to set
	 */
	public void setFood(String food) {
		this.food = food;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the amountPounds
	 */
	public double getNumberPounds() {
		return numberPounds;
	}

	/**
	 * @param numberPounds
	 *            the numberPounds to set
	 */
	public void setNumberPounds(double numberPounds) {
		this.numberPounds = numberPounds;
	}

	
	public FeedingSchedule() {

	}

	public FeedingSchedule(long schedule_id, String food, String notes, double hoursBetweenFeedings,
			double numberPounds) {
		super();
		this.schedule_id = schedule_id;
		this.food = food;
		this.notes = notes;
		this.hoursBetweenFeedings = hoursBetweenFeedings;
		this.numberPounds = numberPounds;
		
	}

	@Override
	public String toString() {
		return "FeedingSchedule [schedule_id=" + schedule_id + ", food=" + food + ", notes=" + notes + ", hoursBetweenFeedings=" + hoursBetweenFeedings
				+ ",  numberPounds=" + numberPounds + "]";
	}

}
