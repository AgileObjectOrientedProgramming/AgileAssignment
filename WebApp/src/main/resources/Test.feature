Feature: M1 Clients Managment

    All tests related to the mandatory functionality M1

  Scenario Outline: Register Client
        Given a new client named "<name>"
        When I create his profile 
        Then storage has the client named "<name>"

    Examples:
        | name     |
        | Paulo    | 
        | Emma     |
        | Dusana   |

    #User Story 4
    Scenario: Client login
        Given a client account
        When the client tries to login
        Then he is logged in his account
    
    #User Story 2
    Scenario: Logistic user login
        Given a logistic account
        When the logistic user tries to login
        Then he is logged in his account

    #User Story 1
    Scenario: Failed login
        Given a web user
        When he tries to login with wrong credencials
        Then the login is unsuccessful

    ######################################

    # User Story ?
    Scenario: Deleting a Client
        Given a logistic account
        And a client account
        When he deletes the client 
        Then the customer is no longer in the storage

 
    Scenario: ID Generation
        Given a new client
        When it is registered
        Then a new client ID is generated
        And the ID is unique

    Scenario: Client information update
        Given a client
        When trying to change is last name to "<name>"
        Then the last name is "<name2>"

    Examples:
        | name   |
        | Dario  | 
        | Emma   |
        | Renjue | 

    Scenario: Search client
        Given a commercial department user
        And a database
        When input a client ID
        Then output a client
         
    Scenario: Login
        Given a user of a type
        When the login is successfull
        Then access the permission level of type


    