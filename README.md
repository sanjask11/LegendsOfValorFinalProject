# CS611 - Final Project
## Legends : Legends of Valor

------------------------------------------------------------ 
### Group Member 1
- **Name:** Sanjana
- **Email:** sanjask@bu.edu
- **Student ID:** U33564045

### Group Member 2
- **Name:** Priyanshu Bansal
- **Email:** bpri1504@bu.edu
- **Student ID:** U07574971

### Group Member 3
- **Name:** Mengxing Wang
- **Email:** wangmx@bu.edu
- **Student ID:** U81767669

------------------------------------------------------------  

# Project Overview

## Folder Structure & File Overview

#### `core`
| File | Description |
|---|---|
| `ConsoleIO` | Centralized console input/output utilities. |
| `Direction` | Enum representing movement directions. |
| `GameState` | Tracks global game state and transitions. |
| `Menu` | Base interface for menu systems. |
| `PauseMenu` | Handles pause menu interactions. |
| `SaveManager` | Manages save/load functionality. |


#### `entities.heroes`
| File | Description |
|---|---|
| `Hero` | Abstract base class for all hero types. |
| `HeroFactory` | Creates hero instances based on type. |
| `HeroLoader` | Loads hero data from configuration files. |
| `Paladin` | Defensive hero with high durability. |
| `Sorcerer` | Magic-focused hero with spell advantages. |
| `Warrior` | Physical combat hero with high strength. |


#### `entities.monsters`
| File | Description |
|---|---|
| `Monster` | Abstract base class for all monsters. |
| `Dragon` | High-damage monster with strong stats. |
| `Exoskeleton` | Monster focused on defense. |
| `Spirit` | Agile monster with high dodge chance. |
| `MonsterFactory` | Generates monsters dynamically. |
| `MonsterLoader` | Loads monster data from files. |


#### `entities`
| File | Description |
|---|---|
| `CombatEntity` | Interface defining combat-related behavior. |


#### `game.battle`
| File | Description |
|---|---|
| `Battle` | Controls the overall battle flow. |
| `BattleLogic` | Contains core battle rules and calculations. |
| `BattleResult` | Enum representing battle outcomes. |
| `BattleUI` | Handles user interaction during battles. |



#### `game.exploration.commands`
| File | Description |
|---|---|
| `HeroCommand` | Interface for all hero commands. |
| `HeroCommandFactory` | Creates commands based on user input. |
| `AttackCommand` | Executes physical attacks. |
| `CastSpellCommand` | Executes spell casting actions. |
| `MoveCommand` | Handles hero movement. |
| `RecallCommand` | Recalls hero back to the nexus. |
| `RemoveObstacleCommand` | Removes obstacles from the map. |
| `TeleportCommand` | Teleports heroes across the map. |
| `UsePotionCommand` | Applies potion effects. |


#### `game.exploration`
| File | Description |
|---|---|
| `BaseExplorationController` | Shared controller logic for exploration modes. |
| `ExplorationLogicBase` | Base class for exploration rules. |
| `ExplorationUIBase` | Base UI for exploration. |
| `LoVExplorationController` | Controller for Legends of Valor exploration. |
| `LoVExplorationLogic` | Exploration logic for LoV. |
| `LoVExplorationUI` | UI for LoV exploration. |
| `MHExplorationController` | Controller for Monsters & Heroes exploration. |
| `MHExplorationLogic` | Exploration logic for MH. |
| `MHExplorationUI` | UI for MH exploration. |



#### `inventory`
| File | Description |
|---|---|
| `InventoryController` | Handles inventory actions. |
| `InventoryLogic` | Core inventory manipulation logic. |
| `InventoryUI` | Displays inventory information. |



#### `services`
| File | Description |
|---|---|
| `PotionService` | Applies potion effects to heroes. |



