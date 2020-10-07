package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Book extends BaseModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BOOK_ID", unique = true, nullable = false)
    private long bookId;

    @Column(name = "ISBN", nullable = false, unique = true)
    private String isbn;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "PUBLISHER", nullable = false)
    private String publisher;

    @Column(name = "YEAR_OF_PUBLICATION")
    private String year_of_publication;
    /**
     * Location of the book in library
     */
    @Column(name = "LOCATION")
    private String location;

    @Column(name = "NUM_OF_COPIES")
    private int num_of_copies;

    @Column(name = "CURRENT_STATUS")
    private String current_status;

    @Column(name = "KEYWORDS")
    private String keywords;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "LAST_AVAILABLE_DATE")
    private String last_available_date;

}
