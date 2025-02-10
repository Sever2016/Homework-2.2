package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.*;

public class SearchEngine {

    private Map<String, Searchable> searchable;

    public SearchEngine() {
        searchable = new HashMap<>();
    }

    public TreeMap<String, Searchable> search(String search) {
        TreeMap<String, Searchable> searchResult = new TreeMap<>();
        for (Searchable searchable1 : searchable.values()) {
            if (searchable1 != null && searchable1.searchTerm().contains(search)) {
                searchResult.put(searchable1.searchTerm(), searchable1);
            }
        }
        return searchResult;
    }

    public void add(Searchable newSearchable) {
        if (newSearchable != null) {
            searchable.put(newSearchable.searchTerm(), newSearchable);
        }
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable maxSearchable = null;
        int searchResult = 0;
        for (Searchable searchable1 : searchable.values()) {
            if (searchable1 != null && searchable1.searchTerm().contains(search)) {
                int counter = 0;
                int searchIndex = searchable1.searchTerm().indexOf(search);
                while (searchIndex != -1) {
                    searchIndex = searchable1.searchTerm().indexOf(search, searchIndex + search.length());
                    counter++;
                }
                if (counter > searchResult) {
                    searchResult = counter;
                    maxSearchable = searchable1;
                }
            }
        }
        if (searchResult == 0) {
            throw new BestResultNotFound("По запросу: " + search + ", ничего не найдено");
        }
        return maxSearchable;
    }
}
