//
//  ShowEpisodeViewController.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 14/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit
import SharedCode

class ShowEpisodeViewController: UIViewController, UITableViewDataSource {
    
    var episode: Episode
    var categoryEpisodes: Array<ShortEpisode>
    
    @IBOutlet weak var guestImageView: UIImageView!
    @IBOutlet weak var episodeNameLabel: UILabel!
    @IBOutlet weak var guestNameLabel: UILabel!
    @IBOutlet weak var episodeDescriptionLabel: UILabel!
    @IBOutlet weak var categoryView: UIView!
    @IBOutlet weak var categoryLabel: UILabel!
    @IBOutlet weak var categoryEpisodesTableView: UITableView!
    
    init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?, episode: Episode) {
        self.episode = episode
        self.categoryEpisodes = episode.categories.first?.episodes ?? []
        
        super.init(nibName:"ShowEpisodeViewController", bundle:nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        setupContent()
    }


    func setupContent() {        
        guestImageView.layer.masksToBounds = true
        guestImageView.layer.cornerRadius = self.guestImageView.bounds.width / 2
        
        guestImageView.layer.borderColor = UIColor.init(named: "darkYellow")?.cgColor
        guestImageView.layer.borderWidth = 4
        
        episodeNameLabel.text = episode.name
        guestNameLabel.text = episode.guests?.first?.name
        
        episodeDescriptionLabel.text = episode.desc
        
        categoryView.layer.masksToBounds = true
        categoryView.layer.cornerRadius = 8.0
        
        let categoryName = "\(episode.categories.first!.emoji) \(episode.categories.first!.name)"
        
        categoryLabel.text = categoryName
        categoryEpisodesTableView.dataSource = self
        
        let nib = UINib.init(nibName: "CategoryEpisodeTableViewCell", bundle: nil)
        categoryEpisodesTableView.register(nib, forCellReuseIdentifier: "categoryEpisodeCell")
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return categoryEpisodes.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = categoryEpisodesTableView.dequeueReusableCell(withIdentifier: "categoryEpisodeCell", for: indexPath) as! CategoryEpisodeTableViewCell
        
        let shortEpisode = categoryEpisodes[indexPath.row]
        cell.episodeNameLabel.text = shortEpisode.name
        cell.guestNameLabel.text = shortEpisode.guestName
        cell.photoImageView.load(url: URL.init(string: shortEpisode.photoUrl)!)
        
        return cell
    }

}

extension UIImageView {
    func load(url: URL) {
        DispatchQueue.global().async { [weak self] in
            if let data = try? Data(contentsOf: url) {
                if let image = UIImage(data: data) {
                    DispatchQueue.main.async {
                        self?.image = image
                    }
                }
            }
        }
    }
}
