# Stick Hero Game - Project Documentation

## Game Link
https://stick-hero-game.vercel.app/

## Project Overview

Developed an engaging **2D game** inspired by **Stick Hero** using **JavaFX** and **Object-Oriented Programming (OOP)** principles. The game challenges players to control a character (stick-hero) navigating across platforms by stretching a stick to bridge gaps. Key features include dynamic game mechanics, scoring systems, power-ups (cherries), and an immersive experience with graphics, sound effects, and animations.

## Key Features and Technologies

- **Game Mechanics**:
  - **Character Control**: Player controls a character (stick-hero) that stretches a stick to bridge platform gaps.
  - **Platform Generation**: Randomly generated platforms of varying widths, introducing dynamic challenges.
  - **Timing & Precision**: Players must time stick extension correctly to avoid falling into the abyss.
  - **Power-ups**: The player collects cherries that add to the score and can be used for **reviving**.
  - **Revival System**: Upon falling, the player can revive using cherries, deducted from the total score.
  - **Score System**: Dynamic scoring encourages players to collect more rewards for higher scores.
  - **Save Progress**: Option for the player to save the game’s progress at any time.

- **User Interface (UI)**:
  - **JavaFX** for game graphics, animations, and scene management.
  - Smooth UI transitions and effects for better player engagement.
  
- **Sound & Graphics**:
  - Integrated **sound effects** and **animations** to create an immersive game environment.
  - Designed using custom visuals and **assets** respecting copyright and licensing restrictions.

- **Data Persistence**:
  - Implemented **file-based saving mechanism** for tracking player scores and cherry count.
  - Players can save their game progress, including highest score, last score, and total cherries.

## OOP Principles & Design Patterns

- **OOP Principles**:
  - **Encapsulation**: Game logic and data (score, cherries, character status) encapsulated in relevant classes.
  - **Abstraction**: The game mechanics abstracted into distinct modules for better readability and reusability.
  - **Polymorphism**: Used in handling various in-game interactions (such as different platform types and cherry effects).
  - **Inheritance**: Used for creating different types of platforms and game objects based on a common superclass.

- **Design Patterns**:
  - **Observer Pattern**: Used to update game state (such as character position and score) across different components of the game.
  - **Factory Pattern**: Applied to create game objects like platforms and cherries dynamically based on game progression.

## Game Development Process

- **Game Loop**: Implemented a **game loop** to handle continuous updates, collisions, and rendering.
- **Multithreading (Bonus)**: Integrated **multithreading** for efficient game processing and smoother animations.
- **Graphics & Animation**: Used **JavaFX animation API** to handle character movement, platform animations, and game transitions.

## JUnit Testing

- Developed **unit tests** using **JUnit** to ensure correctness and robustness of game components, such as character movement, scoring system, and revival logic.
- Automated tests for key gameplay mechanics and edge cases.

## Technologies Used

- **JavaFX**: For creating the GUI and game animations.
- **JUnit**: For unit testing the game logic and functionality.
- **Maven**: For dependency management and build automation.
