package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

public final class Article implements Searchable {
    private String articleName;
    private String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    public String toString() {
        return this.articleName + "\n" + this.articleText;
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }

    @Override
    public String searchTerm() {
        return this.toString();
    }
}
