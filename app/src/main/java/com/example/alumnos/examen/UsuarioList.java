package com.example.alumnos.examen;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upeu.registro.bean.Usuario;


/**
 * Created by Alumnos on 18/04/2017.
 */

public class UsuarioListAdapter extends ArrayAdapter<Usuario> {
    private Context contextGeneral;

    private class ViewHolder{
        TextView name;
        TextView lastNames;
        TextView usuario;
        TextView clave;

    }

    public UsuarioListAdapter(Context context, List<Usuario> rowItem) {
        super(context, R.layout.list_usuario, rowItem);
    }

    public View getView(int position, View contentView, ViewGroup parent){
        Usuario usuario = getItem(position);

        ViewHolder viewHolder;
        if(contentView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.list_usuario,null);
            viewHolder.name = (TextView)contentView.findViewById(R.id.name);
            viewHolder.lastNames = (TextView)contentView.findViewById(R.id.lastNames);
            viewHolder.usuario = (TextView)contentView.findViewById(R.id.usuario);
            viewHolder.clave = (TextView)contentView.findViewById(R.id.clave);
            contentView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)contentView.getTag();
        }
        viewHolder.name.setText(usuario.getName());
        viewHolder.lastNames.setText(usuario.getLastNames());
        viewHolder.usuario.setText(usuario.getUsuario());
        viewHolder.clave.setText(usuario.getClave());

        return contentView;
    }
}
