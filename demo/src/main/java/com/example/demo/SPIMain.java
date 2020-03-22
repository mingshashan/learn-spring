package com.example.demo;

import com.example.demo.service.IShout;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * SPIMain
 *
 * @author jasonxu
 */
public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);

        Iterator<IShout> shoutIterator = shouts.iterator();
        while (shoutIterator.hasNext()) {
            shoutIterator.next().shout();
        }
    }
}
