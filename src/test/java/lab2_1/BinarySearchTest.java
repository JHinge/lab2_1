package lab2_1;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

    @Test
    public void shouldSayThatElementIsFoundAndIsInPositionOfIndexZeroIfTabLengthIsOne() {
        int key = -100;
        int[] oneElementTab = {-100};

        SearchResult searchResult = BinarySearch.search(key, oneElementTab);
        assertThat(searchResult.isFound(), equalTo(true));
        assertThat(key, equalTo(oneElementTab[searchResult.getPosition()]));
    }

    @Test
    public void shouldSayThatElementIsNotFoundAndIsInPositionOfIndexMinusOneIfTabLengthIsOne() {
        int key = 0;
        int[] oneElementTab = {4100};

        SearchResult searchResult = BinarySearch.search(key, oneElementTab);
        assertThat(false, equalTo(searchResult.isFound()));
        assertThat(-1, equalTo(searchResult.getPosition()));
    }

    @Test
    public void shouldSayThatFirstElementIsFoundIfTabLengthIsBiggerThanOne() {
        int key = -12;
        int[] moreThanOneElementTab = {-12, -2, 3, 5, 7, 11, 13, 17};

        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(key, equalTo(moreThanOneElementTab[searchResult.getPosition()]));
    }

    @Test
    public void shouldSayThatMiddleElementIsFoundIfTabLengthIsBiggerThanOne() {
        int key = 5;

        int[] moreThanOneElementTab = {-90, 3411, -9, 5, 7, 141, 13, 17};
        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(key, equalTo(moreThanOneElementTab[searchResult.getPosition()]));
    }

    @Test
    public void shouldSayThatLastElementIsFoundIfTabLengthIsBiggerThanOne() {
        int[] moreThanOneElementTab = {-121, -12, 22, 311, 230, 5000, 719, 17000};
        int key = moreThanOneElementTab[moreThanOneElementTab.length - 1];

        SearchResult searchResult = BinarySearch.search(key, moreThanOneElementTab);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(key, equalTo(moreThanOneElementTab[searchResult.getPosition()]));
    }

    @Test
    public void shouldReturnMinusOneIfElementNotFoundAndTabLengthIsBiggerThanOne() {
        int key = -123424;
        int[] moreThanOneElementTab = {1, 2, 3, 6, 7, 11464, 13676, 17878};
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
