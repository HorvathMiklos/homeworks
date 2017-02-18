package xyz.codingmentor.dbinit;

import javax.ejb.Singleton;
import javax.inject.Inject;
import xyz.codingmentor.model.MovieStar;
import xyz.codingmentor.model.Category;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.model.Trailer;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;

/**
 * @author mhorvath
 */
@Singleton
public class DbInit {

    @Inject
    @CRUDServiceQualifier(EntityModel.MOVIE)
    private CRUDService<Movie> movieService;

    @Inject
    @CRUDServiceQualifier(EntityModel.MOVIESTAR)
    private CRUDService<MovieStar> movieStarService;

    @Inject
    @CRUDServiceQualifier(EntityModel.CATEGORY)
    private CRUDService<Category> categoryService;

    @Inject
    @CRUDServiceQualifier(EntityModel.TRAILER)
    private CRUDService<Trailer> trailerService;

    public void init() {

        MovieStar ms1 = new MovieStar();
        ms1.setFirstName("Bud");
        ms1.setLastName("Spencer");
        ms1.setNationality("Italian");
        movieStarService.createEntity(ms1);

        
        MovieStar ms2 = new MovieStar();
        ms2.setFirstName("Terence");
        ms2.setLastName("Hill");
        ms2.setNationality("Italian");
        movieStarService.createEntity(ms2);
        

        MovieStar ms3 = new MovieStar();
        ms3.setFirstName("Alicia");
        ms3.setLastName("Vikander");
        ms3.setNationality("Swedish");
        movieStarService.createEntity(ms3);

        MovieStar ms4 = new MovieStar();
        ms4.setFirstName("Mark");
        ms4.setLastName("Hamill");
        ms4.setNationality("American");
        movieStarService.createEntity(ms4);

        MovieStar ms5 = new MovieStar();
        ms5.setFirstName("Harrison");
        ms5.setLastName("Ford");
        ms5.setNationality("English");
        movieStarService.createEntity(ms5);

        Category c1 = new Category();
        c1.setName("scifi");
        categoryService.createEntity(c1);

        Category c2 = new Category();
        c2.setName("comdedy");
        categoryService.createEntity(c2);

        Movie m1 = new Movie();
        m1.setTitle("Crime Busters");
        movieService.createEntity(m1);

        Movie m2 = new Movie();
        m2.setTitle("Ex Machina");
        movieService.createEntity(m2);

        Movie m3 = new Movie();
        m3.setTitle("Star Wars");
        movieService.createEntity(m3);   
        
        Trailer t1 = new Trailer();
        t1.setTitle("OFFICIAL Trailer - Star Wars");
        trailerService.createEntity(t1);

        Trailer t2 = new Trailer();
        t2.setTitle("Trailer2. - Star Wars");        
        trailerService.createEntity(t2);
                
        Trailer t3 = new Trailer();
        t3.setTitle("Exciting Trailer - Ex Machina");
        trailerService.createEntity(t3);
        
        joinMoviesAndMovieStars(1l, 1l);
        joinMoviesAndMovieStars(2l, 1l);
        joinMoviesAndMovieStars(3l, 2l);
        joinMoviesAndMovieStars(4l, 3l);
        joinMoviesAndMovieStars(5l, 5l);
        
        joinCategoryAndMovies(2l, 1l);
        joinCategoryAndMovies(1l, 2l);
        joinCategoryAndMovies(1l, 3l);
        
        joinTrailersAndMovie(1l, 3l);
        joinTrailersAndMovie(2l, 3l);
        
        joinTrailersAndMovie(3l, 2l);
        
    }

    private void joinMoviesAndMovieStars(Long movieStarId, Long movieId) {
        Movie movie = movieService.getEntity(movieId);
        MovieStar movieStar = movieStarService.getEntity(movieStarId);
        
        movieStar.getMovies().add(movie);
        movieStarService.updateEntity(movieStar);
    }

    private void joinCategoryAndMovies(Long categoryId, Long movieId) {
        Movie movie = movieService.getEntity(movieId);
        Category category = categoryService.getEntity(categoryId);
        
        movie.setCategory(category);
        category.getMovies().add(movie);
        
        movieService.updateEntity(movie);
        categoryService.updateEntity(category);
    }

    private void joinTrailersAndMovie(Long trailerId, Long movieId) {
        Movie movie = movieService.getEntity(movieId);
        Trailer trailer = trailerService.getEntity(trailerId);
        
        movie.getTrailers().add(trailer);
        trailer.setMovie(movie);
        
        trailerService.updateEntity(trailer);
        movieService.updateEntity(movie);
    }

}
