package com.masudinn.kade1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.masudinn.kade1.R
import com.masudinn.kade1.R.array.*
import com.masudinn.kade1.adapter.Football
import com.masudinn.kade1.model.LigaModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<LigaModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        recyclerview_liga.layoutManager = LinearLayoutManager(this)
        recyclerview_liga.adapter = Football(this, items) { itemClicked(it) }

    }

    private fun initData(){
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val description = resources.getStringArray(club_desc)
        items.clear()
        for (i in name.indices) {
            items.add(
                LigaModel(name[i],
                image.getResourceId(i, 0), description[i])
            )
        }

        //Recycle the typed array
        image.recycle()
    }

    private fun itemClicked(items : LigaModel) {
        startActivity<DetailActivity>(DetailActivity.TITLE to items.name, DetailActivity.IMAGE to items.image, DetailActivity.DESCRIPTION to items.description)
    }
}
