package co.com.rhonaldelgado.mercadolibre.ui;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.com.rhonaldelgado.mercadolibre.R;
import co.com.rhonaldelgado.mercadolibre.db.entity.ResultEntity;
import co.com.rhonaldelgado.mercadolibre.viewmodel.MeLiViewModel;

public class DetailProductActivity extends AppCompatActivity {

    private MeLiViewModel meLiViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.back3);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);



        meLiViewModel = new ViewModelProvider(this).get(MeLiViewModel.class);

        meLiViewModel.getDataById(getIntent().getIntExtra("idRoom", 0)).observe(this, new Observer<List<ResultEntity>>() {
            @Override
            public void onChanged(List<ResultEntity> resultEntities) {
                ImageView ivImage = findViewById(R.id.ivThumb);

                TextView tvId = findViewById(R.id.tvId);
                TextView tvCity = findViewById(R.id.tvCity);
                TextView tvCondition = findViewById(R.id.tvcondition);

                ResultEntity re = resultEntities.get(0);
                toolbar.setTitle(re.getTitle());
                collapsingToolbarLayout.setTitle(re.getTitle());
                collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(getBaseContext(), R.color.white));
                collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);

                tvId.setText(re.getId());
                tvCity.setText(re.getCity_name());
                tvCondition.setText(re.getCondition());

                Picasso.get().load(re.getThumbnail().replace("http","https")).resize(200, 200).centerCrop().into(ivImage);
            }

        });

    }

}

