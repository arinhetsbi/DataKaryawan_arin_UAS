package com.example.datakaryawan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datakaryawan.Adapter.EmployeAdapter
import com.example.datakaryawan.Model.Employe
import io.realm.Realm
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var EmployeAdapter : EmployeAdapter
    lateinit var realm : Realm
    val LayoutManage = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        btn_add.setOnClickListener {
            realm.beginTransaction()
            var count = 0
            realm.where(Employe::class.java).findAll().let {
                for(i in it){
                    count++
                }
            }
            try {
                var employe = realm.createObject(Employe::class.java)
                employe.setId(count+1)
                employe.setNamaKaryawan(et_namaKaryawan.text.toString())
                employe.setNip(et_Nip.text.toString())
                employe.setJabatan(et_Jabatan.text.toString())
                employe.setEmail(et_Email.text.toString())
                et_namaKaryawan.setText("")
                et_Nip.setText("")
                et_Jabatan.setText("")
                et_Email.setText("")
                realm.commitTransaction()
                getAllEmploye()
            }catch (e: RealmException){}
        }

        btn_update.setOnClickListener {
            realm.beginTransaction()
            realm.where(Employe::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.setNamaKaryawan(et_namaKaryawan.text.toString())
                it!!.setNip(et_Nip.text.toString())
                it!!.setJabatan(et_Jabatan.text.toString())
                it!!.setEmail(et_Email.text.toString())
            }
            realm.commitTransaction()
            getAllEmploye()
        }

        btn_delete.setOnClickListener {
            realm.beginTransaction()
            realm.where(Employe::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.deleteFromRealm()
            }
            realm.commitTransaction()
            getAllEmploye()
        }
    }

    private fun initView(){
        rv_karyawan.layoutManager = LayoutManage
        EmployeAdapter = EmployeAdapter(this)
        rv_karyawan.adapter = EmployeAdapter
        Realm.init(applicationContext)
        realm = Realm.getDefaultInstance()
    }
    private fun getAllEmploye(){
        realm.where(Employe::class.java).findAll().let {
            EmployeAdapter.setEmploye(it)
        }
    }
}