#### `setup`
| File | Description |
|---|---|
| `GameLauncher` | Entry point of the application. |
| `GameMode` | Enum defining available game modes. |
| `SetupMenu` | Handles initial game setup. |
| `ExplorationMenu` | Menu for exploration mode. |
| `InventoryMenu` | Menu for inventory management. |
| `LoVExplorationMenu` | Exploration menu for LoV. |
| `LoVGame` | Legends of Valor game controller. |
| `MHGame` | Monsters & Heroes game controller. |



#### `items`
| File | Description |
|---|---|
| `Item` | Base class for all items. |
| `Weapon` | Weapon item providing attack bonuses. |
| `Armor` | Armor item providing defense bonuses. |
| `Spell` | Abstract base class for spells. |
| `Potion` | Abstract base class for potions. |



#### `items.potions`
| File | Description |
|---|---|
| `BasicPotion` | Generic potion implementation. |
| `HealthPotion` | Potion that restores hero health. |



#### `items.spells`
| File | Description |
|---|---|
| `FireSpell` | Spell that reduces monster defense. |
| `IceSpell` | Spell that reduces monster damage. |
| `LightningSpell` | Spell that reduces monster dodge chance. |


#### `market`
| File | Description |
|---|---|
| `Market` | Stores items available for purchase. |
| `MarketController` | Handles market interactions. |
| `MarketLogic` | Implements buying and selling rules. |
| `MarketLoader` | Loads market items from data files. |
| `MarketUI` | Displays the market interface. |



#### `world.effects`
| File | Description |
|---|---|
| `TileEffect` | Interface for tile-based effects. |
| `BushEffect` | Applies dexterity bonus on bush tiles. |
| `CaveEffect` | Applies agility bonus on cave tiles. |
| `KoulouEffect` | Applies strength bonus on koulou tiles. |
| `NoEffect` | Default tile effect with no bonus. |



#### `world.rules`
| File | Description |
|---|---|
| `Rule` | Generic rule interface. |
| `RuleEngine` | Validates rule execution. |
| `MoveContext` | Context data for movement validation. |
| `MoveRule` | Validates hero movement rules. |
| `TeleportContext` | Context data for teleport validation. |
| `TeleportRule` | Validates teleport actions. |
| `RangeRule` | Determines attack and spell range. |
| `NexusWinRule` | Determines win conditions. |




#### `world.tiles`
| File | Description |
|---|---|
| `AbstractWorld` | Base class for world implementations. |
| `LoVWorld` | Legends of Valor world implementation. |
| `MHWorld` | Monsters & Heroes world implementation. |
| `LoVMonsterUnit` | Monster with board position and lane. |
| `LoVTile` | Tile implementation for LoV. |
| `LoVTileType` | Enum defining LoV tile types. |
| `Tile` | Base tile abstraction. |

## How to Compile & Run the assignment
- Clone the repository
  - **`git clone https://github.com/sanjask11/LegendsOfValorFinalProject`**  
- Compile the code in Java version 8
  - **`cd Legends-MonstersAndHeroes/src`**   
  - **`javac -source 1.8 -target 1.8 *.java`**
- Run the java file
  - **`java Main`**

## Sample Input & Output

### Monsters & Heroes Terminal Output 

