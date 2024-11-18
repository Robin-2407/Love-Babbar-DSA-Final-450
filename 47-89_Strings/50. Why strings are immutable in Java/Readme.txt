Why Strings are Immutable in Java:

Security: Prevents unintentional changes to sensitive data like passwords.
String Pool: Optimizes memory by reusing identical string literals.
Thread Safety: Strings are inherently thread-safe, as they cannot be changed after creation.
Optimization: Enables efficient string handling, caching, and memory reuse.
Consistency in Hashing: The hash code remains constant, making strings reliable as keys in hash-based collections.
Simplicity: Immutability simplifies code, reduces side effects, and improves debugging.

-------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------

Overcoming String Immutability in Java:
To modify strings when needed, use these alternatives:

StringBuilder: For efficient string modification in single-threaded environments.

StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb.toString());  // Output: Hello World
StringBuffer: Thread-safe alternative to StringBuilder for multi-threaded environments.

-------------------------------------------------------------------------------------------------------------------------


StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb.toString());  // Output: Hello World
CharArray: Convert the string to a character array, modify it, and convert it back.

-------------------------------------------------------------------------------------------------------------------------


char[] chars = str.toCharArray();
chars[0] = 'H';
String modifiedStr = new String(chars);
System.out.println(modifiedStr);  // Output: Hello
Custom Mutable Class: Create your own class for mutable string-like behavior.

-------------------------------------------------------------------------------------------------------------------------


class MutableString {
    private StringBuilder sb;
    public MutableString(String str) {
        sb = new StringBuilder(str);
    }
    public void append(String str) {
        sb.append(str);
    }
    public String getValue() {
        return sb.toString();
    }
}
These methods allow you to modify strings when necessary, bypassing the immutability of the String class while maintaining performance and thread-safety.

-------------------------------------------------------------------------------------------------------------------------