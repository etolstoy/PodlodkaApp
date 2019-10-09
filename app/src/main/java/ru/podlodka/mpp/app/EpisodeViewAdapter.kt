package ru.podlodka.mpp.app

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.episode_list_recyclerview_row.view.*
import podlodka.mpp.model.Episode

class EpisodeViewAdapter(private val episodes: List<Episode>) :
    RecyclerView.Adapter<EpisodeViewAdapter.EpisodeHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EpisodeViewAdapter.EpisodeHolder {
        var inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.episode_list_recyclerview_row, parent, false)
        return EpisodeHolder(inflatedView)
    }

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: EpisodeViewAdapter.EpisodeHolder, position: Int) {
        val episode = episodes[position]
        holder.bindEpisode(episode)
    }

    class EpisodeHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var episode: Episode? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        companion object {
            private val EPISODE_KEY = "EPISODE"
        }

        fun bindEpisode(episode: Episode) {
            this.episode = episode
            view.episodeName.text = episode.name
        }
    }
}