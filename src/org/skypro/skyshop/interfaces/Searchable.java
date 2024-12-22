package org.skypro.skyshop.interfaces;

public interface Searchable {
    default String getStringRepresentation() {
        return "Имя " + this.searchTerm() + " - объекта — тип " + this.getTypeOfContent();
    }

    String getTypeOfContent();

    String searchTerm();

}
