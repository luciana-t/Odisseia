package br.trabalho221.odisseia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DatabaseHelper myDb;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListSubject> listSubjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //edit_Materia = (EditText)findViewById(R.id.editMateria);
        /*
        edit_Professor = (EditText)findViewById(R.id.editProfessor);
        edit_Status = (EditText)findViewById(R.id.editStatus);
        edit_Ponto = (EditText)findViewById(R.id.editPonto);
        edit_Util = (EditText)findViewById(R.id.editUtil);
        edit_Facil = (EditText)findViewById(R.id.editFacil);
        edit_Recom = (EditText)findViewById(R.id.editRecom);
        edit_Coment = (EditText)findViewById(R.id.editComent);
        */
        //addbutton = (Button)findViewById(R.id.add_button);
        AddData();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //inicio cod gabriel
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listSubjects = new ArrayList<>();

        for(int i=0;i<=10;i++){
            ListSubject listSubject = new ListSubject(
                    "Mat " + (i+1),
                    "5"
            );
            listSubjects.add(listSubject);
        }

        adapter = new MySubjectAdapter(listSubjects, this);

        recyclerView.setAdapter(adapter);
//final cof gabriel
    }

    public void AddData(){
        /*
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Usuario usuario = new Usuario();
                usuario.nome = "Lulu";
                usuario.curso = "CCP";
                usuario.data_admissao = "01/03/2015";
                usuario.data_cadastro = "08/07/2018";

                long id_usuario = myDb.saveUsuario(usuario);

                Disciplina disciplina = new Disciplina();
                disciplina.cod_disciplina = "INF123";
                disciplina.nome = "Xablau";
                disciplina.facilidade = 5;
                disciplina.utilidade = 29;
                disciplina.recomendacao = 23;
                disciplina.estrelas = 5;

                long id_disciplina = myDb.saveDisciplina(disciplina);

                Avaliacao avaliacao = new Avaliacao();
                avaliacao.id_usuario = (int)id_usuario;
                avaliacao.id_disciplina = (int)id_disciplina;
                avaliacao.estrelas = 5;
                avaliacao.facilidade = true;
                avaliacao.utilidade = false;
                avaliacao.recomenda = true;
                avaliacao.comentario = "xablau";
                avaliacao.anonima = false;
                avaliacao.professor = "Nenell";
                avaliacao.visivel = true;
                avaliacao.validade = 123;

                long id_avaliacao = myDb.saveAvaliacao(avaliacao);

                Reacao reacao = new Reacao();
                reacao.id_usuario = (int)id_usuario;
                reacao.id_avaliacao = (int)id_avaliacao;
                reacao.conteudo = true;
                reacao.data = "08/07/2018";

                myDb.saveReacao(reacao);

                boolean isInserted = myDb.insertData(edit_Materia.getText().toString(),
                        edit_Professor.getText().toString(), edit_Status.getText().toString(),
                        edit_Ponto.getText().toString(), edit_Util.getText().toString(),
                        edit_Facil.getText().toString(), edit_Recom.getText().toString(),
                        edit_Coment.getText().toString());
                if (isInserted == true)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });
*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
