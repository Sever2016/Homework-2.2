package org.skypro.skyshop.search;

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
        return Arrays.copyOfRange(searchResult,0,counter);
    }

    public void add(Searchable newSearchable) {
        if (count == searchable.length) {
            return;
        }
        searchable[count] = newSearchable;
        count++;
    }
}
