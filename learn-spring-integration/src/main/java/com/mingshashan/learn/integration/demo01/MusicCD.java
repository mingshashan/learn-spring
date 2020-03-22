package com.mingshashan.learn.integration.demo01;

import java.math.BigDecimal;

/**
 * MusicCD
 *
 * @author jasonxu
 */
public class MusicCD extends Item{

    private String artist;

    public MusicCD(String title, String publisher, BigDecimal price, int yearPublished, String artist) {
        super(title, publisher, price, yearPublished);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MusicCD{");
        sb.append("artist='").append(artist).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", price=").append(price);
        sb.append(", yearPublished=").append(yearPublished);
        sb.append('}');
        return sb.toString();
    }
}
