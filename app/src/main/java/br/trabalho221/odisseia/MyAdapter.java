package br.trabalho221.odisseia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_comentario, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.infoComentCard.setText(listItem.getNomeDisciplina());
        holder.txtcomentCard.setText(listItem.getComentario());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView infoComentCard;
        public TextView txtcomentCard;

        public ViewHolder(View itemView) {
            super(itemView);

            infoComentCard = (TextView) itemView.findViewById(R.id.infoComentCard);
        }   txtcomentCard = (TextView) itemView.findViewById(R.id.txtcomentCard);
    }
}
