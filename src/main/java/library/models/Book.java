package library.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="genre")
    private String genre;
    @Column(name="publisher")
    private String publisher;
    @Column(name="publisher_year")
    private int publisherYear;
    @Column(name="number_of_pages")
    private int numberOfPages;
    @Column(name="synopsis")
    private String synopsis;
    @Column(name="language")
    private String language;
    @Column(name="availability")
    private Boolean availability;
    @Column(name="acquisition_date")
    private Date acquisitionDate;
    @Column(name="url_cover_image")
    private String urlCoverImage;
    @Column(name="copy")
    private String copy;

    @ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
    @JoinColumn (name = "id_library")
    private Library library;
}
