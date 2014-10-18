package com.example.eric.listagemclassificados;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 17/10/14.
 */
public class ExpendableListAdapter extends BaseExpandableListAdapter {
    private Activity activity;
    private List<CabecalhoClassificado> listaCabecalhosClassificados = new ArrayList<CabecalhoClassificado>();
    private LayoutInflater inflater;
    private static final int QUANTIDADE_DE_CORPOS_POR_CABECALHO = 1;

    public ExpendableListAdapter(Activity activity, List<Classificado> listaClassificados) {
        this.activity = activity;
        inflater = activity.getLayoutInflater();

        separarClassificados(listaClassificados);
    }

    public void separarClassificados(List<Classificado> listaClassificados) {
        for (Classificado classificado : listaClassificados) {
            CabecalhoClassificado cabecalho = new CabecalhoClassificado(classificado);
            CorpoClassificado corpo = new CorpoClassificado(classificado.getDescricao(), classificado.getImagem());
            cabecalho.setCorpoClassificado(corpo);
            listaCabecalhosClassificados.add(cabecalho);
        }
    }

    @Override
    public int getGroupCount() {
        return listaCabecalhosClassificados.size();
    }

    @Override
    public int getChildrenCount(int posicaoCabecalho) {
        return QUANTIDADE_DE_CORPOS_POR_CABECALHO;
    }

    @Override
    public Object getGroup(int posicaoCabecalho) {
        return listaCabecalhosClassificados.get(posicaoCabecalho);
    }

    @Override
    public Object getChild(int posicaoCabecalho, int posicaoCorpo)
    {
        return listaCabecalhosClassificados.get(posicaoCabecalho).getCorpoClassificado();
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int posicaoCabecalho, int posicaoCorpo) {
        return posicaoCorpo;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int posicaoCabecalho, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cabecalho_list_view, null);
        }
        CabecalhoClassificado cabecalho = (CabecalhoClassificado) getGroup(posicaoCabecalho);
        TextView titulo = (TextView) convertView.findViewById(R.id.tituloCabecalhoLista);
        TextView autor = (TextView) convertView.findViewById(R.id.autorCabecalhoLista);
        titulo.setText(cabecalho.getClassificado().getTitulo());
        autor.setText(cabecalho.getClassificado().getAutor().getNome());

        return convertView;
    }

    @Override
    public View getChildView(int posicaoCabecalho, int posicaoCorpo, boolean isUltimoItemCorpo, View convertView, ViewGroup parent) {
        final CorpoClassificado corpo = (CorpoClassificado) getChild(posicaoCabecalho, posicaoCorpo);
        TextView descricao;
        ImageView imagem;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list_view, null);
        }
        descricao = (TextView) convertView.findViewById(R.id.descricaoItemLista);
        descricao.setText(corpo.getDescricao());
        imagem = (ImageView) convertView.findViewById(R.id.imagemItemLista);
        imagem.setImageResource(R.drawable.ic_launcher);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, corpo.getDescricao(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
