package br.com.alexandre.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //passagem de tela
        btn_adicionar.setOnClickListener {
            //Criando a Intent explícita
            val intent = Intent(this, CadastroActivity::class.java)

            //iniciando a atividade
            startActivity(intent)
        }

        //implementação do adaptador
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        //definindo o adaptador na lista
        list_view_produtos.adapter = produtosAdapter


            //removendo item da lista
            list_view_produtos.setOnItemLongClickListener { parent, view, position, id ->

                //buscando o item clicado
                val item = produtosAdapter.getItem(position)

                //removendo o item clicado da lista
                produtosAdapter.remove(item)

                //retorno indicando que o click foi realizado com sucesso
                true
            }
    }
}
