//
//  SelfSizingTableView.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 17/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit

class SelfSizingTableView: UITableView {
    override var contentSize: CGSize {
        didSet {
            invalidateIntrinsicContentSize()
        }
    }

    override var intrinsicContentSize: CGSize {
        layoutIfNeeded()
        return CGSize(width: UIView.noIntrinsicMetric, height: contentSize.height)
    }
}
