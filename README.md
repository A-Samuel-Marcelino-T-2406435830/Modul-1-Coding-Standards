# *Module 1 Coding Standards*

---
## Reflection 1
Clean code implementations:
- Meaningful Names. Variables are named in a way that represents the value it holds. Such as the following:
    ```java
    Product productToDelete = findById(productId);
    ``` 
    This variable acts as a placeholder for a Product class that is going to be deleted after a finding the product in the repository. It Doesn't need a comment to explain this, since the variable's name itself is self-explanatory.
- Functions, for example:
  ```java
  public void delete(String productId) {
        Product productToDelete = findById(productId);

        if (productToDelete != null) {
            productData.remove(productToDelete);
        }
    }
  ```
  The method's name is self-explanatory and it only does one task which is to delete. 
- There are no unnecessary comments. Using clean code promotes the clarity of variable names and function separation. This leads to a code that is self-explanatory and doesn't require comments to understand. 
- Layout and Formatting are done using indentations and separation of code blocks using blank lines. This makes the program much more readable.
- However, I haven't properly implemented error handling such as try-catches. Some of my methods still return null which can cause unexpected errors. This can be improved by using Optional classes to avoid returning null values.
## Reflection 2
- Unit tests should be done in a way that it covers all public methods of a class. If a method has various results, then we should make separate tests that exercises each distinct result of that method. That way, we can have increased code coverage. However, 100% code coverage doesn't mean that our code has no bugs or errors. Code coverage indicates the lines of code that are executed during testing. Correctness depends on what we wrote on the unit test. Human error may be present when writing down unit test assertions. Sometimes we can make wrong logical assertions, which would result in a passed test while having incorrect or unintended behaviour.   
- Since the new class has the exact same setup procedures and instance variables, the code won't adhere to clean code principles. The identical setup makes the code redundant. This issue can be avoided by checking the quantity of the product in the original file CreateProductFunctionalTest.java. We just need to add a few lines of code to verify the quantity. Creating a new Java class just to verify quantity is unnecessary. 
