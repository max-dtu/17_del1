
# The Die Game

Run in the terminal: 
```
javac *.java 
```

Thereafter, to play the game run: 
```
java Game
```

To run the tests: 
```
java TestGame
```

## What's new in version: v1.2 (17_del2)
- Now the user can choose how many faces a die must have:
```
public int roll(int numberOfFaces) {
        return random.nextInt(numberOfFaces) + 1;
    }
```
- Spicify the number of players easly in the Game class.
- Spicify the number of dies in the Player Class.
- Easly add/remove/update rules in the Player Class.
- Add money to player's acount when initialising a player.
- The abality of using the player and his balance in other games.
<p style="text-indent: 60px;">
    To make a Player class reusable across different games, we've made the class more generic and independent from game-specific logic. By doing this, other games can utilize the Player and its balance. Each game can create an instance of the Player and manage the balance independently.
</p>
    


## Upcoming soon:
- The game will be available in other languages. 
          
       
        



