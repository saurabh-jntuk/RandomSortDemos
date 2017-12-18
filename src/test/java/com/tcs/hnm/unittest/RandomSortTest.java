

package com.tcs.hnm.unittest;
import org.junit.Test;



import com.tcs.service.SortServiceImpl;

import static org.junit.Assert.assertArrayEquals;

public class RandomSortTest {

private SortServiceImpl sorter = new SortServiceImpl();

@Test
public void shouldDoNothingWithEmptyArray() {
int[] values = {};
sorter.findRandomSort(values);}

@Test
public void shouldDoNothingWithOneElementArray() {
int[] values = {42};
sorter.findRandomSort(values);
assertArrayEquals(new int[] {42}, values);}

@Test
public void shouldSortValues() {
int[] values = { 9, -3, 5, 0, 1};
int[] expectedOrder = { -3, 0, 1, 5, 9};
sorter.findRandomSort(values);
assertArrayEquals(expectedOrder, values);
}
}