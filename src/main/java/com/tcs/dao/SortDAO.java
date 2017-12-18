package com.tcs.dao;

import java.util.List;

import com.tcs.model.Sort;

public interface SortDAO {
	public void saveSortedSequence(Sort p);	
	public List<Sort> listSorts();
	
}
