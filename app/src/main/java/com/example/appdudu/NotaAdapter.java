package com.example.appdudu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NotaAdapter extends ArrayAdapter<Nota> {

    public NotaAdapter(Context context, ArrayList<Nota> notas) {
        super(context, 0, notas);
    }

    //monta cada linha da lista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lista, parent, false);
        }

        Nota nota = getItem(position);

        TextView txTitulo = convertView.findViewById(R.id.txTitulo);
        TextView txTexto = convertView.findViewById(R.id.txTexto);

        txTitulo.setText(nota.getId() + " - " + nota.getTitulo());
        txTexto.setText(nota.getTexto());

        return convertView;
    }
}