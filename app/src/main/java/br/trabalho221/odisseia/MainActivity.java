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
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListSubject> listSubjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*
        Usuario usuario = new Usuario();
        usuario.nome = "Xablau";
        usuario.curso = "Ciência da Computação";
        usuario.data_admissao = "01/01/1900";
        usuario.data_cadastro = "08/07/2018";

        DatabaseHelper.getInstance(this).saveUsuario(usuario);

        Disciplina disciplina = new Disciplina();
        disciplina.cod_disciplina = "INF110";
        disciplina.nome  = "Programação I";
        disciplina.facilidade = 0;
        disciplina.utilidade = 0;
        disciplina.recomendacao = 0;
        disciplina.estrelas = 0;

        DatabaseHelper.getInstance(this).saveDisciplina(disciplina);

        disciplina.cod_disciplina = "MAT140";
        disciplina.nome  = "Cáculo I";
        DatabaseHelper.getInstance(this).saveDisciplina(disciplina);

        disciplina.cod_disciplina = "INF213";
        disciplina.nome  = "Estrutura de Dados";
        DatabaseHelper.getInstance(this).saveDisciplina(disciplina);

        disciplina.cod_disciplina = "FIS201";
        disciplina.nome  = "Física I";
        DatabaseHelper.getInstance(this).saveDisciplina(disciplina);

        disciplina.cod_disciplina = "INF221";
        disciplina.nome  = "Engenharia de Software I";
        DatabaseHelper.getInstance(this).saveDisciplina(disciplina);

        disciplina.cod_disciplina = "FIS203";
        disciplina.nome  = "Física III";
        DatabaseHelper.getInstance(this).saveDisciplina(disciplina);
*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listSubjects = new ArrayList<>();

        List<Disciplina> disciplinas = DatabaseHelper.getInstance(this).getDisciplinas();

        for (Disciplina it : disciplinas) {
            ListSubject listSubject = new ListSubject(
                    it.id,
                    it.nome,
                    String.valueOf(it.estrelas)
            );
            listSubjects.add(listSubject);
        }

        adapter = new MySubjectAdapter(listSubjects, this);

        recyclerView.setAdapter(adapter);
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
