package tkpd.tokopedia.com.simpleretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tkpd.tokopedia.com.simpleretrofit.adapter.MoviesAdapter;
import tkpd.tokopedia.com.simpleretrofit.model.Movie;
import tkpd.tokopedia.com.simpleretrofit.webservice.ApiInterface;
import tkpd.tokopedia.com.simpleretrofit.webservice.ServiceGenerator;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movies = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_movie_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        moviesAdapter = new MoviesAdapter(this, movies);
        recyclerView.setAdapter(moviesAdapter);

        getMovies();
    }

    private void getMovies() {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<List<Movie>> call = apiInterface.getMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()){
                    for (Movie movie : response.body()){
                        movies.add(movie);
                    }
                    moviesAdapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
