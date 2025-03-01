package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searchable;

    public SearchEngine() {
        searchable = new HashSet<>();
    }

    public TreeSet<Searchable> search(String search) {
        return searchable.stream()
                .filter(Objects::nonNull)
                .filter(i -> i.searchTerm().contains(search))
                .collect(() -> new TreeSet<Searchable>(new SearchableComparator()), TreeSet<Searchable>::add, TreeSet<Searchable>::addAll);
    }

    public void add(Searchable newSearchable) {
        if (newSearchable != null) {
            searchable.add(newSearchable);
        }
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable maxSearchable = null;
        int searchResult = 0;
        for (Searchable searchable1 : searchable) {
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

    public static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            if (s2.getStringRepresentation().length() - s1.getStringRepresentation().length() != 0) {
                return s2.getStringRepresentation().length() - s1.getStringRepresentation().length();
            }
            return s1.getStringRepresentation().compareTo(s2.getStringRepresentation());
        }
    }
}
