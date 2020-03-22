package com.mingshashan.learn.integration.demo01;

import java.math.BigDecimal;

/**
 * Book
 *
 * @author jasonxu
 */
public class Book extends Item {

    public Book(final String title, final String publisher, final BigDecimal price, final int yearPublished, String author) {
        super(title, publisher, price, yearPublished);
        this.author = author;
    }

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("author='").append(author).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", price=").append(price);
        sb.append(", yearPublished=").append(yearPublished);
        sb.append('}');
        return sb.toString();
    }
}