```text
/Users/sanjanasanjeevkumar/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=49865 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/sanjanasanjeevkumar/Downloads/LegendsOfValorFinalProjectD/out/production/LegendsOfValorFinalProject Main
=== LEGENDS COLLECTION ===
Which game do you want to play?
1. Legends: Monsters & Heroes
2. Legends of Valor
1
=== MONSTERS & HEROES ===

=== CHOOSE YOUR HEROES (1–3) ===
0: Gaerdal_Ironhand [Lvl 1, HP=100, MP=100, STR=700, DEX=600, AGI=500, Gold=1354] [Warrior]
1: Sehanine_Monnbow [Lvl 1, HP=100, MP=600, STR=700, DEX=500, AGI=800, Gold=2500] [Warrior]
2: Muamman_Duathall [Lvl 1, HP=100, MP=300, STR=900, DEX=750, AGI=500, Gold=2546] [Warrior]
3: Flandal_Steelskin [Lvl 1, HP=100, MP=200, STR=750, DEX=700, AGI=650, Gold=2500] [Warrior]
4: Undefeated_Yoj [Lvl 1, HP=100, MP=400, STR=800, DEX=700, AGI=400, Gold=2500] [Warrior]
5: Eunoia_Cyn [Lvl 1, HP=100, MP=400, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
6: Rillifane_Rallathil [Lvl 1, HP=100, MP=1300, STR=750, DEX=500, AGI=450, Gold=2500] [Sorcerer]
7: Segojan_Earthcaller [Lvl 1, HP=100, MP=900, STR=800, DEX=650, AGI=500, Gold=2500] [Sorcerer]
8: Reign_Havoc [Lvl 1, HP=100, MP=800, STR=800, DEX=800, AGI=800, Gold=2500] [Sorcerer]
9: Reverie_Ashels [Lvl 1, HP=100, MP=900, STR=800, DEX=400, AGI=700, Gold=2500] [Sorcerer]
10: Kalabar [Lvl 1, HP=100, MP=800, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
11: Skye_Soar [Lvl 1, HP=100, MP=1000, STR=700, DEX=500, AGI=400, Gold=2500] [Sorcerer]
12: Parzival [Lvl 1, HP=100, MP=300, STR=750, DEX=700, AGI=650, Gold=2500] [Paladin]
13: Sehanine_Moonbow [Lvl 1, HP=100, MP=300, STR=750, DEX=700, AGI=700, Gold=2500] [Paladin]
14: Skoraeus_Stonebones [Lvl 1, HP=100, MP=250, STR=650, DEX=350, AGI=600, Gold=2500] [Paladin]
15: Garl_Glittergold [Lvl 1, HP=100, MP=100, STR=600, DEX=400, AGI=500, Gold=2500] [Paladin]
16: Amaryllis_Astra [Lvl 1, HP=100, MP=500, STR=500, DEX=500, AGI=500, Gold=2500] [Paladin]
17: Caliber_Heist [Lvl 1, HP=100, MP=400, STR=400, DEX=400, AGI=400, Gold=2500] [Paladin]
Enter hero index (or -1 to finish): 1
Sehanine_Monnbow added to party!
Enter hero index (or -1 to finish): 2
Muamman_Duathall added to party!
Enter hero index (or -1 to finish): 3
Flandal_Steelskin added to party!
Enter world size (default 8): 5

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ P │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ M │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 100  MP: 600  STR:700  DEX:500  AGI:800  LVL:1
Muamman_Duathall  HP: 100  MP: 300  STR:900  DEX:750  AGI:500  LVL:1
Flandal_Steelskin  HP: 100  MP: 200  STR:750  DEX:700  AGI:650  LVL:1

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
s

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ P │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ M │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 100  MP: 600  STR:700  DEX:500  AGI:800  LVL:1
Muamman_Duathall  HP: 100  MP: 300  STR:900  DEX:750  AGI:500  LVL:1
Flandal_Steelskin  HP: 100  MP: 200  STR:750  DEX:700  AGI:650  LVL:1

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
a

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ P │ │ . │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ M │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 100  MP: 600  STR:700  DEX:500  AGI:800  LVL:1
Muamman_Duathall  HP: 100  MP: 300  STR:900  DEX:750  AGI:500  LVL:1
Flandal_Steelskin  HP: 100  MP: 200  STR:750  DEX:700  AGI:650  LVL:1

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
m

Choose hero to enter market:
0: Sehanine_Monnbow [Lvl 1, HP=100, MP=600, STR=700, DEX=500, AGI=800, Gold=2500] [Warrior]
1: Muamman_Duathall [Lvl 1, HP=100, MP=300, STR=900, DEX=750, AGI=500, Gold=2546] [Warrior]
2: Flandal_Steelskin [Lvl 1, HP=100, MP=200, STR=750, DEX=700, AGI=650, Gold=2500] [Warrior]
Index (-1 to cancel): 0

=== MARKET ===
Hero: Sehanine_Monnbow  Gold: 2500
1 Buy
2 Sell
0 Exit
1

What to buy?
1 Weapons
2 Armors
3 Potions
4 Spells
0 Back
1
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
1: Bow [Weapon dmg=500, hands=2, lvl=2, cost=300]
2: Scythe [Weapon dmg=1100, hands=2, lvl=6, cost=1000]
3: Axe [Weapon dmg=850, hands=1, lvl=5, cost=550]
4: TSwords [Weapon dmg=1600, hands=2, lvl=8, cost=1400]
5: Dagger [Weapon dmg=250, hands=1, lvl=1, cost=200]
Choose (-1 cancel): 0
Purchased: Sword

What to buy?
1 Weapons
2 Armors
3 Potions
4 Spells
0 Back
4
0: Flame_Tornado (Lvl 4, Price=700)
1: Breath_of_Fire (Lvl 1, Price=350)
2: Heat_Wave (Lvl 2, Price=450)
3: Lava_Comet (Lvl 7, Price=800)
4: Hell_Storm (Lvl 3, Price=600)
5: Snow_Cannon [Ice Spell, dmg=650, mana=250, uses=1, lvl=2, cost=500]
6: Ice_Blade [Ice Spell, dmg=450, mana=100, uses=1, lvl=1, cost=250]
7: Frost_Blizzard [Ice Spell, dmg=850, mana=350, uses=1, lvl=5, cost=750]
8: Arctic_Storm [Ice Spell, dmg=800, mana=300, uses=1, lvl=6, cost=700]
9: Lightning_Dagger [Lightning Spell, dmg=500, mana=150, uses=1, lvl=1, cost=400]
10: Thunder_Blast [Lightning Spell, dmg=950, mana=400, uses=1, lvl=4, cost=750]
11: Electric_Arrows [Lightning Spell, dmg=650, mana=200, uses=1, lvl=5, cost=550]
12: Spark_Needles [Lightning Spell, dmg=600, mana=200, uses=1, lvl=2, cost=500]
Choose (-1 cancel): 1
Purchased: Breath_of_Fire

What to buy?
1 Weapons
2 Armors
3 Potions
4 Spells
0 Back
0

=== MARKET ===
Hero: Sehanine_Monnbow  Gold: 1650
1 Buy
2 Sell
0 Exit
0
Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
b

=== INVENTORY MENU ===
0: Sehanine_Monnbow
1: Muamman_Duathall
2: Flandal_Steelskin
Choose hero (-1 to exit): 
0

=== Sehanine_Monnbow INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
2

Weapons:
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
Choose weapon (-1 to cancel): 0
Sehanine_Monnbow equipped weapon Sword

=== Sehanine_Monnbow INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
1

Items:
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
1: Breath_of_Fire (Lvl 1, Price=350)

=== Sehanine_Monnbow INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
0

=== INVENTORY MENU ===
0: Sehanine_Monnbow
1: Muamman_Duathall
2: Flandal_Steelskin
Choose hero (-1 to exit): 
-1
Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
d

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ P │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ M │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 100  MP: 600  STR:700  DEX:500  AGI:800  LVL:1
Muamman_Duathall  HP: 100  MP: 300  STR:900  DEX:750  AGI:500  LVL:1
Flandal_Steelskin  HP: 100  MP: 200  STR:750  DEX:700  AGI:650  LVL:1

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
s

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ P │ │ . │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ M │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 100  MP: 600  STR:700  DEX:500  AGI:800  LVL:1
Muamman_Duathall  HP: 100  MP: 300  STR:900  DEX:750  AGI:500  LVL:1
Flandal_Steelskin  HP: 100  MP: 200  STR:750  DEX:700  AGI:650  LVL:1

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
d

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ P │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ M │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 100  MP: 600  STR:700  DEX:500  AGI:800  LVL:1
Muamman_Duathall  HP: 100  MP: 300  STR:900  DEX:750  AGI:500  LVL:1
Flandal_Steelskin  HP: 100  MP: 200  STR:750  DEX:700  AGI:650  LVL:1

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
d
Blocked. This tile is inaccessible.
Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
s

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ P │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 100  MP: 600  STR:700  DEX:500  AGI:800  LVL:1
Muamman_Duathall  HP: 100  MP: 300  STR:900  DEX:750  AGI:500  LVL:1
Flandal_Steelskin  HP: 100  MP: 200  STR:750  DEX:700  AGI:650  LVL:1

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
d

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ M │ │ P │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 100  MP: 600  STR:700  DEX:500  AGI:800  LVL:1
Muamman_Duathall  HP: 100  MP: 300  STR:900  DEX:750  AGI:500  LVL:1
Flandal_Steelskin  HP: 100  MP: 200  STR:750  DEX:700  AGI:650  LVL:1

Monsters appear!

=== BATTLE BEGINS ===

=== STATUS ===
Heroes:
 - Sehanine_Monnbow [Lvl 1, HP=100, MP=600, STR=700, DEX=500, AGI=800, Gold=1650] [Warrior]
 - Muamman_Duathall [Lvl 1, HP=100, MP=300, STR=900, DEX=750, AGI=500, Gold=2546] [Warrior]
 - Flandal_Steelskin [Lvl 1, HP=100, MP=200, STR=750, DEX=700, AGI=650, Gold=2500] [Warrior]
Monsters:
 - [Spirit] Andromalius [Lvl 3 | HP=300 | DMG=550 | DEF=450 | Dodge=25%]
 - [Spirit] Blinky [Lvl 1 | HP=100 | DMG=450 | DEF=350 | Dodge=35%]
 - [Spirit] Blinky [Lvl 1 | HP=100 | DMG=450 | DEF=350 | Dodge=35%]

--- Hero Turn: Sehanine_Monnbow ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
e
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
Choose weapon (-1 to cancel): 0
Sehanine_Monnbow equipped weapon Sword
No armors.

--- Hero Turn: Sehanine_Monnbow ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Andromalius [Lvl 3 | HP=300 | DMG=550 | DEF=450 | Dodge=25%]
1: [Spirit] Blinky [Lvl 1 | HP=100 | DMG=450 | DEF=350 | Dodge=35%]
2: [Spirit] Blinky [Lvl 1 | HP=100 | DMG=450 | DEF=350 | Dodge=35%]
Choose target (-1 to cancel): 1
Sehanine_Monnbow attacks Blinky!
Blinky took 1045 damage (HP = 0)

--- Monsters' Turn ---
Andromalius attacks Sehanine_Monnbow!
Sehanine_Monnbow dodged!
Blinky attacks Sehanine_Monnbow!
Sehanine_Monnbow dodged!

=== STATUS ===
Heroes:
 - Sehanine_Monnbow [Lvl 1, HP=110, MP=660, STR=700, DEX=500, AGI=800, Gold=1650] [Warrior]
 - Muamman_Duathall [Lvl 1, HP=110, MP=330, STR=900, DEX=750, AGI=500, Gold=2546] [Warrior]
 - Flandal_Steelskin [Lvl 1, HP=110, MP=220, STR=750, DEX=700, AGI=650, Gold=2500] [Warrior]
Monsters:
 - [Spirit] Andromalius [Lvl 3 | HP=300 | DMG=550 | DEF=450 | Dodge=25%]
 - [Spirit] Blinky [Lvl 1 | HP=0 | DMG=450 | DEF=350 | Dodge=35%] (DEAD)
 - [Spirit] Blinky [Lvl 1 | HP=100 | DMG=450 | DEF=350 | Dodge=35%]

--- Hero Turn: Sehanine_Monnbow ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Andromalius [Lvl 3 | HP=300 | DMG=550 | DEF=450 | Dodge=25%]
1: [Spirit] Blinky [Lvl 1 | HP=0 | DMG=450 | DEF=350 | Dodge=35%] (DEAD)
2: [Spirit] Blinky [Lvl 1 | HP=100 | DMG=450 | DEF=350 | Dodge=35%]
Choose target (-1 to cancel): 2
Sehanine_Monnbow attacks Blinky!
Blinky took 1045 damage (HP = 0)

--- Monsters' Turn ---
Andromalius attacks Sehanine_Monnbow!
Sehanine_Monnbow dodged!

=== STATUS ===
Heroes:
 - Sehanine_Monnbow [Lvl 1, HP=120, MP=726, STR=700, DEX=500, AGI=800, Gold=1650] [Warrior]
 - Muamman_Duathall [Lvl 1, HP=120, MP=363, STR=900, DEX=750, AGI=500, Gold=2546] [Warrior]
 - Flandal_Steelskin [Lvl 1, HP=120, MP=242, STR=750, DEX=700, AGI=650, Gold=2500] [Warrior]
Monsters:
 - [Spirit] Andromalius [Lvl 3 | HP=300 | DMG=550 | DEF=450 | Dodge=25%]
 - [Spirit] Blinky [Lvl 1 | HP=0 | DMG=450 | DEF=350 | Dodge=35%] (DEAD)
 - [Spirit] Blinky [Lvl 1 | HP=0 | DMG=450 | DEF=350 | Dodge=35%] (DEAD)

--- Hero Turn: Sehanine_Monnbow ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
s

Spells:
0: Breath_of_Fire (Lvl 1, Price=350)
Choose spell (-1 to cancel): 0

Monsters:
0: [Spirit] Andromalius [Lvl 3 | HP=300 | DMG=550 | DEF=450 | Dodge=25%]
1: [Spirit] Blinky [Lvl 1 | HP=0 | DMG=450 | DEF=350 | Dodge=35%] (DEAD)
2: [Spirit] Blinky [Lvl 1 | HP=0 | DMG=450 | DEF=350 | Dodge=35%] (DEAD)
Choose target (-1 to cancel): 0
Andromalius took 473 spell damage (HP = 0)

=== HEROES WIN ===
Sehanine_Monnbow leveled up! Now level 2
Muamman_Duathall leveled up! Now level 2
Flandal_Steelskin leveled up! Now level 2

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ M │ │ P │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 200  MP: 688  STR:771  DEX:525  AGI:882  LVL:2
Muamman_Duathall  HP: 200  MP: 399  STR:992  DEX:787  AGI:551  LVL:2
Flandal_Steelskin  HP: 200  MP: 266  STR:826  DEX:735  AGI:716  LVL:2

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
b

=== INVENTORY MENU ===
0: Sehanine_Monnbow
1: Muamman_Duathall
2: Flandal_Steelskin
Choose hero (-1 to exit): 
0

=== Sehanine_Monnbow INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
1

Items:
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
1: Breath_of_Fire (Lvl 1, Price=350)

=== Sehanine_Monnbow INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
2

Weapons:
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
Choose weapon (-1 to cancel): 0
Sehanine_Monnbow equipped weapon Sword

=== Sehanine_Monnbow INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
0

=== INVENTORY MENU ===
0: Sehanine_Monnbow
1: Muamman_Duathall
2: Flandal_Steelskin
Choose hero (-1 to exit): 
-1
Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
d

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ . │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ X │ │ . │ │ . │ │ X │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ . │ │ M │ │ . │ │ P │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ . │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Sehanine_Monnbow  HP: 200  MP: 688  STR:771  DEX:525  AGI:882  LVL:2
Muamman_Duathall  HP: 200  MP: 399  STR:992  DEX:787  AGI:551  LVL:2
Flandal_Steelskin  HP: 200  MP: 266  STR:826  DEX:735  AGI:716  LVL:2

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:

```

