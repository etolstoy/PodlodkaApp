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

        self.guestImageView.layer.masksToBounds = true
        self.guestImageView.layer.cornerRadius = self.guestImageView.bounds.width / 2
        
        self.episodeNameLabel.text = episode.name
        self.guestNameLabel.text = episode.guests?.first?.name
    }


    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
