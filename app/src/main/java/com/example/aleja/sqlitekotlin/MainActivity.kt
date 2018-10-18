package com.example.aleja.sqlitekotlin

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var admin : AdminSQLite ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        admin = AdminSQLite(this,"administracion", null, 1)

        crear.setOnClickListener{

            val bd = admin!!.writableDatabase
            val registro = ContentValues()
            registro.put("codigo", codigoAlumno.getText().toString())
            registro.put("nombre", nombre.getText().toString())
            registro.put("codigoCurso", codigoCurso.getText().toString())
            val i = bd.insert("alumnos", null, registro)
            bd.close()
            limpiarcampos()
            if ( i <= 0)
                Toast.makeText(this, "No se cargaron datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Se cargaron los datos del alumno", Toast.LENGTH_SHORT).show()

            Toast.makeText(this, "Se cargaron los datos del alumno", Toast.LENGTH_SHORT).show()
        }

        borrar.setOnClickListener{
            val bd = admin!!.writableDatabase
            val i = bd.delete("alumnos", "codigo=${codigoAlumno.text.toString()}", null)
            bd.close()
            limpiarcampos()
            if (i == 1)
                Toast.makeText(this, "Se borró el alumno con dicho código", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un alumno con dicho código", Toast.LENGTH_SHORT).show()
        }

        modificar.setOnClickListener{
            val bd = admin!!.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", nombre.text.toString())
            registro.put("codigoCurso", codigoCurso.text.toString())
            val cant = bd.update("alumnos", registro, "codigo=${codigoAlumno.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "no existe un alumno con el código ingresado", Toast.LENGTH_SHORT).show()
        }

        consultar.setOnClickListener{

            val bd = admin!!.writableDatabase
            val fila = bd.rawQuery("select nombre,codigoCurso from alumnos where codigo=${codigoAlumno.text.toString()}", null)
            if (fila.moveToFirst()) {
                nombre.setText(fila.getString(0))
                codigoCurso.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un alumno con dicho código",  Toast.LENGTH_SHORT).show()
            bd.close()
        }
    }

    fun limpiarcampos(){
        codigoAlumno.setText("")
        nombre.setText("")
        codigoCurso.setText("")
    }
}
