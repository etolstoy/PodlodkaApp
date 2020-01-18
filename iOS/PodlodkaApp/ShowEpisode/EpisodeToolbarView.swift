//
//  EpisodeToolbarView.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 18/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit

class EpisodeToolbarView: UIView {

    override init(frame: CGRect) {
        super.init(frame: frame)
        layoutView()
    }

    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        layoutView()
    }
    
    func layoutView() {
        clipsToBounds = true
        layer.cornerRadius = 30
        layer.shadowColor = UIColor.black.cgColor
        layer.shadowOpacity = 0.08
        layer.shadowOffset = .zero
        layer.masksToBounds = false
        layer.shadowRadius = 5
        layer.shadowPath = UIBezierPath(roundedRect: bounds, cornerRadius: 30).cgPath
    }

}
