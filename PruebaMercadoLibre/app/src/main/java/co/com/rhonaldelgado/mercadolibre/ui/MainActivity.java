package co.com.rhonaldelgado.mercadolibre.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import co.com.rhonaldelgado.mercadolibre.R;
import co.com.rhonaldelgado.mercadolibre.constants.Constants;
import co.com.rhonaldelgado.mercadolibre.retrofit.Results;
import co.com.rhonaldelgado.mercadolibre.viewmodel.MeLiViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MeLiViewModel meLiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(this);
    }

    private void searchItem(){
        final ProgressDialog pd = new ProgressDialog(MainActivity.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setTitle("Buscando Articulos");
        pd.setMessage("Buscando.........");
        pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFD4D9D0")));
        pd.setIndeterminate(false);
        pd.show();

        EditText searchText = findViewById(R.id.searchText);
        String item = searchText.getText().toString();
        meLiViewModel = new ViewModelProvider(this).get(MeLiViewModel.class);
        meLiViewModel.deleteAllResults();
        meLiViewModel.getAllSearchData(item).observe(this, new Observer<List<Results>>() {
            @Override
            public void onChanged(List<Results> results) {
                meLiViewModel.insertAllResults(results);
                pd.dismiss();
                goToSearchResultActivity();

            }
        });
    }


    private void goToSearchResultActivity(){
        Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
        startActivityForResult(intent, Constants.SEARCH_RESULT_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.searchButton:
                searchItem();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
