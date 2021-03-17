@tag

Feature: Clients Management

    //We can write here

    @tag1
    Scenario: Register Client
        Given a new client 
        And a commercial department user
        And a database of size n
        When the client is registered
        Then database is of size //(n+1)

    @tag2
    Scenario: Commercial Access 
        Given a commercial department user
        And a database
        When trying to access 
        Then can read and write valid fields

    @tag3
    Scenario: ID Generation
        Given a new client
        When it is registered
        Then a new client ID is generated

    @tag4
    Scenario: Client information update
        Given a client
        And a database
        When trying to access
        Then can read and write valid fields

    @tag5
    Scenario: Search client
        Given a commercial department user
        And a database
        When input a client ID
        Then output a client
         
    @tag6
    Scenario: Login
        Given User type (Client/Commercial department user)
        And a login page
        When the user logins successfully
        Then access type permissions
    