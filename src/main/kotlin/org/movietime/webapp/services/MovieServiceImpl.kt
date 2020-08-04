package org.movietime.webapp.services

import org.movietime.webapp.model.Movie
import org.movietime.webapp.model.PlatformTypes
import java.time.LocalDate
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named

@ApplicationScoped
@Named
class MovieServiceImpl : MovieService {

    override fun getAllMovies(): Movie {
        val mve = Movie(1,"DDLJ", LocalDate.now(), PlatformTypes.MULTIPLEX)
        return mve
    }

    override fun getMovie(id: Long): Movie {
        TODO("Not yet implemented")
    }

    override fun setMovie(movie: Movie): Boolean {
        TODO("Not yet implemented")
    }
}