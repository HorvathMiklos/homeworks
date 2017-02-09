
package xyz.codingmentor.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author mhorvath
 */
@Entity
public class Movie implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    String title;
    @ManyToMany
    List<MovieStar> stars;
    @OneToMany
    List<Trailer> trailers;
    @ManyToMany
    List<Category> categories;

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieStar> getStars() {
        return stars;
    }

    public void setStars(List<MovieStar> stars) {
        this.stars = stars;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
}
