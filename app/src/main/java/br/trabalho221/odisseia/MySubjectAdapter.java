/*package br.trabalho221.odisseia;

public class MySubjectAdapter {
}
*/
package br.trabalho221.odisseia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MySubjectAdapter extends RecyclerView.Adapter<MySubjectAdapter.ViewHolder> {

    private List<ListSubject> listSubjects;
    private Context context;

    public MySubjectAdapter(List<ListSubject> listSubjects, Context context) {
        this.listSubjects = listSubjects;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_materia, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ListSubject listSubject = listSubjects.get(position);
        if(position%2!=0){
            holder.card.setBackgroundResource(R.color.cinzaClaro);
        }

        holder.infoMateriaCard.setText(listSubject.getMateria());
        holder.notaCard.setText(listSubject.getNota());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(holder.itemView.getContext(), pagComentDisciplinas.class);
                it.putExtra("Materia",  ((TextView) view.findViewById(R.id.infoMateriaCard)).getText().toString());
                it.putExtra("Nota",  ((TextView) view.findViewById(R.id.notaCard)).getText().toString());
                holder.itemView.getContext().startActivity(it);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listSubjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView infoMateriaCard;
        public TextView notaCard;
        public CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardMateria);
            infoMateriaCard = (TextView) itemView.findViewById(R.id.infoMateriaCard);
            notaCard =(TextView)itemView.findViewById(R.id.notaCard);
        }
    }
}