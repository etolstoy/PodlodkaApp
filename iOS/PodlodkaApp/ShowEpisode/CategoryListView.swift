//
//  CategoryListView.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 28/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit
import SharedCode

class CategoryListView: UIView, UICollectionViewDataSource {

    @IBOutlet weak var categoryCollectionView: UICollectionView!
    
    var categories: Array<EpisodeCategory>
    
    let nibName = "CategoryListView"
    var contentView: UIView?

    required init?(coder aDecoder: NSCoder) {
        self.categories = []
        super.init(coder: aDecoder)
        
        guard let view = loadViewFromNib() else { return }
        view.frame = self.bounds
        view.backgroundColor = UIColor.clear
        self.addSubview(view)
        contentView = view
        
        categoryCollectionView.dataSource = self
        
        let nib = UINib.init(nibName: "CategorySquareCollectionViewCell", bundle: nil)
        categoryCollectionView.register(nib, forCellWithReuseIdentifier: "categorySquareCell")
    }

    func loadViewFromNib() -> UIView? {
        let bundle = Bundle(for: type(of: self))
        let nib = UINib(nibName: nibName, bundle: bundle)
        return nib.instantiate(withOwner: self, options: nil).first as? UIView
    }
    
    func setupView() {
        
        categoryCollectionView.reloadData()
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return categories.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = categoryCollectionView.dequeueReusableCell(withReuseIdentifier: "categorySquareCell", for: indexPath) as! CategorySquareCollectionViewCell
        
        cell.categoryNameLabel.text = categories[indexPath.row].name
        cell.categoryEmojiLabel.text = categories[indexPath.row].emoji
        
        return cell
    }
    
    
    
}
