# Task17DataHibernate

## GET options
*Returns JSON*

### GET...    
`/users` to get all users.    
*for example:* `http://localhost:8080/users`

`/user{id}` to get user by ID number.    
*for example:* `http://localhost:8080/user/1`

`/characters` to get all characters.    
*for example:* `http://localhost:8080/characters`

`/character/{id}` to get character by ID number.    
*for example:* `http://localhost:8080/characters`

`/classes` to get all classes.    
*for example:* `http://localhost:8080/classes`

`/class/{className}` to get class by class name.    
*for example:* `http://localhost:8080/class/Druid`


## POST options
*Use content type: application/json*

### POST...
`/user` to add new user.    
*for example:*    
```
{
"userName" : "Thomas",
"userEmail" : "thomas@gmail.com",
"userPassword" : "mittPassord"
}
```

`/character` to add new character.    
*for example:*     
```
{
"userID" : 9,
"characterName" : "PalaCraig",
"className" : "Paladin",
"characterLvl" : 8
}
```
