package by.androidacademyminsk.les_03_RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import by.androidacademyminsk.R;

public class Les03Adapter extends RecyclerView.Adapter<Les03Adapter.Les03ViewHolder> {

    private List<Actor> actorList = DataUri.generateActors();
    private ClickListener listener;

    public Les03Adapter(ClickListener listener) {
        this.listener = listener;
    }

    interface ClickListener {
        void onClick(int position);
    }

    public Actor getActorByPossition(int position){
        return actorList.get(position);
    }


    @NonNull
    @Override
    public Les03ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_lesson03__recycler_view_item, viewGroup, false);
        return new Les03ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Les03ViewHolder les03ViewHolder, final int position) {
        Actor actor = actorList.get(position);

        Glide.with(les03ViewHolder.itemView.getContext())
                .load(actor.getPreview())
                .into(les03ViewHolder.ivPreview);

        les03ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(position);
                Log.e("onClick", "position - " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public class Les03ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPreview;

        public Les03ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPreview = itemView.findViewById(R.id.iv_item);
        }
    }
}
