package data.repository

import data.model.room.entities.lista
import data.model.room.entities.listaDeListas

interface repositoryRoom {

    //   crud lista
    suspend fun nuevaLista(nombre:String,contenido:String,imagenPath:Int,backgroundPath:Int,fecha: String,pass:String):Boolean
    suspend fun eliminarListaPorID(identificador:Int):Boolean
    suspend fun modificarListaPorID(identificador:Int,nombre:String,contenido:String,imagenPath:Int,backgroundPath:Int,fecha: String,pass:String):Boolean
    suspend fun mostrarLista(id:Int):lista

    //  crud lista de listas
    suspend fun mostrarListas():List<listaDeListas>
    suspend fun eliminarListadeListas(identificador:Int)
    suspend fun agregarListadeListas(titulo:String,imagenPath :Int,backgroundPath:Int): Boolean
    suspend fun modificarListadeListas(identificador: Int,titulo:String,imagenPath :Int,backgroundPath:Int): Boolean
}