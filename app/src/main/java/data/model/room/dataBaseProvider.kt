package data.model.room

import data.model.room.dao.listaDao
import data.model.room.dao.listaDeListasDao
import data.model.room.entities.lista
import data.model.room.entities.listaDeListas
import data.repository.repositoryRoom
import javax.inject.Inject


//A este se le inyecta la database y ejecuta el modelo. Todos los metodos con return, estos son usados por el interactor

class dataBaseProvider @Inject constructor() : repositoryRoom {

    @Inject
    lateinit var listaDao: listaDao

    @Inject
    lateinit var listaDeListasDao: listaDeListasDao

    //TABLA LISTA

    override suspend fun nuevaLista(nombre: String, contenido: String, imagenPath: Int, backgroundPath: Int, fecha: String, pass: String): Boolean {
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
    override suspend fun eliminarListaPorID(identificador:Int): Boolean {
        val resultado = listaDao.deleteListById(identificador)
        return !resultado.equals(-1)
    }
    override suspend fun modificarListaPorID(identificador: Int, nombre: String, contenido: String, imagenPath: Int, backgroundPath: Int, fecha: String, pass: String): Boolean {
       val resultado = listaDao.modificarList(identificador,nombre, contenido, imagenPath, backgroundPath, fecha, pass)
        return !resultado.equals(-1)
    }
    override suspend fun mostrarLista(id: Int):lista {
        return listaDao.buscarList(id)
    }


    //TABLA LISTA DE LISTAS
    override suspend fun agregarListadeListas( titulo:String,imagenPath :Int,backgroundPath:Int):Boolean {
        val resultado = listaDeListasDao.insertLista(
                listaDeListas(
                        0,
                        titulo,
                        imagenPath,
                        backgroundPath
                )
        )
        return !resultado.equals(-1)
    }
    override suspend fun modificarListadeListas(identificador: Int, titulo: String, imagenPath: Int, backgroundPath: Int): Boolean {
       val resultado =  listaDeListasDao.update(identificador,titulo,imagenPath,backgroundPath)
        return !resultado.equals(-1)
    }
    override suspend fun eliminarListadeListas(identificador: Int)  {
           listaDeListasDao.deletelistadelistasById(identificador)
    }
    override suspend fun mostrarListas(): List<listaDeListas> {
         val resultado : List<listaDeListas> = listaDeListasDao.getListas()
         return resultado
    }




}