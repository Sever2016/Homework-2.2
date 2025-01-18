package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.Arrays;

public class SearchEngine {

    private Searchable[] searchable;
    private int count;

    public SearchEngine(int size) {
        searchable = new Searchable[size];
        count = 0;
    }

    public Searchable[] search(String search) {
        int counter = 0;
        Searchable[] searchResult = new Searchable[5];

        for (int i = 0; i < count; i++) {
            if (counter == 5) {
                break;
            }
            if (searchable[i] != null && searchable[i].searchTerm().contains(search)) {
                searchResult[counter] = searchable[i];
                counter++;
            }
        }
        return Arrays.copyOfRange(searchResult, 0, counter);
    }

    public void add(Searchable newSearchable) {
        if (count == searchable.length) {
            return;
        }
        searchable[count] = newSearchable;
        count++;
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        int maxIndex = 0;
        int maxSearchResult = 0;
        int[] searchResult = new int[count];
        for (int i = 0; i < count; i++) {
            if (searchable[i] != null && searchable[i].searchTerm().contains(search)) {
                int counter = 0;
                int searchIndex = searchable[i].searchTerm().indexOf(search);
                while (searchIndex != -1) {
                    searchIndex = searchable[i].searchTerm().indexOf(search, searchIndex + search.length());
                    counter++;

                }
                searchResult[i] = counter;
                if (searchResult[i] > maxSearchResult) {
                    maxSearchResult = searchResult[i];
                    maxIndex = i;
                }
            }
        }
        if (maxSearchResult == 0) {
            throw new BestResultNotFound("По запросу: " + search + ", ничего не найдено");
        }
        return searchable[maxIndex];
    }
}
