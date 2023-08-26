package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String tmp = null;
        while ((tmp = buffer.readLine()) != null) {
            Movie movie = MovieFactory.getMovie(tmp);
            if (movie == null) {
                break;
            }
            System.out.println(movie.getClass().getSimpleName());
        }
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;
            if (key.equals("soapOpera")) {
                movie = new SoapOpera();
            }

            if (key.equals("cartoon")) {
                movie = new Cartoon();
            }
            if (key.equals("thriller")) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}
