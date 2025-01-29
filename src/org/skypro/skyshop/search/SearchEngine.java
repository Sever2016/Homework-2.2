package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.*;

public class SearchEngine {

    private LinkedList<Searchable> searchable;
    private int count;

    public SearchEngine() {
        searchable = new LinkedList<>();
        count = 0;
    }

    public List<Searchable> search(String search) {
        List<Searchable> searchResult = new LinkedList<>();
        for (Searchable searchable1 : searchable) {
            if (searchable1 != null && searchable1.searchTerm().contains(search)) {
                searchResult.add(searchable1);
            }
        }
        return searchResult;
    }

    public void add(Searchable newSearchable) {
        searchable.add(newSearchable);
        count++;
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        int maxIndex = 0;
        int searchResult = 0;
        for (int i = 0; i < count; i++) {
            if (searchable.get(i) != null && searchable.get(i).searchTerm().contains(search)) {
                int counter = 0;
                int searchIndex = searchable.get(i).searchTerm().indexOf(search);
                while (searchIndex != -1) {
                    searchIndex = searchable.get(i).searchTerm().indexOf(search, searchIndex + search.length());
                    counter++;

                }
                if (counter > searchResult) {
                    searchResult = counter;
                    maxIndex = i;
                }
            }
        }
        if (searchResult == 0) {
            throw new BestResultNotFound("По запросу: " + search + ", ничего не найдено");
        }
        return searchable.get(maxIndex);
    }
}
