//
//  v1ToDoItem.h
//  ToDoList
//
//  Created by He Li on 2/11/14.
//  Copyright (c) 2014 He Li. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface v1ToDoItem : NSObject

@property NSString *itemName;
@property BOOL completed;
@property (readonly) NSDate *creationDate;

@end
