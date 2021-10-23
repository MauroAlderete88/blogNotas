package data.model.room

import data.model.room.dao.listaDao
import data.model.room.dao.listaDeListasDao
import data.model.room.dao.pathImageDao
import data.model.room.entities.lista
import data.model.room.entities.listaDeListas
import data.model.room.entities.pathImage
import data.repository.repositoryRoom
import javax.inject.Inject


//A este se le inyecta la database y ejecuta el modelo. Todos los metodos con return, estos son usados por el interactor

class dataBaseProvider @Inject constructor() : repositoryRoom {

    @Inject
    lateinit var listaDao: listaDao
    @Inject
    lateinit var  listaDeListasDao: listaDeListasDao
    @Inject
    lateinit var  pathImageDao : pathImageDao


    override suspend fun nuevaLista(
        nombre: String,
        contenido: String,
        imagenPath: String,
        backgroundPath: String,
        fecha: String,
        pass: String
    ): Boolean {
        val resultado = listaDao.insertList(lista(
            0,
            nombre,
            contenido,
            imagenPath,
            backgroundPath,
            pass,
            fecha
        ))
        return !resultado.equals(-1)
    }

    override suspend fun eliminarListaPorID(lista: lista): Boolean {
          val resultado = listaDao.deleteList(lista)

        //Posible error debido a la no aclaracion en el dao.
            if (!resultado.equals(-1)){
              //  listaDeListasDao.delete()
            }

          return !resultado.equals(-1)
    }

    override suspend fun modificarListaPorID(lista: lista): Boolean {

        val resultado = listaDao.updateList(lista)

        //Posible error debido a la no aclaracion en el dao.
        if (!resultado.equals(-1)){
           // listaDeListasDao.update(id)
        }

        return !resultado.equals(-1)
    }

    override suspend fun agregarImagenes(pathImage: pathImage) {
        pathImageDao.insert(pathImage)
    }


    override suspend fun mostrarListas(): List<listaDeListas> {
         val resultado : List<listaDeListas> = listaDeListasDao.getListas()
         return resultado
    }

    override suspend fun mostrarLista(id: Int):lista{
         var lista = listaDao.buscarList(id)
         return lista
    }


}