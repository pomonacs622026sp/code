# Getting Started

Here are some notes are creating a new Java project.

1. In VSCode: `Java: Create Java Project`

2. Initialize git: `git init .` (or use the VSCode buttons)

3. Create a "useful" .gitignore file ([here is one source](https://www.toptal.com/developers/gitignore/))

4. Create LICENSE

5. Compile and run the project: `javac -d bin src/*.java; java -cp bin App`

## The Sushi for Two Problem

Here is a description of the [Sushi for Two](https://codeforces.com/contest/1138/problem/A) problem.

### Simple Version

Here is a simple version solving the problem using a plain loop. This implementation is based on Conor Hoekstra's implementation in [New Algorithms in C++23](https://www.youtube.com/watch?v=VZPKHqeUQqQ).

You can find the simple version in `src/SimpleLoop.java`.

### Main App

The `src/App.java` file contains the main method that generates a large random array of sushi pieces (1s and 2s), runs both the simple loop and the streams version of the algorithm, and prints out the time taken for each as well as the results.

### With Streams

We also provided several implementations built around more general programming patterns/concepts. Here is the basic algorithm:

1. Initial array: `[1, 2, 2, 1, 2, 2, 2, 1, 1]`
2. Chunk by neighboring equal elements: `[[1], [2, 2], [1], [2, 2, 2], [1, 1]]`
3. Count the length of each chunk: `[1, 2, 1, 3, 2]`
4. Create pairs of adjacent lengths: `[(1, 2), (2, 1), (1, 3), (3, 2)]`
5. Compute the minimum of pairs: `[1, 1, 1, 2]`
6. Find the overall maximum: `2`
7. Multiply by 2: `4`

```java
// https://github.com/tginsberg/gatherers4j
return 2 * Arrays.stream(sushiArray)
        .boxed()
        .gather(Gatherers4j.group())
        .map(java.util.List::size)
        .gather(Gatherers4j.zipWithNext())
        .map(w -> Math.min(w.get(0), w.get(1)))
        .max(Integer::compare)
        .orElse(0);
```

### Other Languages

#### C++

```c++
// The full example (including `main` and an example input) is not provided
using namespace std::views;
2 * std::ranges::max(array
    | chunk_by(std::equal_to{})
    | transform(std::ranges::distance)
    | adjacent_transform<2>(std::ranges::min));
```

#### Python

```python
from itertools import groupby, pairwise
runs = [sum(1 for _ in g) for _, g in groupby(array)]
c = 2 * max(min(a, b) for a, b in pairwise(runs))
```

#### Haskell

```haskell
-- Try on: https://play.haskell.org/
import Data.List (group)
main :: IO ()
main = print (sushiForTwo [1, 1, 1, 0, 0, 1, 1, 1, 1])
sushiForTwo = (2 *) . maximum . (\xs -> zipWith min xs (tail xs)) . map length . group
```

#### APL

```apl
⍝ Try on:https://arraybox.dev/
array  ← 1 2 2 1 2 2 2 1 1
2× ⌈/ 2⌊/ ≢¨ (1, 2≠/ array) ⊂ array
```

- `2≠/array`      : (not-equal reduce) marks where adjacent elements differ
- `1, ...`        : (catenate) always starts a new first group
- `(...) ⊂ array` : (partition-enclose) split into runs
- `≢¨ ...`        : (tally each) lengths of runs
- `2⌊/ ...`       : (min reduce pairs) min of each adjacent pair
- `⌈/ ...`        : (max reduce) max of those
- `2 × ...`       : (times) multiply by 2

#### Uiua

```uiua
# Try on: https://www.uiua.org/pad
[1 2 2 1 2 2 2 1 1]
⊸∘     # (by identity) creates a duplicate of the array
⊜□     # (partition by box) group by neighboring equal elements
≡(⧻°□) # (rows (length un box))
⤙↘ 1   # (with drop 1) drop the first value of array 2
↘ ¯1   # (drop -1) drop the last value of array 1
↧      # (min) take the min from each array
/↥     # (max reduce) take the max of the resulting array
×2     # (times 2) multiply by 2
```
