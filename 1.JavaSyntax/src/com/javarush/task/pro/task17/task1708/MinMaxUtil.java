package com.javarush.task.pro.task17.task1708;

public class MinMaxUtil {
    public static int min(int a, int b) {
        return Math.min(a,b);
    }

    public static int max(int a, int b, int c) {
        if(a>b && a>c) {return a;}
        else if(b>a && b>c) {return b;}
        else {return c;}
    }

    public static int max(int a, int b, int c, int d) {
        if(a>b && a>c && a>d) {return a;}
        else if(b>a && b>c && b>d) {return b;}
        else if(c>a && b<c && c>d) {return c;}
        else {return d;}
    }

    public static int max(int a, int b, int c, int d, int e) {
        if(a>b && a>c && a>d && a>e) {return a;}
        else if(b>a && b>c && b>d && b>e) {return b;}
        else if(c>a && b<c && c>d && c>e) {return c;}
        else if(d>a && b<d && e<d && c<d) {return d;}
        else {return e;}
    }

    public static int max(int a, int b) {
        return Math.max(a,b);
    }

    public static int min(int a, int b, int c) {
        if(a<b && a<c) {return a;}
        else if(b<a && b<c) {return b;}
        else {return c;}
    }

    public static int min(int a, int b, int c, int d) {
        if(a<b && a<c && a<d) {return a;}
        else if(b<a && b<c && b<d) {return b;}
        else if(c<a && b>c && c<d) {return c;}
        else {return d;}
    }

    public static int min(int a, int b, int c, int d, int e) {
        if(a<b && a<c && a<d && a<e) {return a;}
        else if(b<a && b<c && b<d && b<e) {return b;}
        else if(c<a && b>c && c<d && c<e) {return c;}
        else if(d<a && b>d && e>d && c>d) {return d;}
        else {return e;}
    }
}
