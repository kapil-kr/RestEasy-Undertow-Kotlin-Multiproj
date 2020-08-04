package org.movietime.webapp.services

import org.movietime.webapp.model.Movie

interface MovieService {
    fun getAllMovies(): Movie
    fun getMovie(id: Long): Movie
    fun setMovie(movie: Movie): Boolean
}