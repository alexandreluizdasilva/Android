package br.com.alexandre.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //implementação do adaptador
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        //definindo o adaptador na lista
        list_view_produtos.adapter = produtosAdapter

        //definição do ouvinte no botão
        btn_inserir.setOnClickListener {
            val produto = txt_produto.text.toString()
            if (produto.isNotEmpty()) {

                //enviado o item pra lista
                produtosAdapter.add(produto)

                //limpando a caixa de texto
                txt_produto.text.clear()
            } else {
                txt_produto.error = "Preencha um valor!"
            }
        }
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
