package br.trabalho221.odisseia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PagComentDisciplinas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_coment_disciplinas);
        setTitle(getIntent().getStringExtra("Materia"));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        List<Avaliacao> avaliacoes = DatabaseHelper.getInstance(PagComentDisciplinas.this).getAvaliacoes();
/*
        for (Avaliacao it : avaliacoes) {
            int a = it.id_disciplina;
            int b = Integer.parseInt(getIntent().getStringExtra("IdMateria"));

            if (a == b) {
                ListItem listItem = new ListItem(
                        getIntent().getStringExtra("Materia"),
                        it.comentario
                );
                listItems.add(listItem);
            }
        }
*/
        listItems.add(new ListItem(
                "INF110",
                "Muito louco"
        ));
        listItems.add(new ListItem(
                "INF110",
                "Tomei pau"
        ));
        listItems.add(new ListItem(
                "INF110",
                "Tive pesadelos com Android e nem era a disciplina"
        ));
        listItems.add(new ListItem(
                "INF110",
                "Fiquei triste"
        ));
        listItems.add(new ListItem(
                "INF110",
                "Xablau"
        ));
        listItems.add(new ListItem(
                "INF110",
                "..."
        ));

        adapter = new MyAdapter(listItems, this);

        recyclerView.setAdapter(adapter);
    }

    public void mudaTela(View view){
        Intent it = new Intent(this, AvaliarDisciplina.class);
        it.putExtra("IdMateria", getIntent().getStringExtra("IdMateria"));
        startActivity(it);
    }
}
