package co.com.rhonaldelgado.mercadolibre.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.com.rhonaldelgado.mercadolibre.R;
import co.com.rhonaldelgado.mercadolibre.db.entity.ResultEntity;

public class ResultRecyclerViewAdapter extends RecyclerView.Adapter<ResultRecyclerViewAdapter.ViewHolder> {

    private List<ResultEntity> results;
    private int layout;
    private static ResultRecyclerViewListener onClickListener;

    public ResultRecyclerViewAdapter(List<ResultEntity> results, int layout, ResultRecyclerViewListener listener) {
        this.results = results;
        this.layout = layout;
        this.onClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(results.get(position));
    }

    public interface ResultRecyclerViewListener{
        void itemOnClick(View v, int position);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setNuevosResultados(List<ResultEntity> newResult){
        this.results = newResult;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivThumb;
        private TextView tvTitle;
        private TextView tvId;
        private TextView tvPrice;
        private TextView tvCurrency;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumb = itemView.findViewById(R.id.ivThumb);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvId = itemView.findViewById(R.id.textViewId);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvCurrency = itemView.findViewById(R.id.tvCurrency);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.itemOnClick(view, getAdapterPosition());
                }
            });
        }

        private void bind(final ResultEntity re){
            this.tvTitle.setText(re.getTitle());
            this.tvId.setText(re.getId());
            this.tvCurrency.setText(re.getCurrency());
            this.tvPrice.setText(re.getPrice());
            Picasso.get().load(re.getThumbnail().replace("http", "https")).resize(200,200).centerCrop().into(this.ivThumb);
        }
    }
}
