//
//  helloworldNewcontactViewController.m
//  helloworld
//
//  Created by He Li on 2/9/14.
//  Copyright (c) 2014 He Li. All rights reserved.
//

#import "helloworldNewcontactViewController.h"
#import "helloworldShowcontact.h"

@interface helloworldNewcontactViewController ()

/*@property (weak, nonatomic) IBOutlet UITextField *contactName;
@property (weak, nonatomic) IBOutlet UITextField *contactPhone;
@property (weak, nonatomic) IBOutlet UIBarButtonItem *DoneButton;*/

@end

@implementation helloworldNewcontactViewController

/*- (void) prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    if (sender != self.DoneButton) {
        return;
    }
    
    if (self.contactName.text.length > 0) {
        self.myContact = [[helloworldShowcontact alloc] init];
        self.myContact.contactName = self.contactName.text;
        self.myContact.contactPhone = self.contactPhone.text;
    }
}*/

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end    
