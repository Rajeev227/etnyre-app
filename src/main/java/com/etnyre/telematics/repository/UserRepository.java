package com.etnyre.telematics.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.etnyre.telematics.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Users save(Users users) {
        dynamoDBMapper.save(users);
        return users;
    }

    public Users getUsersById(String userId) {
        return dynamoDBMapper.load(Users.class, userId);
    }

    public String delete(String userId) {
        Users emp = dynamoDBMapper.load(Users.class, userId);
        dynamoDBMapper.delete(emp);
        return "User Deleted!";
    }

    public String update(String userId, Users users) {
        dynamoDBMapper.save(users,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("userId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(userId)
                                )));
        return "updated user";
    }

    public List<Users> getUsers() {
        PaginatedScanList<Users> users =dynamoDBMapper.scan(Users.class,new DynamoDBScanExpression());
        return users;
    }
}