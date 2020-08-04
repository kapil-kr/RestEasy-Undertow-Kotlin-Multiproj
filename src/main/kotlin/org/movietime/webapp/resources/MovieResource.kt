package org.movietime.webapp.resources


import org.movietime.webapp.model.Movie
import org.movietime.webapp.services.MovieService
import javax.inject.Inject
import javax.inject.Named
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("movies")
internal open class MovieResource {

    @Inject
    private lateinit var movieService: MovieService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    open fun getMovies(): Movie {
        return movieService.getAllMovies()
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    open fun getMovie(@PathParam("id") id: Long = 0): Movie {
        return movieService.getMovie(id)
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    open fun setMovies() {

    }
}