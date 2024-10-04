package com.etnyre.telematics.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "Users")
public class Users {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String userId;

    @DynamoDBAttribute
    private String firstName;

    @DynamoDBAttribute
    private String lastName;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private String password;

    @DynamoDBAttribute
    private  String role;

    @DynamoDBAttribute
    private  String createdTs;

    @DynamoDBAttribute
    private  String updatedTs;
}