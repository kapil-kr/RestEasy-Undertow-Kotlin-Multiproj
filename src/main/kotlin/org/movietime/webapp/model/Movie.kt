package org.movietime.webapp.model

import java.time.LocalDate

enum class PlatformTypes {
    STREAMING, MULTIPLEX, SOCIAL, DRAMA
}

data class Movie(
    var id: Int,
    var name: String ="",
    var releaseDate: LocalDate,
    var platform: PlatformTypes = PlatformTypes.MULTIPLEX
) {}