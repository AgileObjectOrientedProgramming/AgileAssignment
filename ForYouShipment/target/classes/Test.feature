@tag

Feature: Clients Management

    All tests related to the mandatory functionality M1

    @tag1
    Scenario: Register Client
        Given a new client 
        And a commercial department user
        And a database of size n
        When it is registered
        Then database is of size n+1

    @tag2
    Scenario: Commercial Access 
        Given a commercial department user
        And a database
        When trying to access 
        Then can perform CRUD operations

    @tag3
    Scenario: ID Generation
        Given a new client
        When it is registered
        Then a new client ID is generated
        And the ID is unique

    @tag4
    Scenario: Client information update
        Given a client
        And a database
        When trying to access
        Then client can perform CRUD operations

    @tag5
    Scenario: Search client
        Given a commercial department user
        And a database
        When input a client ID
        Then output a client
         
    @tag6
    Scenario: Login
        Given a user of a type
        When the login is successfull
        Then access the permission level of type


    