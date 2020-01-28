//
//  CategoryListView.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 28/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit

class CategoryListView: UIView {
    
    
    @IBOutlet weak var label: UILabel!
    
    let nibName = "CategoryListView"
    var contentView: UIView?

    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)

        guard let view = loadViewFromNib() else { return }
        view.frame = self.bounds
        view.backgroundColor = UIColor.clear
        self.addSubview(view)
        contentView = view
    }

    func loadViewFromNib() -> UIView? {
        let bundle = Bundle(for: type(of: self))
        let nib = UINib(nibName: nibName, bundle: bundle)
        return nib.instantiate(withOwner: self, options: nil).first as? UIView
    }
}
