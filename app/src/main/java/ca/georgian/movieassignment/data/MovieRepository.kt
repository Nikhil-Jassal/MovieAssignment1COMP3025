package ca.georgian.movieassignment.data

import ca.georgian.movieassignment.network.ApiService
import com.google.gson.Gson

class MovieRepository {

    private val gson = Gson()

    fun searchMovies(query: String): MovieSearchResult? {
        val response = ApiService.searchMovies(query)
        return gson.fromJson(response, MovieSearchResult::class.java)
    }

    fun getMovieDetails(imdbID: String): Movie? {
        val response = ApiService.getMovieDetails(imdbID)
        return gson.fromJson(response, Movie::class.java)
    }
}
