//
//  SelfSizingTableView.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 17/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit

class SelfSizingTableView: UITableView {
    var maxHeight: CGFloat = UIScreen.main.bounds.size.height
    
    override func reloadData() {
      super.reloadData()
      self.invalidateIntrinsicContentSize()
      self.layoutIfNeeded()
    }
    
    override var intrinsicContentSize: CGSize {
      let height = min(contentSize.height, maxHeight)
      return CGSize(width: contentSize.width, height: height)
    }
}
