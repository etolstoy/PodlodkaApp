package ru.podlodka.mpp.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import podlodka.module.episodeList.EpisodeListViewModel
import podlodka.mpp.model.Episode
import podlodka.mpp.service.EpisodeService
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = EpisodeListViewModel()

        viewModel.getEpisodes {
            for (episode in it) {
                println(episode.name)
            }
        }

    }
}
