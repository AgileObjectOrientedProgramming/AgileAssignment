Feature: M1 Clients Managment

    All tests related to the mandatory functionality M1

    
    #User Story: Register new clients

    Scenario Outline: Register Client
        Given a new client named "<name>"
        And I am a logistic user
        When I create his profile 
        Then storage has the client named "<name>"

    Examples:
        | name     |
        | Paulo    | 
        | Emma     |
        | Dusana   |

    Scenario Outline: Using duplicated username
        Given a new client name "<name>"
        When I create his profile 
        But I use a already taken username
        Then the storage does not have the client "<name>"

    Scenario Outline: Not matching passwords
        Given a new client name "<name>"
        When I create his profile
        But I dont match the password
        Then the storage does not have the client "<name>"

    Scenario Outline: Username too long
        Given a new client name "<name>"
        When I create his profile 
        But I input a too long username
        Then the storage does not have the client "<name>"

    Scenario Outline: Password too short
        Given a new client name "<name>"
        When I create his profile 
        But I input a too short password
        Then the storage does not have the client "<name>"

    Scenario Outline: ID generation
        Given a new client
        When I create his profile 
        Then he gets a unique ID



    #User Story: Login as a client user

        Scenario: Client login
        Given a client user
        When the user tries to login
        And he uses the correct credencials
        Then he is logged in his account
        And he is in the client section
    
        Scenario: Unsuccessful login
        Given a client user
        When the user tries to login
        And he uses a invalid username
        Then he needs to try again

        Scenario: Unsuccessful login
        Given a client user
        When the user tries to login
        And he uses a valid username
        But the password does not match
        Then he needs to try again


    #User Story: Login as logistic user

    Scenario: Logistics login
        Given a logistics user
        When the user tries to login
        And he uses the correct credencials
        Then he is logged in his account
        And he is in the logistics section
    
    Scenario: Unsuccessful login
        Given a logistics user
        When the user tries to login
        And he uses a invalid username
        Then he needs to try again

    Scenario: Unsuccessful login
        Given a logistics user
        When the user tries to login
        And he uses a valid username
        But the password does not match
        Then he needs to try again

    ######################################

    # User Story 5 Have a user profile
    Scenario: Deleting a Client
        Given a logistic account
        And a client account
        When he deletes the client 
        Then the customer is no longer in the storage

 
    Scenario: Client information update
        Given a client
        When trying to change is last name to "<name>"
        Then the last name is "<name>"


    Scenario: Search client
        Given a commercial department user
        When input a client ID
        Then output a client


    