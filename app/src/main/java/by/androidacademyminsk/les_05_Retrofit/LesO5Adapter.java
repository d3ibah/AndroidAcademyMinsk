package by.androidacademyminsk.les_05_Retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import by.androidacademyminsk.R;
import by.androidacademyminsk.les_05_Retrofit.entity.films.Films;
import by.androidacademyminsk.les_05_Retrofit.entity.films.SearchItem;

public class LesO5Adapter extends RecyclerView.Adapter<LesO5Adapter.Les05ViewHolder> {

    private Films films;
    private ClickListener listener;

    public LesO5Adapter(Films films) {
        this.films = films;
    }

    interface ClickListener {
        void onClick(int position);
    }

    public String getFilmTitle(int position) {
        return films.getSearch().get(position).getTitle();
    }

    @NonNull
    @Override
    public Les05ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.activity_lesson05_network_item, parent, false);
        return new Les05ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Les05ViewHolder holder, int position) {
        SearchItem film = films.getSearch()
                               .get(position);

        Glide.with(holder.itemView.getContext())
             .load(film.getPoster())
             .into(holder.ivPreview);
    }

    @Override
    public int getItemCount() {
        return films.getSearch()
                    .size();
    }

    public class Les05ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPreview;

        public Les05ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPreview = itemView.findViewById(R.id.iv_item);
        }
    }
}
