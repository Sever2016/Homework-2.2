package org.skypro.skyshop.search;

import org.skypro.skyshop.interfaces.Searchable;

public class SearchEngine {

    private Searchable[] searchable;
    private int count;

    public SearchEngine(int size) {
        searchable = new Searchable[size];
        count = 0;
    }

    public String[] search(String search) {
        Searchable[] intermediateSearchResult = new Searchable[5];
        int counter = 0;
        for (int i = 0; i < count; i++) {
            if (counter == 5) {
                break;
            }
            if (searchable[i] != null && searchable[i].searchTerm().contains(search)) {
                intermediateSearchResult[counter] = searchable[i];
                counter++;
            }
        }
        String[] searchResult = new String[counter];
        for (int i = 0; i < counter; i++) {
            searchResult[i] = intermediateSearchResult[i].getStringRepresentation();
        }
        return searchResult;
    }

    public void add(Searchable newSearchable) {
        if (count == searchable.length) {
            return;
        }
        searchable[count] = newSearchable;
        count++;
    }
}
