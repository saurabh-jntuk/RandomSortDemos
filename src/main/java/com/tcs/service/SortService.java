package com.tcs.service;

import java.util.List;

import com.tcs.model.Sort;
import com.tcs.vo.SortVO;

public interface SortService {

	public void sortAndSaveSequence();	
	public List<Sort> listSorts();
	
}
