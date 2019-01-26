package com.example.blind.miwok2;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){

        super(context, 0,words);
        mColorResourceId = colorResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Revisa si hay una vista, sino la "infla" para que los fragmentos puedan ser usados
        // Por el tipo de archivo


        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Consigue la posicion del item seleccionado
        Word currentWord = getItem(position);

        // Encuentra la vista de texto en la lista de items por el id para definir el texto en el
        // idoma Miwok
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Encuentra la vista de texto en la lista de items por el id para definir el texto en el
        // idoma Ingles
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Encuentra la vista de texto en la lista de item y verifica si tiene una imagen
        // dependiendo de la variante agarra o no la imagen
        ImageView defaultImageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {

            defaultImageView.setImageResource(currentWord.getImageResourceId());
            defaultImageView.setVisibility(View.VISIBLE);

        } else {
          // Sino encuentra la imagen desaparece el objeto de la vista como si no existiera
            defaultImageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(),mColorResourceId);

        textContainer.setBackgroundColor(color);

        // Regresa los valores de los items de la lista
        // Para mostrarlos en la list view
        return listItemView;
    }
}