### Legends of Valor Terminal Output 

```text
/Users/sanjanasanjeevkumar/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=49757 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/sanjanasanjeevkumar/Downloads/LegendsOfValorFinalProjectD/out/production/LegendsOfValorFinalProject Main
=== LEGENDS COLLECTION ===
Which game do you want to play?
1. Legends: Monsters & Heroes
2. Legends of Valor
2
=== LEGENDS OF VALOR ===
Choose 3 heroes for your team:

=== HERO SELECTION ===
0 -> Gaerdal_Ironhand [Lvl 1, HP=100, MP=100, STR=700, DEX=600, AGI=500, Gold=1354] [Warrior]
1 -> Sehanine_Monnbow [Lvl 1, HP=100, MP=600, STR=700, DEX=500, AGI=800, Gold=2500] [Warrior]
2 -> Muamman_Duathall [Lvl 1, HP=100, MP=300, STR=900, DEX=750, AGI=500, Gold=2546] [Warrior]
3 -> Flandal_Steelskin [Lvl 1, HP=100, MP=200, STR=750, DEX=700, AGI=650, Gold=2500] [Warrior]
4 -> Undefeated_Yoj [Lvl 1, HP=100, MP=400, STR=800, DEX=700, AGI=400, Gold=2500] [Warrior]
5 -> Eunoia_Cyn [Lvl 1, HP=100, MP=400, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
6 -> Rillifane_Rallathil [Lvl 1, HP=100, MP=1300, STR=750, DEX=500, AGI=450, Gold=2500] [Sorcerer]
7 -> Segojan_Earthcaller [Lvl 1, HP=100, MP=900, STR=800, DEX=650, AGI=500, Gold=2500] [Sorcerer]
8 -> Reign_Havoc [Lvl 1, HP=100, MP=800, STR=800, DEX=800, AGI=800, Gold=2500] [Sorcerer]
9 -> Reverie_Ashels [Lvl 1, HP=100, MP=900, STR=800, DEX=400, AGI=700, Gold=2500] [Sorcerer]
10 -> Kalabar [Lvl 1, HP=100, MP=800, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
11 -> Skye_Soar [Lvl 1, HP=100, MP=1000, STR=700, DEX=500, AGI=400, Gold=2500] [Sorcerer]
12 -> Parzival [Lvl 1, HP=100, MP=300, STR=750, DEX=700, AGI=650, Gold=2500] [Paladin]
13 -> Sehanine_Moonbow [Lvl 1, HP=100, MP=300, STR=750, DEX=700, AGI=700, Gold=2500] [Paladin]
14 -> Skoraeus_Stonebones [Lvl 1, HP=100, MP=250, STR=650, DEX=350, AGI=600, Gold=2500] [Paladin]
15 -> Garl_Glittergold [Lvl 1, HP=100, MP=100, STR=600, DEX=400, AGI=500, Gold=2500] [Paladin]
16 -> Amaryllis_Astra [Lvl 1, HP=100, MP=500, STR=500, DEX=500, AGI=500, Gold=2500] [Paladin]
17 -> Caliber_Heist [Lvl 1, HP=100, MP=400, STR=400, DEX=400, AGI=400, Gold=2500] [Paladin]

Choose 3 heroes by index:
Select hero 1: 1
Added: Sehanine_Monnbow
Select hero 2: 2
Added: Muamman_Duathall
Select hero 3: 3
Added: Flandal_Steelskin

=== FINAL PARTY ===
Sehanine_Monnbow [Lvl 1, HP=100, MP=600, STR=700, DEX=500, AGI=800, Gold=2500] [Warrior]
Muamman_Duathall [Lvl 1, HP=100, MP=300, STR=900, DEX=750, AGI=500, Gold=2546] [Warrior]
Flandal_Steelskin [Lvl 1, HP=100, MP=200, STR=750, DEX=700, AGI=650, Gold=2500] [Warrior]

Choose lane for each hero (each lane can be used once):
1=Left, 2=Middle, 3=Right
Hero 1 (Sehanine_Monnbow) lane [1-3]: 1
Hero 2 (Muamman_Duathall) lane [1-3]: 2
Hero 3 (Flandal_Steelskin) lane [1-3]: 3

=== LEGENDS OF VALOR MAP (Round 1) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│ 0 │ │   │ │   │ │ 1 │ │   │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │


=== LEGENDS OF VALOR MAP (Round 1) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │ M │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│ 0 │ │   │ │   │ │ 1 │ │   │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

d

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

d

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

d
=== MONSTER TURN ===

=== LEGENDS OF VALOR MAP (Round 2) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │ M │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ 0 │ │   │ │   │ │ 1 │ │   │ │   │ │ 2 │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

a
=== MONSTER TURN ===

=== LEGENDS OF VALOR MAP (Round 3) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │ M │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ 0 │ │   │ │   │ │ 1 │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w
=== MONSTER TURN ===

=== LEGENDS OF VALOR MAP (Round 4) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │ M │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │ M │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ 0 │ │   │ │   │ │ 1 │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

atk
No monsters in range.

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w
=== MONSTER TURN ===
BigBad-Wolf attacks Muamman_Duathall!
Muamman_Duathall dodged!

=== LEGENDS OF VALOR MAP (Round 5) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │ M │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │ M │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ 0 │ │   │ │   │ │ 1 │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

atk
Muamman_Duathall attacks BigBad-Wolf!
BigBad-Wolf took 623 damage (HP = 0)

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w
=== MONSTER TURN ===
Sehanine_Monnbow leveled up! Now level 2

=== LEGENDS OF VALOR MAP (Round 6) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │ M │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ 0 │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │ 1 │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w
=== MONSTER TURN ===
BigBad-Wolf attacks Muamman_Duathall!
Muamman_Duathall dodged!

=== LEGENDS OF VALOR MAP (Round 7) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ 0 │ │   │ │   │ │ M │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │ 1 │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w
Invalid move.

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

atk
No monsters in range.

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

o
Enter obstacleRow obstacleCol: 1 1

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

atk
Muamman_Duathall attacks BigBad-Wolf!
BigBad-Wolf took 687 damage (HP = 0)

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w
Invalid move.

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

o
Enter obstacleRow obstacleCol: 2 6
=== MONSTER TURN ===
Muamman_Duathall leveled up! Now level 2
Flandal_Steelskin leveled up! Now level 2

=== LEGENDS OF VALOR MAP (Round 8) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │ M │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ 0 │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │ 1 │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

atk
Sehanine_Monnbow attacks BigBad-Wolf!
BigBad-Wolf took 585 damage (HP = 0)

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w
=== MONSTER TURN ===
BigBad-Wolf attacks Flandal_Steelskin!
Flandal_Steelskin dodged!

=== LEGENDS OF VALOR MAP (Round 9) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │ M │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ 0 │ │   │ │   │ │ 1 │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

atk
Sehanine_Monnbow attacks BigBad-Wolf!
BigBad-Wolf took 585 damage (HP = 0)

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w

Hero 2 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

s
=== MONSTER TURN ===
Andrealphus attacks Muamman_Duathall!
Muamman_Duathall took 120 damage (HP = 120)

=== LEGENDS OF VALOR MAP (Round 10) ===

╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ M │ │   │ │   │ │H1/│ │   │ │   │ │ M │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │ 0 │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │ 2 │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
│   │ │   │ │   │ │   │ │   │ │   │ │   │ │   │ 
╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

Legend:
  Heroes        : │ 0 │
  Monsters      : │ M │
  Nexus         : │   │
  Wall          : │   │
  Impassible    : │   │
  Obstacle      : │   │
  Bush          : │   │
  Cave          : │   │
  Koulou        : │   │
  Plain         : │   │

=== HERO TURN ===

Hero 0 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

a

Hero 1 action:
[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game
    T  Teleport
    R  Recall
    ATK Attack
    C  Cast Spell
    U  Use Potion
    O  Remove Obstacle

w
YOU WIN! Hero reached enemy Nexus.

Process finished with exit code 0
```
