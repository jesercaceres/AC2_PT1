package com.example.ac2pt1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2pt1.R;
import com.example.ac2pt1.model.Filme;

import java.util.List;

public class CatalogoAdapter extends RecyclerView.Adapter<CatalogoAdapter.FilmeViewHolder> {

    private List<Filme> filmes;
    private Context context;

    public CatalogoAdapter(List<Filme> filmes, Context context) {
        this.filmes = filmes;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.tituloTextView.setText(filme.getTitulo());
        holder.anoTextView.setText(String.valueOf(filme.getAno()));
        holder.diretorTextView.setText(filme.getDiretor());
        holder.imagemImageView.setImageResource(filme.getImagem());

        holder.verSinopseButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Sinopse");
            builder.setMessage(filme.getSinopse());
            builder.setPositiveButton("Fechar", (dialog, which) -> dialog.dismiss());
            builder.show();
        });
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder {
        TextView tituloTextView, anoTextView, diretorTextView;
        ImageView imagemImageView;
        Button verSinopseButton;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.tituloTextView);
            anoTextView = itemView.findViewById(R.id.anoTextView);
            diretorTextView = itemView.findViewById(R.id.diretorTextView);
            imagemImageView = itemView.findViewById(R.id.imagemImageView);
            verSinopseButton = itemView.findViewById(R.id.verSinopseButton);
        }
    }
}