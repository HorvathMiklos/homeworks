package xyz.codingmentor.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author mhorvath
 */
@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Trailer> trailers;

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.PERSIST)
    private List<MovieStar> movieStars;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    public Movie() {
        movieStars = new LinkedList<>();
        trailers = new LinkedList<>();
    }

    public void setMovieStars(List<MovieStar> movieStar) {
        this.movieStars = movieStar;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @XmlTransient
    public List<Trailer> getTrailers() {
        return trailers;
    }

    @XmlTransient
    public List<MovieStar> getMovieStars() {
        return movieStars;
    }

}
