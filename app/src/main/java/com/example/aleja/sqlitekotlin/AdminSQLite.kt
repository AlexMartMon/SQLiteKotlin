package com.example.aleja.sqlitekotlin

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

/*esta clase que tiene por objetivo administrar la base de datos que crearemos.
 *Primero hacemos que nuestra clase herede de la clase SQLiteOpenHelper e
* implementaremos sus dos métodos abstractos onCreate y onUpgrade:
* */
class AdminSQLite(context: Context, name: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    //Codificamos en el método onCreate la creación de la tabla alumnos con sus campos
    //nCreate se ejecutará una única vez
    //si se quiere modificar la estructura de la base de datos debemos hacerlo en el método onUpgrade.
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table alumnos(codigo int primary key, nombre text,codigoCurso int)")
        //db.execSQL("create table cursos(codigoCurso int primary key, nombreCurso text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}