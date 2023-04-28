package com.example.semana4_3

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCamera=findViewById<TextView>(R.id.btCamera)

        btCamera.setOnClickListener(){
            //AQUI LAS CONSULTAS
            checkCameraPermision()

        }

    }
    private fun checkCameraPermision(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"PERMISO OTORGADO",Toast.LENGTH_LONG).show()
        }else{
            requestCameraPermission()
        }
    }
    private fun requestCameraPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.CAMERA)){
            Toast.makeText(this,"PERMISO RECHAZADO, HABILITE EL PERMISO MANUALMENTE",Toast.LENGTH_LONG).show()
        }else{
            //SOLICITAR PERMISO POR PRIMERA VEZ
            Toast.makeText(this,"SE SOLICITO PERMISO POR PRIMERA VEZ",Toast.LENGTH_LONG).show()
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CAMERA_REQUEST_CODE ->{
                if(grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"PERMISO OTORGADO POR EL USUARIO",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"PERMISO NEGADO",Toast.LENGTH_LONG).show()
                }
                return
            }

        }
    }
}