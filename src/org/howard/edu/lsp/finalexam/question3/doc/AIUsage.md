
Prompts: how do i know when i actually need @BeforeEach vs just creating the object  once at the top

ChatGPT:
Here's a clear, practical guide to help you decide between creating the object once at the field level versus using @BeforeEach.

Default JUnit 5 Behavior (Most Important Fact)
By default, JUnit 5 creates a new instance of your test class before every single @Test method.

This means:

Instance fields are reset (re-initialized) for every test.
If you do this at the field level:
class MyTest {

    private final Calculator calculator = new Calculator();   // created once per test instance

    @Test
    void testAddition() { ... }

    @Test
    void testSubtraction() { ... }
}
→ Each test gets its own fresh Calculator automatically. No shared state between tests.

When you can (and should) just create the object at the top (field level)
Use simple field initialization when:

The object is immutable or has no mutable state that tests can modify.
Creating it is cheap (no heavy I/O, no database connections, no network, etc.).
You want the object to be fresh for every test (which is the default and usually desired).
The constructor takes no parameters or only simple ones.
Examples of good candidates:

Plain POJOs / DTOs
Simple service classes with no dependencies
Immutable objects (LocalDateTime.now() is not immutable in effect)
Objects created with new or simple factories
private final UserService userService = new UserService(new InMemoryUserRepo());
This is clean, readable, and preferred by many when it works.

When you should use @BeforeEach instead
Use @BeforeEach when:

The object has mutable state that previous tests might leave dirty
(e.g., a list that gets items added, a counter that increments, a mock that records calls).
You need to reset state between tests (clear a list, reset a counter, etc.).
Creation is more complex — involves multiple steps, mocks setup, or temporary resources.
You need to pair it with @AfterEach (e.g., closing resources, clearing caches, stopping embedded servers).
You're using @TestInstance(Lifecycle.PER_CLASS) (one test instance for the whole class) — then fields are shared, so you almost always need @BeforeEach to reset.
Example:

class RequestManagerTest {

    private RequestManager manager;        // declared here, but NOT initialized
    private List<Request> requests;

    @BeforeEach
    void setUp() {
        manager = new RequestManager();    // fresh instance every test
        requests = new ArrayList<>();      // reset collection
        // or: Mockito.reset(mocks); etc.
    }

    @Test
    void shouldGenerateUniqueIds() { ... }
}
Quick Decision Table
Situation	Recommended Approach	Why
Simple immutable / stateless object	Field initialization	Cleanest, automatic fresh instance
Cheap to create, no side effects	Field initialization	Simple and sufficient
Object has mutable state (lists, counters...)	@BeforeEach	Prevents test pollution
Needs reset + cleanup (@AfterEach)	@BeforeEach + @AfterEach	Symmetry and correctness
Expensive setup (DB, server, heavy mocks)	@BeforeAll (if shared safely) or @BeforeEach	Performance vs isolation
Using @TestInstance(PER_CLASS)	Almost always @BeforeEach	State is shared otherwise
Modern Best Practices (2025–2026)
Many experienced developers now prefer field initialization when possible (especially with constructor injection and immutable objects) because it reduces boilerplate.
Still use @BeforeEach for anything that needs explicit reset or pairs with teardown.
For mocks: Many people now initialize them at field level with @Mock + @ExtendWith(MockitoExtension.class) and reset only when necessary.
Keep @BeforeEach methods light — avoid complex logic.
Bonus Tip: Constructor Injection in Tests
You can also do this (very clean):

class MyTest {

    private final Calculator calculator;

    MyTest() {                     // JUnit calls this constructor
        this.calculator = new Calculator();
    }
}
Or even better with parameters if you're using extensions.

Rule of thumb:

Start with field initialization.
Move to @BeforeEach the moment you notice one test affecting another (flaky tests, order-dependent results) or when you need cleanup.
