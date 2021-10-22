package data.repository

import data.model.room.entities.lista
import data.model.room.entities.listaDeListas
import data.model.room.entities.pathImage

interface repositoryRoom {

    //   --->
    suspend fun nuevaLista(nombre:String,contenido:String,imagenPath:String,backgroundPath:String,fecha: String,pass:String):Boolean
    suspend fun eliminarListaPorID(lista: lista):Boolean
    suspend fun modificarListaPorID(lista: lista):Boolean


    //por unica vez
    suspend fun agregarImagenes(pathImage: pathImage)

    //  <---
    suspend fun mostrarListas():List<listaDeListas>
    suspend fun mostrarLista(id:Int):lista

}