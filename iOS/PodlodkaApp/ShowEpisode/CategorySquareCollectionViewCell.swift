//
//  CategorySquareCollectionViewCell.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 28/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit

class CategorySquareCollectionViewCell: UICollectionViewCell {

    @IBOutlet weak var categoryNameLabel: UILabel!
    @IBOutlet weak var categoryEmojiLabel: UILabel!
    @IBOutlet weak var roundView: UIView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        roundView.clipsToBounds = true
        roundView.layer.cornerRadius = roundView.frame.size.width / 2
        
        self.layer.cornerRadius = 10
    }

}
