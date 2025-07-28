package ca.georgian.movieassignment.ui.search

class SearchViewModel
{private val repository = MovieRepository()

    fun search(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.searchMovies(query)
            _movies.postValue(result?.Search ?: emptyList())
        }
    }

}