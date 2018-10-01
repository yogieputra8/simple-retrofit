package tkpd.tokopedia.com.simpleretrofit.webservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import tkpd.tokopedia.com.simpleretrofit.model.Movie;

public interface ApiInterface {
    @GET("films")
    Call<List<Movie>> getMovies();
}
