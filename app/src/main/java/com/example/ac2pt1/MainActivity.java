package com.example.ac2pt1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ac2pt1.adapter.CatalogoAdapter;
import com.example.ac2pt1.model.Filme;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme("Piratas do Caribe", 2006, "Quando a cidade de Port Royal é atacada pela tripulação do navio pirata Pérola Negra, Elizabeth Swann, filha do governador da cidade, é sequestrada. Os piratas, liderados pelo Capitão Barbossa, estão tentando retirar uma maldição colocada sobre eles depois que eles roubaram um baú de ouro asteca.", " Espen Sandberg", R.drawable.piratasdocaribe3));
        filmes.add(new Filme("Senhor dos Anéis", 2003, "Sinopse. Numa terra fantástica e única, chamada Terra-Média, um hobbit (seres de estatura entre 80 cm e 1,20 m, com pés peludos e bochechas um pouco avermelhadas) recebe de presente de seu tio o Um Anel, um anel mágico e maligno que precisa ser destruído antes que caia nas mãos do mal.", "\n" +
                "Peter Jackson", R.drawable.senhordosaneis));
        filmes.add(new Filme("A entidade", 2016, "Um autor de romances criminais encontra uma caixa com filmagens antigas de crimes horripilantes, que parecem ter sido cometidos por um assassino em série. Ao investigar, ele e sua família se tornam alvos de uma entidade sobrenatural maligna.", "Scott Derrickson", R.drawable.entidade));

        CatalogoAdapter adapter = new CatalogoAdapter(filmes, this);
        recyclerView.setAdapter(adapter);
    }
}