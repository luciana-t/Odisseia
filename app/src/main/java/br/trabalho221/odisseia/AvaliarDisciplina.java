package br.trabalho221.odisseia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class AvaliarDisciplina extends AppCompatActivity {

    private Button btnSubmeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliar_disciplina);
        btnSubmeter = (Button) findViewById(R.id.btnSubmeter);
        btnSubmeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.utilidade = ((ToggleButton) findViewById(R.id.btUtil)).isChecked();
                avaliacao.recomenda = ((ToggleButton) findViewById(R.id.btRecomendavel)).isChecked();
                avaliacao.facilidade = ((ToggleButton) findViewById(R.id.btFacil)).isChecked();
                avaliacao.anonima = ((RadioButton) findViewById(R.id.radioAnonimo)).isChecked();



                Usuario usuario = new Usuario();
                usuario.curso = ((TextView)findViewById(R.id.txtComent)).getText().toString();
                DatabaseHelper.getInstance(AvaliarDisciplina.this).saveUsuario(usuario);
            }
        });
    }

}
