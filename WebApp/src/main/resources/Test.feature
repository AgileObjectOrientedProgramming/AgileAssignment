Feature: Clients Management

    All tests related to the mandatory functionality M1

  Scenario: Register Client
        Given a new client named Emma
        When I create his profile 
        Then storage has the client named Emma


    Scenario: Commercial Access 
        Given a commercial department user
        And a database
        When trying to access 
        Then can perform CRUD operations

    Scenario: ID Generation
        Given a new client
        When it is registered
        Then a new client ID is generated
        And the ID is unique

    Scenario: Client information update
        Given a client
        And a database
        When trying to access
        Then client can perform CRUD operations

    Scenario: Search client
        Given a commercial department user
        And a database
        When input a client ID
        Then output a client
         
    Scenario: Login
        Given a user of a type
        When the login is successfull
        Then access the permission level of type


    