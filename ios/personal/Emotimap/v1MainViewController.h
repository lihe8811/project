//
//  v1MainViewController.h
//  Emotimap
//
//  Created by He Li on 2/11/14.
//  Copyright (c) 2014 He Li. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MapKit/MapKit.h>

@interface v1MainViewController : UIViewController <MKMapViewDelegate>

@property (nonatomic, strong) IBOutlet MKMapView *mapView;
@property (nonatomic, strong) NSMutableArray *matchingItems;

@end
