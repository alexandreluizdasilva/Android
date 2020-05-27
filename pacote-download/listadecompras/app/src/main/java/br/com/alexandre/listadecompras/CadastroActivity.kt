package br.com.alexandre.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        //definição do ouvinte no botão
        btn_inserir.setOnClickListener {
            val produto = txt_produto.text.toString()
            if (produto.isNotEmpty()) {

                //enviado o item pra lista


                //limpando a caixa de texto
                txt_produto.text.clear()
                txt_valor.text.clear()
                txt_qtd.text.clear()

            } else {
                txt_produto.error = "Preencha um valor!"
            }
        }
    }
}
