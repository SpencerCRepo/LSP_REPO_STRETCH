Part 1
()()()()()()()()
1. Identify two shared resources.

Two of the shared resourses are requests and nextId()

2. What concurrency problem may occur?

I think that it's a race condition since they aren't synched which can cause multiple of the same IDs.

3. Why is addRequest() unsafe?

It's unsafe because of two operations that can run at the same time which can then both call requests.add(). 

Part 2
()()()()()()()

Fix A: These fix won't work since you can still call requests.add() concurrently, which will corrupt the Array.

Fix B: This one works since No two threads can execute addRequest() at the same time. This is because 
Synchronizing addRequest() covers the entire operation and getNextId() 

Fix C: This only syncs the read methods and will not fix the problem. It still allows

Part 3
()()()()()()()()
1. Based on Arthur’s Riel’s heuristics, should getNextId() be public? Explain.

It shouldn't be public because it's important to keep data hidden within it's class. It should be private so RequestManager controls
ID generation entirely on its own.

    

Part 4
()()()()()()()()()

In lecture, we discussed an alternative approach to managing concurrency that does not rely on the synchronized keyword.
Describe how this alternative approach could be used to make addRequest() thread-safe.

Provide a short code snippet (5–10 lines) demonstrating how this approach would be applied to make addRequest()thread-safe.