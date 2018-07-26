package app.isfaaghyth.moviedb.ui.main.fragment.popular;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import app.isfaaghyth.moviedb.R;
import app.isfaaghyth.moviedb.adapter.MovieAdapter;
import app.isfaaghyth.moviedb.base.BaseFragment;
import app.isfaaghyth.moviedb.data.Movie;
import app.isfaaghyth.moviedb.data.MovieRepository;
import butterknife.BindView;

/**
 * Created by isfaaghyth on 7/26/18.
 * github: @isfaaghyth
 */

public class PopularFragment extends BaseFragment implements PopularView {

    @BindView(R.id.swipe_refresh) SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.lst_popular) RecyclerView lstPopular;

    private List<Movie> movies = new ArrayList<>();
    private MovieAdapter adapter;

    @Override public int contentView() {
        return R.layout.fragment_popular;
    }

    @Override public void onCreated(View view) {
        new PopularRequest(this).popular();
        lstPopular.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new MovieAdapter(movies);
        lstPopular.setAdapter(adapter);
    }

    @Override public void onSuccess(MovieRepository result) {
        movies.clear();
        movies.addAll(result.getResults());
        adapter.notifyDataSetChanged();

        //test
        for (Movie movie: result.getResults()) {
            Log.d("TAG", movie.getTitle());
        }
    }

    @Override public void onError(String message) {
        super.onError(message);
    }

}
