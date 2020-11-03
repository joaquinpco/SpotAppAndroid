package controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import akeen.app.SpotApp.R;
import model.firebase.FestivalesFb;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    private List<FestivalesFb> _aEvents;

    public EventsAdapter(List<FestivalesFb> aEvents)
    {
        _aEvents = aEvents;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FestivalesFb movie = _aEvents.get(position);
        holder.title.setText(movie.getName());
        holder.genre.setText(movie.getFecha());
    }

    @Override
    public int getItemCount() {
        return _aEvents.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
        }
    }
}
