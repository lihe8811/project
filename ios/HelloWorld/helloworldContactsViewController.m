//
//  helloworldContactsViewController.m
//  helloworld
//
//  Created by He Li on 2/10/14.
//  Copyright (c) 2014 He Li. All rights reserved.
//

#import "helloworldContactsViewController.h"
#import "helloworldShowcontact.h"

@interface helloworldContactsViewController ()

@property NSMutableArray *Contacts;

@end

@implementation helloworldContactsViewController

- (IBAction)unwindContacts:(UIStoryboardSegue *)segue
{
    /*helloworldNewcontactViewController *source = [segue sourceViewController];
    helloworldShowcontact *contact = source.myContact;
    if (contact != nil) {
        [self.Contacts addObject:contact];
        [self.tableView reloadData];
    }*/
}

- (id)initWithStyle:(UITableViewStyle)style
{
    self = [super initWithStyle:style];
    if (self) {
        // Custom initialization
    }
    return self;
}

/*- (void)loadInitialData
{
    helloworldShowcontact *contactOne = [[helloworldShowcontact alloc] init];
    contactOne.contactName = @"He Li";
    [self.Contacts addObject:contactOne];
    
    helloworldShowcontact *contactTwo = [[helloworldShowcontact alloc] init];
    contactTwo.contactName = @"Le Yu";
    [self.Contacts addObject:contactTwo];
    
    helloworldShowcontact *contactThree = [[helloworldShowcontact alloc] init];
    contactThree.contactName = @"Bowen Liang";
    [self.Contacts addObject:contactThree];
}*/

- (void)viewDidLoad
{
    [super viewDidLoad];
    /*self.Contacts = [[NSMutableArray alloc] init];
    [self loadInitialData];*/

    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
 
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    // Return the number of sections.
    /*return 1;*/
    return 0;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    // Return the number of rows in the section.
    /*return [self.Contacts count];*/
    return 1;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    /*static NSString *CellIdentifier = @"ListPrototypeCell";*/
    static NSString *CellIdentifier = @"Cell";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier forIndexPath:indexPath];
    
    // Configure the cell...
    /*helloworldShowcontact *contact = [self.Contacts objectAtIndex:indexPath.row];
    cell.textLabel.text = contact.contactName;*/
    return cell;
}

/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath
{
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
    }   
    else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
    }   
}
*/

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath
{
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/

/*
#pragma mark - Navigation

// In a story board-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}

 */

@end
