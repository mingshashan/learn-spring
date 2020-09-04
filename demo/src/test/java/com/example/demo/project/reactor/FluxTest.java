package com.example.demo.project.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * FluxTest
 *
 * @author jasonxu
 */
public class FluxTest {

    @Test
    public void test01() {

        Flux<String> stringFlux = Flux.just("one", "two", "three");

        // subscribe with consumer
        System.out.println("example for subscribe with consumer");
        stringFlux.subscribe((item) -> System.out.println(item));

    }

    @Test
    public void testFromArray() {
        Flux<String> stringFlux = Flux.fromArray(new String[]{"one", "two", "trhee"});

        stringFlux.subscribe(System.out::println);
    }


    @Test
    public void testFromIterable() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Flux<String> stringFlux = Flux.fromIterable(list);

        stringFlux.subscribe(System.out::println);
    }

    @Test
    public void testFromStream() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        Stream<String> stringStream = list.stream();


        Flux<String> stringFlux = Flux.fromStream(stringStream);

        stringFlux.subscribe(System.out::println);
    }

    @Test
    public void testRange() {
        Flux.range(1, 10).subscribe(System.out::println);
        Flux.range(Integer.MAX_VALUE - 1, 6).subscribe(item -> System.out.printf(
                "%d\t", item
        ));
    }

    @Test
    public void testInterval() {

        Flux.interval(Duration.ofSeconds(1), Duration.ofSeconds(1))
                .subscribe(System.out::println);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
