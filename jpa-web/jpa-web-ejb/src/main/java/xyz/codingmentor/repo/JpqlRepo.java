package xyz.codingmentor.repo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.model.MovieStar;
import xyz.codingmentor.model.Trailer;

/**
 * @author mhorvath
 */
@Stateless
public class JpqlRepo {

    @PersistenceContext(unitName = "jpahwPU")
    private EntityManager entityManager;

    public List<Trailer> findTrailersForMovie(String movieTitle) {
        String selectQuery = "SELECT t FROM Trailer t INNER JOIN t.movie mov WHERE mov.title = :movieTitle ";
        TypedQuery<Trailer> query = entityManager.createQuery(selectQuery, Trailer.class);
        query.setParameter("movieTitle", movieTitle);
        return query.getResultList();
    }

    public List<MovieStar> findMovieStarsByNation(String nation) {
        String selectQuery = "SELECT ms FROM MovieStar ms WHERE ms.nationality = :nationality ";
        TypedQuery<MovieStar> query = entityManager.createQuery(selectQuery, MovieStar.class);
        query.setParameter("nationality", nation);
        return query.getResultList();
    }

    public List<Movie> findMovieTitleOrCategory(String title, Long categoryId) {
        if (null != title) {
            if (null != categoryId) {
                return findMovieTitleCategory(title, categoryId);
            }
            return findMoviesForTitle(title);
        }
        if (null != categoryId) {
            return findMoviesForCategory(categoryId);
        }
        throw new IllegalArgumentException("Need at least one query param!");
    }

    public List<MovieStar> findMovieStarTitleName(String movieTitle, String movieStarName) {
        if (null != movieTitle) {
            if (null != movieStarName) {
                return findMovieStarsForMovieOrName(movieTitle, movieStarName);
            }
            return findMovieStarForMovie(movieTitle);
        }
        if (null != movieStarName) {
            return findMovieStarsName(movieStarName);
        }
        throw new IllegalArgumentException("Need at least one query param!");
    }

    private List<Movie> findMoviesForTitle(String title) {

        String selectQuery = "SELECT mov FROM Movie mov WHERE mov.title = :title ";
        TypedQuery<Movie> query = entityManager.createQuery(selectQuery, Movie.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    private List<Movie> findMoviesForCategory(Long categoryId) {
        String selectQuery = "SELECT mov FROM Movie mov WHERE mov.category.id = :categoryId ";
        TypedQuery<Movie> query = entityManager.createQuery(selectQuery, Movie.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    private List<Movie> findMovieTitleCategory(String title, Long categoryId) {
        String selectQuery = "SELECT mov FROM Movie mov WHERE mov.title = :title AND mov.category.id = :categoryId ";
        TypedQuery<Movie> query = entityManager.createQuery(selectQuery, Movie.class);
        query.setParameter("title", title);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    private List<MovieStar> findMovieStarsName(String name) {
        String selectQuery = "SELECT ms FROM MovieStar ms WHERE ms.firstName = :firstName";
        TypedQuery<MovieStar> query = entityManager.createQuery(selectQuery, MovieStar.class);
        query.setParameter("firstName", name);
        return query.getResultList();
    }

    private List<MovieStar> findMovieStarForMovie(String movie) {
        String selectQuery = "SELECT distinct ms FROM MovieStar ms INNER JOIN ms.movies mov WHERE mov.title = :movie ";
        TypedQuery<MovieStar> query = entityManager.createQuery(selectQuery, MovieStar.class);
        query.setParameter("movie", movie);
        return query.getResultList();
    }

    private List<MovieStar> findMovieStarsForMovieOrName(String movie, String name) {
        String selectQuery = "SELECT distinct ms FROM MovieStar ms INNER JOIN ms.movies mov WHERE mov.title = :movie AND ms.firstName = :firstName";
        TypedQuery<MovieStar> query = entityManager.createQuery(selectQuery, MovieStar.class);
        query.setParameter("movie", movie);
        query.setParameter("firstName", name);
        return query.getResultList();
    }
}
