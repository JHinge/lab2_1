package lab2_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

    private final int[] oneElementTab = {1};

    @Test
    public void shouldSayThatElementIsFoundAndIsInPositionOfIndexZeroIfTabLengthIsOne() {
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, oneElementTab);
        assertEquals(true, searchResult.isFound());
        assertEquals(key, oneElementTab[searchResult.getPosition()]);
    }

}
