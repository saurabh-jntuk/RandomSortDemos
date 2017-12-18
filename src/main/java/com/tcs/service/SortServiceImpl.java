package com.tcs.service;



import java.util.Arrays;
import java.util.List;
import java.util.Random;






import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






import com.tcs.dao.SortDAO;
import com.tcs.model.Sort;
import com.tcs.vo.SortVO;



@Service

public class SortServiceImpl implements SortService {

	
	private static final Logger logger = LoggerFactory.getLogger(SortServiceImpl.class);

	private SortDAO sortDAO;

	int sortCount = 0;



	public SortDAO getSortDAO() {

		return sortDAO;

	}



	public void setSortDAO(SortDAO sortDAO) {

		this.sortDAO = sortDAO;

	}

	@Override

	@Transactional

	public void sortAndSaveSequence() {
		
		//generating random number of size 10 from 10 to 1000 range
		int[] randomNumsGenerated=getRandomNumberInRange(10,10,1000);
		

		Sort s=new Sort();

		s.setInputSeq(Arrays.toString(randomNumsGenerated));

		

		long startTime = System.currentTimeMillis();

		int[] sortedNumber=findRandomSort(randomNumsGenerated);		

		long endTime = System.currentTimeMillis();

		long difference = endTime-startTime;		

				

		s.setSortedSeq(Arrays.toString(sortedNumber));

		s.setSwapCount(String.valueOf(sortCount));

		s.setTimeToSort(difference);

		

		this.sortDAO.saveSortedSequence(s);

	}



	



	@Override

	@Transactional

	public List<Sort> listSorts() {

		return this.sortDAO.listSorts();

	}

	

	private static int[] getRandomNumberInRange(int length,int min, int max) {

		if (min >= max) {

			throw new IllegalArgumentException("max must be greater than min");

		}



		int[] randomNumberArray=new int[length];

		Random r = new Random();

		for (int i = 0; i < length; i++) {

			randomNumberArray[i]=r.nextInt((max - min) + 1) + min;

		}		

		return randomNumberArray;

	}

	

	public int[] findRandomSort(int[] randomNum) {

		logger.info("Sorting " + randomNum.length + " elements...");

			while(!isSorted(randomNum)) {

				shuffle(randomNum);

				sortCount++;

			}

		logger.info("Shuffled " + sortCount + " times)");

		

		return randomNum;



	}



	private void shuffle(int[] shuffleRandomNum) {



		for(int x = 0; x < shuffleRandomNum.length; ++x) {



			int index1 = (int) (Math.random() * shuffleRandomNum.length),



				index2 = (int) (Math.random() * shuffleRandomNum.length);



			int a = shuffleRandomNum[index1];



			shuffleRandomNum[index1] = shuffleRandomNum[index2];



			shuffleRandomNum[index2] = a;



		}



	}



	private boolean isSorted(int[] randomNumber) {

		for(int x = 0; x < randomNumber.length - 1; ++x) {

			if(randomNumber[x] > randomNumber[x+1]) {

				return false;

			}

		}

		return true;



	}	

	





	

}