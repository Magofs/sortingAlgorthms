package programmingWeek4;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestWeek4 {
	
	@Test
	@DisplayName("Test binary search")
	public void testBinarySearch() {
		ProgrammingWeek4 week4 = new ProgrammingWeek4();
		assertEquals("2 0 -1 0 -1 ", week4.runFirstBinarySearch(5));
	}
	
	@Test
	@DisplayName("Test majority element")
	public void testMajorityElement() {
		ProgrammingWeek4 week4 = new ProgrammingWeek4();
		assertEquals(1, week4.runFirstMajority(5));
		assertEquals(0, week4.runSecondMajority(4));
		assertEquals(0, week4.runThirdMajority(4));
	}
	
	@Test
	@DisplayName("Test selection sort")
	public void testSelectionSort() {
		ProgrammingWeek4 week4 = new ProgrammingWeek4();
		assertTrue(week4.runSelectionSort());
		
	}
	
	@Test
	@DisplayName("Test merge sort")
	public void testMergeSort() {
		ProgrammingWeek4 week4 = new ProgrammingWeek4();
		assertTrue(week4.runMergeSort());
	}
	
	@Test
	@DisplayName("Test quick sort")
	public void testQuickSort() {
		ProgrammingWeek4 week4 = new ProgrammingWeek4();
		assertTrue(week4.runQuickSort());
	}
	
	@Test
	@DisplayName("Test optimized quick sort")
	public void testOptimizedQuickSort() {
		ProgrammingWeek4 week4 = new ProgrammingWeek4();
		assertTrue(week4.runOptimizedQuickSort());
	}
	
	@Test
	@DisplayName("Get number of inversions")
	public void testInversionCount() {
		ProgrammingWeek4 week4 = new ProgrammingWeek4();
		assertEquals(2, week4.runNumberOfInversions(5));
	}
	
	@Test
	@DisplayName("Get points in segments")
	public void testCountSegments() {
		ProgrammingWeek4 week4 = new ProgrammingWeek4();
		assertEquals("1 0 0 ", week4.runFirstOptimalCountSegment());
		assertEquals("0 0 1 ", week4.runSecondOptimalCountSegment());
		assertEquals("2 0 ", week4.runThirdOptimalCountSegment());
		
	}

	

}
