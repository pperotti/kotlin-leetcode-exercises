# The MovieDB Android Application (TMDBApp)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Introduction

This repo contains my solutions to different LeetCode Problems from the Data Structures and Algorithms Course.

## Features

Here the developer can find problems about: 
* Arrays & Strings
* Hashing
* LinkedLists
* Stacks & Queues
* Trees & Graph (Currently in Progress)

## Getting Started

### Prerequisites

Have IntelliJ IDEA with a recent Java SDK installed.

### Installation

Provide step-by-step instructions on how to set up and run your project.

1. Clone the repository:
   ```sh
   git clone git@github.com:pperotti/kotlin-leetcode-exercises.git
   ```
2. Open the project in IntelliJ Idea.
3. Build and run the application on an emulator or connected device.

## Directory Structure

The code is organized as follows: 

* Base Package: com.kotlin.problems.leetcode
* Solutions to Problems from Course #1: under package "<base>.das"
* Solutions to Problems from Course #2: under package "<base>.mcti"
* Utility Package: "<base>.utils"

## Design Decisions

The structure is pretty straightforward, the entry point is the Main.kt class and it runs a solution to a class implementing the "Problem" interface.

Due to the simplicity of the project, it does not offer a menu or other mechanism to pick which problem you want to execute. 

## Usage

* Find the problem you want to run and update Main.kt so such class is instantiated
* Run Main.kt class

## License

This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/) - see the
[LICENSE.md](https://github.com/username/repository/blob/master/LICENSE.md) file for details.

## Acknowledgments

All the project created here was done by Pablo Perotti

- [github.com/pperotti] (GitHub)

```