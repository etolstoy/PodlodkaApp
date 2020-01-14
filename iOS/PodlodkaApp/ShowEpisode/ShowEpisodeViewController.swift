//
//  ShowEpisodeViewController.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 14/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit
import SharedCode

class ShowEpisodeViewController: UIViewController {
    
    var episode: Episode
    
    @IBOutlet weak var guestImageView: UIImageView!
    @IBOutlet weak var episodeNameLabel: UILabel!
    @IBOutlet weak var guestNameLabel: UILabel!
    
    init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?, episode: Episode) {
        self.episode = episode
        
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
    }

}
