    //
//  v1MainViewController.m
//  Emotimap
//
//  Created by He Li on 2/11/14.
//  Copyright (c) 2014 He Li. All rights reserved.
//

#import "v1MainViewController.h"
#import <CoreLocation/CoreLocation.h>

@interface v1MainViewController ()

@property (weak, nonatomic) IBOutlet UITextField *textField; // Search Box.

@property (nonatomic, assign) int latitudeRange;  // Range of latitude displayed on map; in meters.
@property (nonatomic, assign) int longitudeRange;  // Range of longitude displayed on map; in meters.
@property (nonatomic, assign) int searchLatitudeRange; // Range of latitude applied in search; in meters.
@property (nonatomic, assign) int searchLongitudeRange; // Range of longitude applied in search; in meters.

@end

@implementation v1MainViewController
@synthesize mapView;
@synthesize textField;

- (id)initWithCoder:(NSCoder *)aDecoder
{
    //TODO: This initializer is called. Is this expected? Remove this comment if it's normal.
    self = [super initWithCoder:aDecoder];
    if (self) {
        // Custom initialization
        self.latitudeRange = 800;
        self.longitudeRange = 800;
    }
    return self;
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    //TODO: This function is NOT called. Is this expected? Remove this comment if it's normal.
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    self.mapView.delegate = self;
    self.textField.delegate = self;
	// Do any additional setup after loading the view.
    
    [self initMapView];
    [textField addTarget:self action:@selector(searchLocation:nearBy:) forControlEvents:UIControlEventEditingDidEnd];
    [super viewDidLoad];
}

// Put experimental code here so that they won't mess up with "production" code.
- (void)initMapView
{
    // Do not track User Location. For experimental purpose.
    self.mapView.showsUserLocation = YES;
}

// This method is called whenever a new location update is received, if 'showsUserLocation' property is set to YES.
- (void)mapView:(MKMapView *)mapView didUpdateUserLocation:(MKUserLocation *)userLocation
{
    [self showLocation:userLocation.coordinate];
}

// Hide textfield keyboard when click 'Done'.
- (BOOL)textFieldShouldReturn:(UITextField *)textField
{
    [self.textField resignFirstResponder];
    return YES;
}

// Search location, acquire 'coordinate'
- (IBAction)searchLocation:(id)sender nearBy:(MKUserLocation *)userLocation
{
    if (self.textField.text.length > 0) {
        // Generate local search request.
        MKLocalSearchRequest *request = [[MKLocalSearchRequest alloc] init];
        request.naturalLanguageQuery = self.textField.text;
        request.region = self.mapView.region;
        
        // Perform local search.
        [self showSearchLocation:request];
    }
}

- (void)showSearchLocation:(MKLocalSearchRequest *)request
{
    self.matchingItems = [[NSMutableArray alloc] init];
    
    // Manage search completion handler from request.
    MKLocalSearch *search = [[MKLocalSearch alloc] initWithRequest:request];
    [search startWithCompletionHandler:^(MKLocalSearchResponse *response, NSError *error)
     {
         if (response.mapItems.count == 0) {
             NSLog(@"No matches");
         }
         else {
             for (MKMapItem *item in response.mapItems) {
                 [self.matchingItems addObject:item];
                 [self addAnnotation:item];
             }
         }
     }];
}

// Add annotation to the map.
- (void)addAnnotation:(MKMapItem *)item
{
    [self.mapView removeAnnotations:self.mapView.annotations];
    
    MKPointAnnotation *annotation = [[MKPointAnnotation alloc] init];
    [annotation setCoordinate:item.placemark.coordinate];
    [annotation setTitle:item.name];
    [self.mapView addAnnotation:annotation];
    [self.mapView setRegion:MKCoordinateRegionMakeWithDistance(item.placemark.coordinate, self.latitudeRange, self.longitudeRange) animated:YES];
}

// Show 'mapView' centering at 'coordinate'
- (void)showLocation:(CLLocationCoordinate2D)coordinate
{
    MKCoordinateRegion region = MKCoordinateRegionMakeWithDistance(coordinate, self.latitudeRange, self.longitudeRange);
    [self.mapView setRegion:[self.mapView regionThatFits:region] animated:YES];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
@end
