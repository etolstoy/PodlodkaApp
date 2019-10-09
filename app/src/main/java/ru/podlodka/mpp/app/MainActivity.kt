package ru.podlodka.mpp.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import podlodka.module.episodeList.EpisodeListViewModel
import podlodka.mpp.model.Episode

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: EpisodeViewAdapter
    var episodes = arrayListOf<Episode>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        adapter = EpisodeViewAdapter(episodes)
        recyclerView.adapter = adapter

        val viewModel = EpisodeListViewModel()

        viewModel.getEpisodes {
            runOnUiThread {
                episodes.addAll(it)
                adapter.notifyDataSetChanged()
            }

        }

    }
}
