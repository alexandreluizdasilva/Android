package br.com.alexandre.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*


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
        val produtosAdapter = ProdutoAdapter(this)

        produtosAdapter.addAll(produtosGlobal)

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

    override fun onResume() {
        super.onResume()
        val adapter = list_view_produtos.adapter as ProdutoAdapter

        adapter.clear()
        adapter.addAll(produtosGlobal)

        val soma = produtosGlobal.sumByDouble { it.valor * it.quantidade }

        val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        txt_total.text = "TOTAL: ${f.format(soma)}"
    }
}
