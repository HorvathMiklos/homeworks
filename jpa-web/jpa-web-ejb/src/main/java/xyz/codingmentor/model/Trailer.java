package xyz.codingmentor.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author mhorvath
 */
@Entity
public class Trailer implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;

    @Enumerated(EnumType.STRING)
    private TrailerTypes type;

    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Movie movie;

    public Trailer() {
        //empty on purpose
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public TrailerTypes getType() {
        return type;
    }

    public void setType(TrailerTypes type) {
        this.type = type;
    }

    public Date getPublished() {
        return publishDate;
    }

    public void setPublished(Date published) {
        this.publishDate = published;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
