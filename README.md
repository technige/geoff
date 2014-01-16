[![Build Status](https://travis-ci.org/nigelsmall/geoff.png)](https://travis-ci.org/nigelsmall/geoff)

# Geoff

[http://nigelsmall.com/geoff](http://nigelsmall.com/geoff)

##Usage

The code below gives a quick example of usage.

```java
// Set up a GeoffReader from any Reader object
GeoffReader geoffReader = new GeoffReader(reader);

// And a NeoLoader for a GraphDatabaseService
NeoLoader neoLoader = new NeoLoader(database);

// Iterate through the available subgraphs
while (geoffReader.hasMore()) {
    // Read the subgraph
    Subgraph subgraph = geoffReader.readSubgraph();
    try (Transaction tx = database.beginTx()) {
        // And load it into the database, returning the named nodes
        Map<String, Node> nodes = neoLoader.load(subgraph);
        // Maybe do something with the returned nodes here
        // ...
        tx.success();
    }
}
```
