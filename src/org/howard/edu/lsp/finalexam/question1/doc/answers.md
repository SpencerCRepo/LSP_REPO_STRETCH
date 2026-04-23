1. Identify two shared resources.

Two of the shared resourses are requests and nextId()

2. What concurrency problem may occur?

I think that it's a race condition since they aren't synched which can cause multiple of the same IDs.

3. Why is addRequest() unsafe?

It's unsafe because of two operations that can run at the same time which can then both call requests.add(). 