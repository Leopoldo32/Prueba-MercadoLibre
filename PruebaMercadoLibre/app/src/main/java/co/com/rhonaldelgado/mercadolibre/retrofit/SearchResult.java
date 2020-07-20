package co.com.rhonaldelgado.mercadolibre.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class SearchResult {

    private List<Results> results;

    public SearchResult() {
    }

    public static Results parseJsonResults(String response) {
        Gson gson = new GsonBuilder().create();
        Results results = gson.fromJson(response, Results.class);
        return results;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}


