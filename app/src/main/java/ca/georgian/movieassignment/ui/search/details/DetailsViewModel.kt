package ca.georgian.movieassignment.ui.search.details

class DetailsViewModel
{private val repository = MovieRepository()

    fun loadMovieDetails(imdbID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getMovieDetails(imdbID)
            _movie.postValue(result)
        }
    }

}