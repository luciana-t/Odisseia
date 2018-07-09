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
            ListItem listItem = new ListItem(
            );
        }
  */
        /*
        for(int i=0;i<=10;i++){
            ListItem listItem = new ListItem(
                    "Mat " + (i+1),
                    "comentario generico"
            );
            listItems.add(listItem);
        }
        */

        adapter = new MyAdapter(listItems, this);

        recyclerView.setAdapter(adapter);
    }

    public void mudaTela(View view){
        Intent it = new Intent(this, AvaliarDisciplina.class);
        startActivity(it);
    }
}
