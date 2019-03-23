package lab2_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

    private final int[] oneElementTab = {1};
    private final int[] moreThanOneElementTab = {1, 2, 3, 5, 7, 11, 13, 17};

    @Test
    public void shouldSayThatElementIsFoundAndIsInPositionOfIndexZeroIfTabLengthIsOne() {
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, oneElementTab);
        assertEquals(true, searchResult.isFound());
        assertEquals(key, oneElementTab[searchResult.getPosition()]);
    }

    @Test
    public void shouldSayThatElementIsNotFoundAndIsInPositionOfIndexMinusOneIfTabLengthIsOne() {
        int key = 0;
        SearchResult searchResult = BinarySearch.search(key, oneElementTab);
        assertEquals(false, searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void shouldSayThatFirstElementIsFoundIfTabLengthIsBiggerThanOne() {
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertEquals(true, searchResult.isFound());
        assertEquals(key, moreThanOneElementTab[searchResult.getPosition()]);
    }

    @Test
    public void shouldSayThatMiddleElementIsFoundIfTabLengthIsBiggerThanOne() {
        int key = 5;
        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertEquals(true, searchResult.isFound());
        assertEquals(key, moreThanOneElementTab[searchResult.getPosition()]);
    }

    @Test
    public void shouldSayThatLastElementIsFoundIfTabLengthIsBiggerThanOne() {
        int key = moreThanOneElementTab[moreThanOneElementTab.length - 1];
        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertEquals(true, searchResult.isFound());
        assertEquals(key, moreThanOneElementTab[searchResult.getPosition()]);
    }

    @Test
    public void shouldReturnMinusOneIfElementNotFoundAndTabLengthIsBiggerThanOne() {
        int key = -1;
        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertEquals(false, searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}
