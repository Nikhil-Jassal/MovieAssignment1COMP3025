package ca.georgian.movieassignment.network

import java.net.HttpURLConnection
import java.net.URL

object ApiService {

    private const val BASE_URL = "https://www.omdbapi.com/"
    private const val API_KEY = "32f76feb"

    fun searchMovies(query: String): String {
        val urlString = "$BASE_URL?apikey=$API_KEY&s=${query.replace(" ", "+")}"
        return makeHttpRequest(urlString)
    }

    fun getMovieDetails(imdbID: String): String {
        val urlString = "$BASE_URL?apikey=$API_KEY&i=$imdbID"
        return makeHttpRequest(urlString)
    }

    private fun makeHttpRequest(urlString: String): String {
        val url = URL(urlString)
        val connection = url.openConnection() as HttpURLConnection

        return try {
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                connection.inputStream.bufferedReader().use { it.readText() }
            } else {
                ""
            }
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        } finally {
            connection.disconnect()
        }
    }
}
