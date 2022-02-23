package cn.tyrone.java.example.java8.optional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    @Test
    public void enptyTest(){
        Optional<Object> empty = Optional.empty();
        System.out.printf("Optional.empty():" + empty.isPresent());
    }


    /**
     * 如果在这个Optional中包含这个值，返回值，
     * 否则抛出异常：NoSuchElementException
     */
    @Test
    public void getTest(){

//        Optional<String> os = Optional.ofNullable(null);
//        String s = os.get();

        List<Object> objects = Arrays.asList();
        Optional<List<Object>> objectsO = Optional.ofNullable(objects);
        List<Object> objects1 = objectsO.get();
        System.out.printf("" + objects1);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        Optional<List<Integer>> integers1 = Optional.ofNullable(integers);
        System.out.println("Arrays.asList(1, 2, 3):" + integers1.get());

    }

    /**
     * 如果值存在则方法会返回true，否则返回 false。
     */
    @Test
    public void isPresentTest(){

        Optional<String> os = Optional.ofNullable(null);
        System.out.println("Optional.ofNullable(null):" + os.isPresent());

        Optional<String> s = Optional.ofNullable("");
        System.out.println("Optional.ofNullable(\"\"):" + s.isPresent());

        List<Object> objects = Arrays.asList();
        Optional<List<Object>> objectsO = Optional.ofNullable(objects);
        System.out.println("Arrays.asList():" + objectsO.isPresent());

        List<Integer> integers = Arrays.asList(1, 2, 3);
        Optional<List<Integer>> integers1 = Optional.ofNullable(integers);
        System.out.println("Arrays.asList(1, 2, 3):" + integers1.isPresent());

    }

}
