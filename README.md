# SparseArray Or ArrayMap?

## Experiment

I created this project to test how long it would take to a `SparseArray` and an `ArrayMap` been created with 100,000 objects.

The results I got (in miliseconds):

![http://i.imgur.com/yZKYEGO.png](http://i.imgur.com/yZKYEGO.png)

According to documentation, both [SparseArray](http://developer.android.com/reference/android/util/SparseArray.html) and [ArrayMap](https://developer.android.com/reference/android/support/v4/util/ArrayMap.html) ins't good for appropriate for data structures that may contain large numbers of items and both will fall behind HashMap when it comes to handle large data structures. Also, for containers holding up to hundreds of items, both have not significant performance difference, less than 50%.

However, I still think `SparseArray` is lighter and faster than `ArrayMap`:

![http://i.imgur.com/vJrRerE.png](http://i.imgur.com/vJrRerE.png)

But for the source we want to load, they are basically the same.
