# Java Data Structures by Jack Ritchie

This repository contains a collection of commonly used data structures implemented in Java. Each data structure is organized into appropriate directories and follows best practices for code structure, readability, and testing. The project also includes comprehensive unit tests to ensure correctness.

## Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Data Structures](#data-structures)
    - [Array-Based Structures](#array-based-structures)
    - [Linked Structures](#linked-structures)
    - [Map Structures](#map-structures)
    - [Heap Structures](#heap-structures)
    - [Tree Structures](#tree-structures)
- [Interfaces](#interfaces)
- [Utilities](#utilities)
- [Tests](#tests)
- [How to Build and Run](#how-to-build-and-run)
- [How to Contribute](#how-to-contribute)
- [License](#license)

## Overview

This project provides a comprehensive set of data structure implementations in Java. The repository is designed to help developers and students understand data structures through well-documented code and unit tests.

## Project Structure

Here's an overview of the directory structure:

```
Java-Data-Structures/
│-- .lib/
│-- .vscode/
│-- src/
│   ├── main/
│   │   └── java/
│   │       └── structures/
│   │           ├── ArrayBasedStructures/
│   │           ├── HeapStructures/
│   │           ├── Interfaces/
│   │           ├── LinkedStructures/
│   │           ├── MapStructures/
│   │           ├── TreeStructures/
│   │           ├── Utils/
│   │           └── PriorityQueue.java
│-- test/
│   └── java/
│       └── structures/
│           ├── ArrayDequeTest.java
│           ├── ArrayListTest.java
│           ├── ArraySetTest.java
│           ├── ArrayStackTest.java
│           ├── ArrayWrapperTest.java
│           ├── BinTreeTest.java
│           ├── CircularLinkedListTest.java
│           ├── ConsListTest.java
│           ├── ConsMapTest.java
│           ├── ConsStackTest.java
│           ├── DisjointSetTest.java
│           ├── DoublyLinkedListTest.java
│           ├── HashMapTest.java
│           ├── HeapTest.java
│           ├── ListUtilsTest.java
│           ├── PrefixTrieTest.java
│           ├── PriorityQueueTest.java
│           └── RingQueueTest.java
│-- .gitignore
│-- .projectile
│-- PROBLEMS.md
│-- README.md
│-- pom.xml
│-- style.xml
│-- test.pl
```

## Data Structures

### Array-Based Structures

Located in `structures/ArrayBasedStructures/`:

- `ArrayDeque.java`: Double-ended queue using an array.
- `ArrayList.java`: Dynamic array list implementation.
- `ArraySet.java`: Set implementation using an array.
- `ArrayStack.java`: Stack implementation using an array.
- `RingQueue.java`: Circular queue implementation.

### Linked Structures

Located in `structures/LinkedStructures/`:

- `CircularLinkedList.java`: Circular linked list implementation.
- `ConsList.java`: Linked list based on cons cells.
- `ConsStack.java`: Stack using cons cells.
- `DoublyLinkedList.java`: Doubly linked list implementation.

### Map Structures

Located in `structures/MapStructures/`:

- `ConsMap.java`: Map using cons cells.
- `DisjointSet.java`: Disjoint set (union-find) implementation.
- `HashMap.java`: Hash map implementation.

### Heap Structures

Located in `structures/HeapStructures/`:

- `MinHeap.java`: Min-heap implementation.
- `MaxHeap.java`: Max-heap implementation.

### Tree Structures

Located in `structures/TreeStructures/`:

- `BinBranch.java`: Binary tree branch node.
- `BinLeaf.java`: Binary tree leaf node.
- `PrefixTrie.java`: Trie (prefix tree) implementation.

## Interfaces

Located in `structures/Interfaces/`:

- `BinTree.java`: Interface for binary trees.
- `CircularList.java`: Interface for circular lists.
- `Deque.java`: Interface for double-ended queues.
- `DisjointSet.java`: Interface for disjoint sets.
- `Heap.java`: Interface for heaps.
- `Map.java`: Interface for maps.
- `Queue.java`: Interface for queues.
- `Set.java`: Interface for sets.
- `Stack.java`: Interface for stacks.
- `Trie.java`: Interface for tries.

## Utilities

Located in `structures/Utils/`:

- `ArrayWrapper.java`: Utility wrapper for arrays.
- `ListUtils.java`: Utility methods for lists.

## Tests

The project includes unit tests for each data structure to ensure correctness. Tests are located in the `src/test/java/structures/` directory. Here are the available tests:

- `ArrayDequeTest.java`
- `ArrayListTest.java`
- `ArraySetTest.java`
- `ArrayStackTest.java`
- `ArrayWrapperTest.java`
- `BinTreeTest.java`
- `CircularLinkedListTest.java`
- `ConsListTest.java`
- `ConsMapTest.java`
- `ConsStackTest.java`
- `DisjointSetTest.java`
- `DoublyLinkedListTest.java`
- `HashMapTest.java`
- `HeapTest.java`
- `ListUtilsTest.java`
- `PrefixTrieTest.java`
- `PriorityQueueTest.java`
- `RingQueueTest.java`

### Running the Tests

To run the tests using Maven, execute the following command in the project root:

```bash
mvn test
```

## How to Build and Run

### Prerequisites

- Java Development Kit (JDK) (version 11 or higher)
- Maven (for dependency management and build automation)

### Build the Project

Run the following command in the project root directory:

```bash
mvn clean install
```

This will compile the source code and run the tests.

## How to Contribute

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bugfix:

        ```bash
        git checkout -b feature-branch
        ```

3. Make your changes and ensure the tests pass.
4. Commit your changes:

        ```bash
        git commit -m "Add new feature"
        ```

5. Push to your fork:

        ```bash
        git push origin feature-branch
        ```

6. Create a pull request.

## License

This project is licensed under the MIT License.
