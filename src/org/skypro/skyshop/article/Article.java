package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Article article = (Article) obj;
        return Objects.equals(article.articleName, this.articleName);
    }

    @Override
    public int hashCode() {
        return this.articleName.hashCode();
    }

}
