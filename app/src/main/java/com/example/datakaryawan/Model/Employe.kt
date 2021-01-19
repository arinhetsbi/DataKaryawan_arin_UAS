package com.example.datakaryawan.Model

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Employe: RealmObject() {

    private var id: Int=0
    private var namaKaryawan:String=""
    private var nip:String=""
    private var jabatan:String=""
    private var email:String=""

    fun setId(id:Int){
        this.id =id
    }
    fun getId():Int{
        return id
    }
    fun setNamaKaryawan(NamaKaryawan:String){
        this.namaKaryawan = NamaKaryawan
    }
    fun getNamaKaryawan():String{
        return namaKaryawan
    }
    fun setNip(Nip:String){
        this.nip=Nip
    }
    fun getNip():String{
        return nip
    }
    fun setJabatan(Jabatan : String){
        this.jabatan = Jabatan
    }
    fun  getJabatan ():String{
        return jabatan
    }
    fun setEmail(Email: String){
        this.email = Email
    }
    fun getEmail():String{
        return email
    }

}