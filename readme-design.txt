Items are an abstract class where consumable-item and weapon-item extends from. This makes it easier to pick up and
drop items.
If the player moves into a room with a monster, the player must defeat the monster before he can preform other actions
this is to simulate the lack of time to react to being attacked.
The game loops, by awaiting user input to allow the user to make a turn. When there is a monster in the room, after the
player attacks the monster but fails to kill it, the monster will take it's turn to attack the player and this will
continue until either the player or the monster dies. If the player dies then the game is over. If the monster dies,
then the player may continue normal actions.