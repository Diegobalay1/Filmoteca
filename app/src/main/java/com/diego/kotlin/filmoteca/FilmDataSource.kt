package com.diego.kotlin.filmoteca

/**
 * Nos proporciona acceso al listado de películas
 */
object FilmDataSource {
    val films: MutableList<Film> = mutableListOf()
    var f = Film()


    init {
        f.title = "Mi Película"
        f.director = "Diego L. Ortiz"
        f.imageResId = R.mipmap.ic_launcher
        f.comments = ""
        f.format = Film.FORMAT_DIGITAL
        f.genre = Film.GENRE_SCIFI
        f.imdbUrl = "http://www.imdb.com/title/tt0088763"
        f.year = 1985
        films.add(f)
        regresoAlFuturo()
        regresoAlFuturo2()
        regresoAlFuturo3()
        losCazaFantasmas()
    }

    fun regresoAlFuturo() {
        f = Film()
        f.title = "Regreso al futuro"
        f.director = "Robert Zemeckis"
        f.imageResId = R.drawable.regreso_al_futuro
        f.comments = ""
        f.format = Film.FORMAT_DIGITAL
        f.genre = Film.GENRE_SCIFI
        f.imdbUrl = "http://www.imdb.com/title/tt0088763"
        f.year = 1985
        films.add(f)
    }
    fun regresoAlFuturo2() {
        f = Film()
        f.title = "Regreso al futuro II"
        f.director = "Robert Zemeckis"
        f.imageResId = R.drawable.regreso_al_futuro
        f.comments = ""
        f.format = Film.FORMAT_DIGITAL
        f.genre = Film.GENRE_SCIFI
        f.imdbUrl = "http://www.imdb.com/title/tt0096874"
        f.year = 1989
        films.add(f)
    }
    fun regresoAlFuturo3() {
        f = Film()
        f.title = "Regreso al futuro III"
        f.director = "Robert Zemeckis"
        f.imageResId = R.drawable.regreso_al_futuro
        f.comments = ""
        f.format = Film.FORMAT_DIGITAL
        f.genre = Film.GENRE_SCIFI
        f.imdbUrl = "http://www.imdb.com/title/tt0099088"
        f.year = 1990
        films.add(f)
    }
    fun losCazaFantasmas() {
        f = Film()
        f.title = "Los cazafantasmas"
        f.director = "Ivan Reitman"
        f.imageResId = R.mipmap.ic_launcher
        f.comments = ""
        f.format = Film.FORMAT_DIGITAL
        f.genre = Film.GENRE_COMEDY
        f.imdbUrl = "http://www.imdb.com/title/tt0087332"
        f.year = 1984
        films.add(f)
    }
}