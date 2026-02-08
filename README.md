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
