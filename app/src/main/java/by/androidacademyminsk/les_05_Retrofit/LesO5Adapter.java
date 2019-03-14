package by.androidacademyminsk.les_05_Retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import by.androidacademyminsk.R;
import by.androidacademyminsk.les_05_Retrofit.entity.Film;

public class LesO5Adapter extends RecyclerView.Adapter<LesO5Adapter.Les05ViewHolder> {

    private List<Film> filmList;

    public LesO5Adapter(List<Film> filmList) {
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public Les05ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lesson05_network_item,
                                                                 parent, false);
        return new Les05ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Les05ViewHolder holder, int position) {
        Film film = filmList.get(position);

        Glide.with(holder.itemView.getContext())
             .load(film.getPoster())
             .into(holder.ivPreview);
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public class Les05ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivPreview;

        public Les05ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPreview = itemView.findViewById(R.id.iv_item);
        }
    }
}
