package tkpd.tokopedia.com.simpleretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tkpd.tokopedia.com.simpleretrofit.R;
import tkpd.tokopedia.com.simpleretrofit.model.Movie;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private Context context;
    private List<Movie> movies;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Movie movie = movies.get(i);
        viewHolder.title.setText(movie.getTitle());
        viewHolder.director.setText(movie.getDirector());
        viewHolder.description.setText(movie.getDescription());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, director, description;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.movie_title);
            director = (TextView) itemView.findViewById(R.id.movie_director);
            description = (TextView) itemView.findViewById(R.id.movie_description);
        }
    }
}
