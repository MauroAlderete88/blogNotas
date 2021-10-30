package data.repository

import data.model.room.entities.lista
import data.model.room.entities.listaDeListas

interface repositoryRoom {

    //   --->
    suspend fun nuevaLista(nombre:String,contenido:String,imagenPath:Int,backgroundPath:Int,fecha: String,pass:String):Boolean
    suspend fun eliminarListaPorID(lista: lista):Boolean
    suspend fun modificarListaPorID(lista: lista):Boolean
    suspend fun agregarListadeListas(titulo:String,imagenPath :Int,backgroundPath:Int): Boolean
    //  <---
    suspend fun mostrarListas():List<listaDeListas>
    suspend fun mostrarLista(id:Int):lista

}