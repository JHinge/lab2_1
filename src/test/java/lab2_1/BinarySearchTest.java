package lab2_1;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
        assertThat(searchResult.isFound(), equalTo(true));
        assertThat(key, equalTo(oneElementTab[searchResult.getPosition()]));
    }

    @Test
    public void shouldSayThatElementIsNotFoundAndIsInPositionOfIndexMinusOneIfTabLengthIsOne() {
        int key = 0;
        SearchResult searchResult = BinarySearch.search(key, oneElementTab);
        assertThat(false, equalTo(searchResult.isFound()));
        assertThat(-1, equalTo(searchResult.getPosition()));
    }

    @Test
    public void shouldSayThatFirstElementIsFoundIfTabLengthIsBiggerThanOne() {
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(key, equalTo(moreThanOneElementTab[searchResult.getPosition()]));
    }

    @Test
    public void shouldSayThatMiddleElementIsFoundIfTabLengthIsBiggerThanOne() {
        int key = 5;
        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(key, equalTo(moreThanOneElementTab[searchResult.getPosition()]));
    }

    @Test
    public void shouldSayThatLastElementIsFoundIfTabLengthIsBiggerThanOne() {
        int key = moreThanOneElementTab[moreThanOneElementTab.length - 1];
        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(key, equalTo(moreThanOneElementTab[searchResult.getPosition()]));
    }

    @Test
    public void shouldReturnMinusOneIfElementNotFoundAndTabLengthIsBiggerThanOne() {
        int key = -1;
        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertThat(false, equalTo(searchResult.isFound()));
        assertThat(-1, equalTo(searchResult.getPosition()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionWhenSequenceIsEmpty() {
        final int[] emptyTab = {};
        BinarySearch.search(0, emptyTab);
    }
}
