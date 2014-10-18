package com.example.eric.listagemclassificados;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ExpendableListAdapter listAdapter;
    ExpandableListView expandableListView;
    List<Classificado> listaClassificados = new ArrayList<Classificado>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        gerarClassificados();

        listAdapter = new ExpendableListAdapter(this, listaClassificados);
        expandableListView.setAdapter(listAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int posicaoCabecalho) {

            }
        });
    }

    public void gerarClassificados() {
        for (int vezes = 0; vezes < 5; vezes++) {
            Usuario autor = new Usuario();
            autor.setNome("Autor "+vezes);

            Imagem imagem = new Imagem();
            imagem.setCaminho(R.drawable.ic_launcher);

            String titulo = "Titulo "+vezes;
            String descricao = "Descrição ........... ............. ........... ................ .................. .................. ..................";


            Classificado classificado = new Classificado(titulo, autor, descricao, imagem);

            listaClassificados.add(classificado);
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
