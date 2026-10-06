# Data-Structures-from-Scratch
A collection of generic data structures implemented from scratch in Java as part of a university coursework project.

The project avoids Java collection implementations such as `LinkedList`, `HashMap`, and `Heap`. It focuses on understanding how common data structures work internally and applying them to a film metadata, ratings, and credits data store.

## Implemented Data Structures

- **HashMap<K, V>**
  - Generic key-value storage using hashing and collision handling.
  - Supports average-case O(1) insertion, lookup, update, and removal.

- **LinkedList<T>**
  - Generic linked-list implementation for dynamically sized ordered data.
  - Used for collections of IDs and records where elements are frequently added or removed.

- **Heap<T>**
  - Generic max-heap implementation.
  - Supports O(log n) insertion and removal of the maximum-ranked item.
  - Used for queries such as most-rated and highest-average-rated films.

- **Merge Sort**
  - O(n log n) sorting implementation used to order credit data, such as cast billing order and crew IDs.

## Example Use Cases

These structures were designed to support operations including:

- Film lookup by ID
- User and movie rating storage
- Rating averages and top-rated films
- Film collection membership
- Cast and crew credit indexing
- Top-billed cast queries
- Searching and filtering film records

## Technologies

- Java
- Gradle
- JUnit

## Note

This repository contains only the data-structure implementations created for the coursework. The surrounding coursework application, datasets, and assessment materials are not included.
