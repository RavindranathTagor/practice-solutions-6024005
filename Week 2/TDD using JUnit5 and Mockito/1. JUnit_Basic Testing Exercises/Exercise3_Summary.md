# Exercise 3: JUnit Assertions - 

### 1. AssertionsTest.java

A comprehensive test class demonstrating all major JUnit 5 assertions:

#### **Basic Assertions**

```java
assertEquals(5, 2 + 3);  
assertTrue(5 > 3);       
assertFalse(5 < 3);        
assertNull(null);            
assertNotNull(new Object());   
```

#### **String Assertions**

```java
assertEquals("expected", actual);
assertTrue(actual.contains("text"));
assertTrue(actual.startsWith("prefix"));
```

#### **Array & Collection Assertions**

```java
assertArrayEquals(expected, actual);
assertEquals(3, list.size());
assertTrue(list.contains("item"));
```

#### **Exception Assertions**

```java
IllegalArgumentException ex = assertThrows(
    IllegalArgumentException.class,
    () -> calculator.divide(10, 0)
);
assertEquals("Expected message", ex.getMessage());
```
