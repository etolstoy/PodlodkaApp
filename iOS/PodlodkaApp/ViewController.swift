//
//  ViewController.swift
//  PodlodkaApp
//
//  Created by eetolstoy on 29/08/2019.
//  Copyright © 2019 eetolstoy. All rights reserved.
//

import UIKit
import SharedCode



class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    @IBOutlet weak var episodesTableView: UITableView!
    
    var episodes: Array<Episode> = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        self.episodesTableView.dataSource = self
        self.episodesTableView.delegate = self
        self.episodes = []

        let viewModel = EpisodeListViewModel.init()
        viewModel.getEpisodes(callback: { array in
            self.episodes = array
            self.episodesTableView.reloadData()
        })
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.episodes.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = self.episodesTableView.dequeueReusableCell(withIdentifier: "episodeCell", for: indexPath) as! EpisodeTableViewCell
        cell.nameLabel?.text = self.episodes[indexPath.row].name
        cell.numberLabel?.text = "Podlodka #\(self.episodes[indexPath.row].number)"
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let showEpisodeViewController = ShowEpisodeViewController(nibName: "ShowEpisodeViewController", bundle: nil, episode: self.episodes[indexPath.row])

        self.navigationController?.pushViewController(showEpisodeViewController, animated: true)
    }
    
}
