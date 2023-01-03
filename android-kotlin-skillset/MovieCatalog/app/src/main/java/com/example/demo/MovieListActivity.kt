package com.example.demo

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.models.Error
import com.example.demo.models.Movie
import com.example.demo.models.MovieGenre
import com.example.demo.models.MovieGenreResponse
import com.example.demo.models.MovieResponse
import com.example.demo.services.MovieApiInterface
import com.example.demo.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListActivity : BaseActivity() {

    private lateinit var genres: ArrayList<MovieGenre>
    private lateinit var movies: List<Movie>
    private lateinit var rvMovieList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        configureDropDown()
        configureRecycleView()
    }

    private fun configureDropDown() {
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        if (isNetworkAvailable(this))
        {
            getMovieGenreData { data: List<MovieGenre> ->
                genres = data as ArrayList<MovieGenre>
                val options = ArrayList<String>()
                for(genre in genres) {
                    genre.name?.let { options.add(it) }
                }
                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
                autocompleteTV.setAdapter(adapter)
            }

            autocompleteTV.onItemClickListener =
                AdapterView.OnItemClickListener { parent, _, position, _ ->
                    val item = parent.getItemAtPosition(position).toString()
                    var selectedGenre = genres.single { it.name == item }
                    var refreshedMovies = ArrayList<Movie>()
                    for (movie in movies) {
                        if(movie.genreIdList?.contains(selectedGenre.id) == true) {
                            refreshedMovies.add(movie)
                        }
                    }
                    rvMovieList.adapter = MovieAdapter(refreshedMovies)
                }
        } else
        {
            Toast.makeText(this@MovieListActivity, Error.NO_INTERNET.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun configureRecycleView() {
        rvMovieList = findViewById(R.id.rv_movies_list)
        rvMovieList.layoutManager = LinearLayoutManager(this)
        rvMovieList.setHasFixedSize(true)
        if (isNetworkAvailable(this))
        {
            getMovieData { data : List<Movie> ->
                movies = data
                rvMovieList.adapter = MovieAdapter(movies)
            }
        } else
        {
            Toast.makeText(this@MovieListActivity, Error.NO_INTERNET.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit)  {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@MovieListActivity, Error.NO_DATA.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                try {
                    return callback(response.body()!!.movies)
                } catch (exception: NullPointerException) {
                    Toast.makeText(this@MovieListActivity, Error.NULL_RESPONSE.toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun getMovieGenreData(callback: (List<MovieGenre>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieGenreList().enqueue(object : Callback<MovieGenreResponse> {
            override fun onFailure(call: Call<MovieGenreResponse>, t: Throwable) {
                Toast.makeText(this@MovieListActivity, Error.NO_DATA.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<MovieGenreResponse>, response: Response<MovieGenreResponse>) {
                try {
                    return callback(response.body()!!.genres)
                } catch (exception: NullPointerException) {
                    Toast.makeText(this@MovieListActivity, Error.NULL_RESPONSE.toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}