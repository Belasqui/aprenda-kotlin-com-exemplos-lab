enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(
val nome: String, 
val email: String
)

data class ConteudoEducacional(
val nome: String, 
val duracao: Int = 60,
val professor: String
)

data class Formacao(
val nome: String, 
val nivel: Nivel,
val conteudos: MutableList<ConteudoEducacional> = mutableListOf()
) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)

         println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

      fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo '${conteudo.nome}' adicionado à formação $nome.")
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
        println("Conteúdo '${conteudo.nome}' removido da formação $nome.")
    }
    
    fun exibirDetalhes() {
        println("Conteúdos:")
        for (conteudo in conteudos) {
            println(" - ${conteudo.nome} (${conteudo.duracao} horas) - (por ${conteudo.professor})")
        }
        println("Inscritos:")
        for (inscrito in inscritos) {
            println(" - ${inscrito.nome} (${inscrito.email})")
        }
    }
  }


fun main(){

    val usuario1 = Usuario("Bruna", "bruna@blablabla")
    val usuario2 = Usuario("Rita", "rita@blablabla")

    val conteudo1 = ConteudoEducacional("kotlin 1", 60, "Professor Fulano")
    val conteudo2 = ConteudoEducacional("Git 1", 30, "Professor Cicrano")
    val conteudo3 = ConteudoEducacional("kotlin 2", 30, "Professor Cicrano")
    
    val listaConteudos = mutableListOf(conteudo1, conteudo2, conteudo3)


    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.BASICO, listaConteudos)
    formacaoKotlin.adicionarConteudo(conteudo1)

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    formacaoKotlin.exibirDetalhes()
}