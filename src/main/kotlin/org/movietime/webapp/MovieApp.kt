package org.movietime.webapp

import org.movietime.webapp.resources.MovieResource
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

@ApplicationPath("/")
open class MovieApp: Application() {

    override fun getClasses(): Set<Class<*>> {
        // for more detailed resources, use classgraph
        return setOf(MovieResource::class.java)
    }
}