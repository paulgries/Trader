# Boundaries

In your team, explore the code. Start at class `Main`.

Read the code line by line and discuss with your team. What are the types? What is the code doing?

Now look at `Tradable`. That means "able to be traded". In order to be tradable, an object must have a name and a value.

# Discovering a boundary

Discuss `Hatchimal`. Notice that it implements `Tradable`. That means a `Hatchimal` is a `Tradable` object.

Discuss `Pebble`. Which other file is it similar in structure to?

Discuss `Trader`. What are the two instance variables? How are objects added to those lists?

When does `evaluateTrade` return `true`?

What is the type — `Pebble` or `Hatchimal` — of the object the first time that `getTradeValue` is called?
