package co.com.rhonaldelgado.mercadolibre.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MLService {

    @Headers("Content-Type: application/json")
    @GET("search")
    Call<SearchResult> getMLSearchResult(@Query("q") String item);
}
