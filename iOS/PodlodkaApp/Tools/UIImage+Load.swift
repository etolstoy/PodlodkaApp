//
//  UIImage+Load.swift
//  PodlodkaApp
//
//  Created by Egor Tolstoy on 18/01/2020.
//  Copyright © 2020 eetolstoy. All rights reserved.
//

import UIKit

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
