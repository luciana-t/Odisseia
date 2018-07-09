package br.trabalho221.odisseia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class AvaliarDisciplina extends AppCompatActivity {

    private Button btnSubmeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliar_disciplina);
        setTitle("AVALIAR DISCIPLINA");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSubmeter = (Button) findViewById(R.id.btnSubmeter);
        btnSubmeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Avaliacao avaliacao = new Avaliacao();

                avaliacao.id_disciplina = Integer.parseInt(getIntent().getStringExtra("IdMateria"));
                avaliacao.id_usuario = Placeholders.ID_USUARIO_LOGADO;

                if (((RadioButton) findViewById(R.id.radio1)).isChecked())
                    avaliacao.estrelas = 1;
                else if (((RadioButton) findViewById(R.id.radio1)).isChecked())
                    avaliacao.estrelas = 2;
                else if (((RadioButton) findViewById(R.id.radio1)).isChecked())
                    avaliacao.estrelas = 3;
                else if (((RadioButton) findViewById(R.id.radio1)).isChecked())
                    avaliacao.estrelas = 4;
                else
                    avaliacao.estrelas = 5;

                avaliacao.facilidade = ((ToggleButton) findViewById(R.id.btFacil)).isChecked();
                avaliacao.utilidade = ((ToggleButton) findViewById(R.id.btUtil)).isChecked();
                avaliacao.recomenda = ((ToggleButton) findViewById(R.id.btRecomendavel)).isChecked();
                avaliacao.comentario = ((EditText) findViewById(R.id.txtComent)).getText().toString();
                avaliacao.anonima = ((RadioButton) findViewById(R.id.radioAnonimo)).isChecked();
                avaliacao.professor = ((EditText) findViewById(R.id.txtProf)).getText().toString();
                avaliacao.visivel = true;
                avaliacao.validade = 0;

                DatabaseHelper.getInstance(AvaliarDisciplina.this).saveAvaliacao(avaliacao);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
