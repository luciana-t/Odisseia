package br.trabalho221.odisseia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.res.ResourcesCompat;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper instance;

    public static final String DATABASE_NAME = "odissey.db";

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context.getApplicationContext());

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Usuario (id integer primary key autoincrement, nome text, curso text, data_admissao text, data_cadastro text)");
        db.execSQL("create table Disciplina (id integer primary key autoincrement, cod_disciplina text, nome text, facilidade integer, utilidade integer, recomendacao integer, estrelas integer)");
        db.execSQL("create table Avaliacao (id integer primary key autoincrement, id_usuario integer, id_disciplina integer, estrelas integer, facilidade integer, utilidade integer, recomenda integer, comentario text, anonima integer, professor text, visivel integer, validade integer, foreign key (id_usuario) references Usuario(id), foreign key (id_disciplina) references Disciplina(id))");
        db.execSQL("create table Reacao (id integer primary key autoincrement, id_usuario integer, id_avaliacao integer, conteudo integer, data text, foreign key (id_usuario) references Usuario(id), foreign key (id_avaliacao) references Avaliacao(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMENT);
        //onCreate(db);
    }

    public long saveUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", usuario.nome);
        contentValues.put("curso", usuario.curso);
        contentValues.put("data_admissao", usuario.data_admissao);
        contentValues.put("data_cadastro", usuario.data_cadastro);

        return db.insert("Usuario", null, contentValues);
    }

    public Usuario getUsuario(long id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("Usuario", new String[]{"*"}, "id = " + id, null, null, null, null);

        Usuario usuario = new Usuario();

        try {
            int id_index = cursor.getColumnIndexOrThrow("id");
            int nome_index = cursor.getColumnIndexOrThrow("nome");
            int curso_index = cursor.getColumnIndexOrThrow("curso");
            int dt_adm_index = cursor.getColumnIndexOrThrow("data_admissao");
            int dt_cdst_index = cursor.getColumnIndexOrThrow("data_cadastro");

            cursor.moveToFirst();
            usuario.id = (int) cursor.getLong(id_index);
            usuario.nome = cursor.getString(nome_index);
            usuario.curso = cursor.getString(curso_index);
            usuario.data_admissao = cursor.getString(dt_adm_index);
            usuario.data_cadastro = cursor.getString(dt_cdst_index);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean deleteUsuario(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Usuario", "id=?", new String[] { String.valueOf(id) }) > 0;
    }

    public long saveDisciplina(Disciplina disciplina) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("cod_disciplina", disciplina.cod_disciplina);
        contentValues.put("nome", disciplina.nome);
        contentValues.put("facilidade", disciplina.facilidade);
        contentValues.put("utilidade", disciplina.utilidade);
        contentValues.put("recomendacao", disciplina.recomendacao);
        contentValues.put("estrelas", disciplina.estrelas);

        return db.insert("Disciplina", null, contentValues);
    }

    public Disciplina getDisciplina(long id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("Disciplina", new String[]{"*"}, "id = " + id, null, null, null, null);

        Disciplina disciplina = new Disciplina();

        try {
            int id_index = cursor.getColumnIndexOrThrow("id");
            int cod_disciplina_index = cursor.getColumnIndexOrThrow("cod_disciplina");
            int nome_index = cursor.getColumnIndexOrThrow("nome");
            int facilidade_index = cursor.getColumnIndexOrThrow("facilidade");
            int utilidade_index = cursor.getColumnIndexOrThrow("utilidade");
            int recomendacao_index = cursor.getColumnIndexOrThrow("recomendacao");
            int estrelas_index = cursor.getColumnIndexOrThrow("estrelas");

            cursor.moveToFirst();
            disciplina.id = (int)cursor.getLong(id_index);
            disciplina.nome = cursor.getString(cod_disciplina_index);
            disciplina.facilidade = cursor.getInt(facilidade_index);
            disciplina.utilidade = cursor.getInt(utilidade_index);
            disciplina.recomendacao = cursor.getInt(recomendacao_index);
            disciplina.estrelas = cursor.getInt(estrelas_index);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return disciplina;
    }

    public boolean deleteDisciplina(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Disciplina", "id=?", new String[]{ String.valueOf(id) }) > 0;
    }

    public long saveAvaliacao(Avaliacao avaliacao) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("id_usuario", avaliacao.id_usuario);
        contentValues.put("id_disciplina", avaliacao.id_disciplina);
        contentValues.put("estrelas", avaliacao.estrelas);
        contentValues.put("facilidade", avaliacao.facilidade);
        contentValues.put("utilidade", avaliacao.utilidade);
        contentValues.put("recomenda", avaliacao.recomenda);
        contentValues.put("comentario", avaliacao.comentario);
        contentValues.put("anonima", avaliacao.anonima);
        contentValues.put("professor", avaliacao.professor);
        contentValues.put("visivel", avaliacao.visivel);
        contentValues.put("validade", avaliacao.validade);

        return db.insert("Avaliacao", null, contentValues);
    }

    public Avaliacao getAvaliacao(long id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("Avaliacao", new String[]{"*"}, "id = " + id, null, null, null, null);

        Avaliacao avaliacao = new Avaliacao();

        try {
            int id_index = cursor.getColumnIndexOrThrow("id");
            int id_usuario_index = cursor.getColumnIndexOrThrow("id_usuario");
            int id_disciplina_index = cursor.getColumnIndexOrThrow("id_disciplina");
            int nome_index = cursor.getColumnIndexOrThrow("id_disciplina");
            int estrelas_index = cursor.getColumnIndexOrThrow("estrelas");
            int facilidade_index = cursor.getColumnIndexOrThrow("facilidade");
            int utilidade_index = cursor.getColumnIndexOrThrow("utilidade");
            int recomenda_index = cursor.getColumnIndexOrThrow("recomenda");
            int comentario_index = cursor.getColumnIndexOrThrow("comentario");
            int anonima_index = cursor.getColumnIndexOrThrow("anonima");
            int professor_index = cursor.getColumnIndexOrThrow("professor");
            int visivel_index = cursor.getColumnIndexOrThrow("visivel");
            int validade_index = cursor.getColumnIndexOrThrow("validade");

            cursor.moveToFirst();
            avaliacao.id = (int)cursor.getLong(id_index);
            avaliacao.id_usuario = (int)cursor.getLong(id_usuario_index);
            avaliacao.id_disciplina = (int)cursor.getLong(facilidade_index);
            avaliacao.estrelas = cursor.getInt(utilidade_index);
            avaliacao.facilidade = cursor.getInt(facilidade_index) == 1 ? true : false;
            avaliacao.utilidade = cursor.getInt(utilidade_index) == 1 ? true : false;
            avaliacao.recomenda = cursor.getInt(recomenda_index) == 1 ? true : false;
            avaliacao.comentario = cursor.getString(comentario_index);
            avaliacao.anonima = cursor.getInt(anonima_index) == 1 ? true : false;
            avaliacao.professor = cursor.getString(professor_index);
            avaliacao.visivel = cursor.getInt(visivel_index) == 1 ? true : false;
            avaliacao.validade = cursor.getInt(validade_index);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return avaliacao;
    }

    public boolean deleteAvaliacao(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Avaliacao", "id=?", new String[] { String.valueOf(id) }) > 0;
    }

    public long saveReacao(Reacao reacao) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("id_usuario", reacao.id_usuario);
        contentValues.put("id_avaliacao", reacao.id_avaliacao);
        contentValues.put("conteudo", reacao.conteudo);
        contentValues.put("data", reacao.data);

        return db.insert("Reacao", null, contentValues);
    }

    public Reacao getReacao(long id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("Reacao", new String[]{"*"}, "id = " + id, null, null, null, null);

        Reacao reacao = new Reacao();

        try {
            int id_index = cursor.getColumnIndexOrThrow("id");
            int id_usuario_index = cursor.getColumnIndexOrThrow("id_usuario");
            int id_avaliacao_index = cursor.getColumnIndexOrThrow("id_avaliacao");
            int conteudo_index = cursor.getColumnIndexOrThrow("conteudo");
            int data_index = cursor.getColumnIndexOrThrow("data");

            cursor.moveToFirst();
            reacao.id = (int)cursor.getLong(id_index);
            reacao.id_usuario = (int)cursor.getLong(id_usuario_index);
            reacao.id_avaliacao = (int)cursor.getLong(id_avaliacao_index);
            reacao.conteudo = cursor.getInt(conteudo_index) == 1 ? true : false;
            reacao.data = cursor.getString(data_index);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return reacao;
    }

    public boolean deleteReacao(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Reacao", "id=?", new String[]{ String.valueOf(id) }) > 0;
    }
}
