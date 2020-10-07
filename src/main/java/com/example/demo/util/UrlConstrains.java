package com.example.demo.util;

public final  class UrlConstrains {
    public static final String API= "/api";
    public static  final String VERSION = "/v1";

    private UrlConstrains() { }
    public static final class BookManagement{
        public static final String FIND_BY_ISBN = "/isbn/{isbn}";
        public static final String FIND_BY_AUTHOR = "/author/{author}";

        private BookManagement() {
        }
        public static final String ROOT= API+VERSION+"/book";
        public static final String  CREATE ="/";
        public static final String FIND_BY_ID ="/{id}";
        public static final String UPDATE= "/{id}";
        public static final String ALL = "/books";
        public static final String DELETE = "/{id}";
    }
}
