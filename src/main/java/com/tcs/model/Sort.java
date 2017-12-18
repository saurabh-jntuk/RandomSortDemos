package com.tcs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author saurabh
 *
 */

@Entity
@Table(name="SORT")
public class Sort {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	@Column(name="inputSequence")
	private String inputSeq;
	@Column(name="sortedSequence")
	private String sortedSeq;
	@Column(name="swapCount")
	private String swapCount;	
	@Column(name="timeTaken")
	private long timeToSort;

	

	public String getSwapCount() {
		return swapCount;
	}

	public void setSwapCount(String swapCount) {
		this.swapCount = swapCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInputSeq() {
		return inputSeq;
	}

	public void setInputSeq(String inputSeq) {
		this.inputSeq = inputSeq;
	}

	public String getSortedSeq() {
		return sortedSeq;
	}

	public void setSortedSeq(String sortedSeq) {
		this.sortedSeq = sortedSeq;
	}
	

	public long getTimeToSort() {
		return timeToSort;
	}

	public void setTimeToSort(long difference) {
		this.timeToSort = difference;
	}

	
	
		
}
