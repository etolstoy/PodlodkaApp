//
//  CategoryEpisodeTableViewCell.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 17/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit

class CategoryEpisodeTableViewCell: UITableViewCell {

    @IBOutlet weak var episodeNameLabel: UILabel!
    @IBOutlet weak var guestNameLabel: UILabel!
    @IBOutlet weak var photoImageView: UIImageView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
